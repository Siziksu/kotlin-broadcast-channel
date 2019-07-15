package com.siziksu.ui.view.primary

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.siziksu.ui.R
import com.siziksu.ui.common.channel.ChannelObserver
import kotlinx.android.synthetic.main.fragment_primary.primaryButton
import kotlinx.android.synthetic.main.fragment_primary.primaryValue
import kotlinx.android.synthetic.main.toolbar.toolbar
import org.koin.android.ext.android.getKoin

class PrimaryFragment : Fragment() {

    private lateinit var channelObserver: ChannelObserver

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        channelObserver = getKoin().get()
        return inflater.inflate(R.layout.fragment_primary, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    override fun onResume() {
        super.onResume()
        channelObserver.pause = false
    }

    override fun onPause() {
        super.onPause()
        channelObserver.pause = true
    }

    override fun onDestroy() {
        super.onDestroy()
        channelObserver.unsubscribe()
    }

    private fun initViews() {
        activity?.let { (activity as AppCompatActivity).setSupportActionBar(toolbar) }
        primaryButton.setOnClickListener { findNavController().navigate(PrimaryFragmentDirections.toSecondary()) }
        channelObserver.onReceive { primaryValue.text = getString(R.string.value, it) }
    }
}
