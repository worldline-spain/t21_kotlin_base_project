package com.worldline.t21kotlinbaseproject.presenter

import com.worldline.domain.model.Result
import com.worldline.t21kotlinbaseproject.error.ErrorHandler
import com.worldline.t21kotlinbaseproject.executor.Executor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob

/**
 * Presenter
 */
abstract class Presenter<out V : Presenter.View>(
        protected val errorHandler: ErrorHandler,
        executor: Executor,
        val view: V) {

    private val job = SupervisorJob()

    protected val scope = CoroutineScope(job + executor.main)

    abstract fun attach()

    abstract fun detach()

    protected fun onError(callback: (String) -> Unit): (Result.Error) -> Unit = {
        view.hideProgress()

        val message = errorHandler.convert(it)

//        Crashlytics.logException(it)
        callback(message)
    }

    interface View {
        fun showProgress()

        fun hideProgress()

        fun showError(error: String)

        fun showError(errorId: Int)

        fun showMessage(message: String)

        fun showMessage(messageId: Int)
    }
}