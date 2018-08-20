package com.worldline.domain.interactor

import com.worldline.domain.executor.Executor
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver

/**
 * SingleInteractor.
 */
abstract class SingleInteractor<T : Any>(private val executor: Executor,
                                         private val compositeDisposable: CompositeDisposable = CompositeDisposable()) {

    fun execute(onSuccess: (T) -> Unit,
                onError: (Throwable) -> Unit): Single<T> {
        val single = buildSingle()
                .subscribeOn(executor.new())
                .observeOn(executor.main())

        compositeDisposable.add(single
                .subscribeWith(object : DisposableSingleObserver<T>() {
                    override fun onError(e: Throwable) {
                        onError(e)
                    }

                    override fun onSuccess(t: T) {
                        onSuccess(t)
                    }

                }))

        return single
    }

    fun clear() {
        compositeDisposable.clear()
    }

    abstract fun buildSingle(): Single<T>
}
