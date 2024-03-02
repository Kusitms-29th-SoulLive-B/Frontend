package com.example.soullive

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.soullive.databinding.FragmentSeeverifyBinding
import com.example.soullive.databinding.FragmentVerifyBinding

class SeeVeifyFragment : Fragment() {

    lateinit var binding: FragmentSeeverifyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeeverifyBinding.inflate(inflater, container, false)

        return binding.root
    }
}