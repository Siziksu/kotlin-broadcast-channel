package com.siziksu.ui.view.secondary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.siziksu.ui.R
import com.siziksu.ui.common.channel.ChannelObserver
import kotlinx.android.synthetic.main.fragment_secondary.secondaryButton
import kotlinx.android.synthetic.main.fragment_secondary.secondaryValue
import kotlinx.android.synthetic.main.toolbar.toolbar
import org.koin.android.ext.android.getKoin

class SecondaryFragment : Fragment() {

    private lateinit var channelObserver: ChannelObserver

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        channelObserver = getKoin().get()
        return inflater.inflate(R.layout.fragment_secondary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onDestroy() {
        super.onDestroy()
        channelObserver.unsubscribe()
    }

    private fun initViews() {
        activity?.let { (activity as AppCompatActivity).setSupportActionBar(toolbar) }
        secondaryButton.setOnClickListener { activity?.onBackPressed() }
        channelObserver.onReceive { secondaryValue.text = getString(R.string.value, it) }
    }
}
