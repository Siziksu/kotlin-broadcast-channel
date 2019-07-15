package com.siziksu.ui.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.siziksu.ui.R
import com.siziksu.ui.common.channel.ChannelPublisher
import kotlinx.android.synthetic.main.activity_main.mainAddButton
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {

    private val channelPublisher: ChannelPublisher by inject()
    private var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initializeViews()
    }

    private fun initializeViews() {
        channelPublisher.publish(++number)
        mainAddButton.setOnClickListener { channelPublisher.publish(++number) }
    }
}
