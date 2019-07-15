package com.siziksu.ui.common.channel

import kotlinx.coroutines.CompletableJob
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.consumeEach
import kotlinx.coroutines.launch
import org.koin.standalone.StandAloneContext

class ChannelObserver {

    var pause = false

    private val channel: BroadcastChannel<Int> = StandAloneContext.getKoin().koinContext.get()
    private var job: CompletableJob = Job()

    fun onReceive(func: ((Int) -> Unit)) {
        GlobalScope.launch(Dispatchers.Main + job) { channel.consumeEach { if (!pause) func(it) } }
    }

    fun unsubscribe() {
        job.cancel()
    }
}
