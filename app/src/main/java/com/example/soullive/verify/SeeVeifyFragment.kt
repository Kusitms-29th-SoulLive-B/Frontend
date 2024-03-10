package com.example.soullive.verify

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.soullive.databinding.FragmentSeeverifyBinding
import com.example.soullive.databinding.FragmentVerifyBinding
import com.example.soullive.verify_result_go.VerifyResultActivity1
import com.example.soullive.verify_result_it.VerifyResultActivity2

class SeeVeifyFragment : Fragment() {

    lateinit var binding: FragmentSeeverifyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSeeverifyBinding.inflate(inflater, container, false)

        binding.itssupIv.setOnClickListener {
            val intent = Intent(requireContext(), VerifyResultActivity2::class.java)
            startActivity(intent)
        }

        binding.searchIb.setOnClickListener {
            val intent = Intent(requireContext(), VerifyResultActivity2::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}