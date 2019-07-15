package com.siziksu.ui.di.module

import com.siziksu.ui.common.channel.ChannelObserver
import com.siziksu.ui.common.channel.ChannelPublisher
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.channels.Channel
import org.koin.dsl.module.module

val viewModule = module {

    single<BroadcastChannel<Int>> { BroadcastChannel(Channel.CONFLATED) }
    single { ChannelPublisher() }
    factory { ChannelObserver() }
}
