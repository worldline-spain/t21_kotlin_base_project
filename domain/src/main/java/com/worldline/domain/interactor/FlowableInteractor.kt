package com.worldline.domain.interactor

import com.worldline.domain.executor.Executor
import io.reactivex.Flowable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.subscribers.DisposableSubscriber

/**
 * FlowableInteractor.
 */
abstract class FlowableInteractor<T : Any>(private val executor: Executor,
                                           private val compositeDisposable: CompositeDisposable = CompositeDisposable()) {

    protected fun execute(onNext: (T) -> Unit,
                          onComplete: () -> Unit,
                          onError: (Throwable) -> Unit,
                          flowable: Flowable<T>): Flowable<T> {
        val flowableWithSchedulers = flowable
                .subscribeOn(executor.new())
                .observeOn(executor.main())

        compositeDisposable.add(flowableWithSchedulers
                .subscribeWith(object : DisposableSubscriber<T>() {
                    override fun onComplete() {
                        onComplete()
                    }

                    override fun onNext(t: T) {
                        onNext(t)
                    }

                    override fun onError(e: Throwable) {
                        onError(e)
                    }

                }))

        return flowableWithSchedulers
    }

    fun clear() {
        compositeDisposable.clear()
    }
}
