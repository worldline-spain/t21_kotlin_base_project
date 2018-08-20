package com.worldline.domain.interactor

import com.worldline.domain.executor.Executor
import io.reactivex.Observable
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver

/**
 * ObservableInteractor.
 */
abstract class ObservableInteractor<T : Any>(private val executor: Executor,
                                             private val compositeDisposable: CompositeDisposable = CompositeDisposable()) {

    protected fun execute(onNext: (T) -> Unit,
                          onComplete: () -> Unit,
                          onError: (Throwable) -> Unit): Observable<T> {
        val observable = buildObservable()
                .subscribeOn(executor.new())
                .observeOn(executor.main())

        compositeDisposable.add(observable
                .subscribeWith(object : DisposableObserver<T>() {
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

        return observable
    }

    fun clear() {
        compositeDisposable.clear()
    }

    abstract fun buildObservable(): Observable<T>
}
