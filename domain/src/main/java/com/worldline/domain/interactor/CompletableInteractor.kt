package com.worldline.domain.interactor

import com.worldline.domain.executor.Executor
import io.reactivex.Completable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver

/**
 * CompletableInteractor.
 */
abstract class CompletableInteractor(private val executor: Executor,
                                     private val compositeDisposable: CompositeDisposable = CompositeDisposable()) {

    protected fun execute(onComplete: () -> Unit,
                          onError: (Throwable) -> Unit,
                          completable: Completable): Completable {
        val completableWithSchedulers = completable
                .subscribeOn(executor.new())
                .observeOn(executor.main())

        compositeDisposable.add(completableWithSchedulers
                .subscribeWith(object : DisposableCompletableObserver() {
                    override fun onComplete() {
                        onComplete()
                    }

                    override fun onError(e: Throwable) {
                        onError(e)
                    }

                }))

        return completableWithSchedulers
    }

    fun clear() {
        compositeDisposable.clear()
    }

    abstract fun execute(onComplete: () -> Unit,
                         onError: (Throwable) -> Unit)
}
