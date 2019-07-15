package com.siziksu.ui.common.channel

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.launch
import org.koin.standalone.StandAloneContext

class ChannelPublisher {

    private val channel: BroadcastChannel<Int> = StandAloneContext.getKoin().koinContext.get()

    fun publish(element: Int) {
        GlobalScope.launch { channel.send(element) }
    }
}
