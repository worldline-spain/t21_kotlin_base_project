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

    fun execute(onComplete: () -> Unit,
                onError: (Throwable) -> Unit): Completable {
        val completable = buildCompletable()
                .subscribeOn(executor.new())
                .observeOn(executor.main())

        compositeDisposable.add(completable
                .subscribeWith(object : DisposableCompletableObserver() {
                    override fun onComplete() {
                        onComplete()
                    }

                    override fun onError(e: Throwable) {
                        onError(e)
                    }

                }))

        return completable
    }

    fun clear() {
        compositeDisposable.clear()
    }

    abstract fun buildCompletable(): Completable
}
