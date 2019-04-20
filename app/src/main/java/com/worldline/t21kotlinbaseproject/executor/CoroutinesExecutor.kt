package com.worldline.t21kotlinbaseproject.executor

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

class CoroutinesExecutor : Executor {
    override val main: CoroutineDispatcher = Dispatchers.Main
}