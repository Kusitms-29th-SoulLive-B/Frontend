package com.example.soullive.verify

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.soullive.R
import com.example.soullive.databinding.FragmentVerifyBinding
import com.google.android.material.tabs.TabLayout

class VerifyFragment : Fragment() {

    lateinit var binding: FragmentVerifyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentVerifyBinding.inflate(inflater, container, false)



        childFragmentManager.beginTransaction()
            .replace(R.id.tab_layout_container, DoVerifyFragment().apply {})
            .commit()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        setTabLayout()
    }

    private fun setTabLayout() {
        binding.verifyTablayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                when (tab?.position) {
                    0 -> {
                        childFragmentManager.beginTransaction()
                            .replace(R.id.tab_layout_container, DoVerifyFragment().apply {})
                            .commit()
                    }
                    1 -> {
                        childFragmentManager.beginTransaction()
                            .replace(R.id.tab_layout_container, SeeVeifyFragment().apply {})
                            .commit()
                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabReselected(tab: TabLayout.Tab?) {}
        })
    }
}