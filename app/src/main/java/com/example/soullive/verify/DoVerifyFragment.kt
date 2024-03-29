package com.example.soullive.verify

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.soullive.databinding.FragmentDoverifyBinding

class DoVerifyFragment : Fragment() {

    lateinit var binding: FragmentDoverifyBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDoverifyBinding.inflate(inflater, container, false)

        binding.writeIb.setOnClickListener {
            val intent = Intent(context, DoVerifyActivity1::class.java)
            startActivity(intent)
        }

        binding.fileIb.setOnClickListener {
            val intent = Intent(context, ScriptVerifyActivity::class.java)
            startActivity(intent)
        }

        return binding.root
    }
}