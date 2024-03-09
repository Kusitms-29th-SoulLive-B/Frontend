package com.example.soullive.verify

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.soullive.databinding.FragmentBottomsheetDialogBinding
import com.example.soullive.databinding.FragmentSaveBottomsheetDialogBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class SaveBottomsheetDialogFragment(context: Context) : BottomSheetDialogFragment() {

    lateinit var binding : FragmentSaveBottomsheetDialogBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentSaveBottomsheetDialogBinding.inflate(inflater, container, false)



        return binding.root
    }
}