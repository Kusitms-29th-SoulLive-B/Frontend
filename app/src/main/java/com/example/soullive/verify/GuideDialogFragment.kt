package com.example.soullive.verify

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import com.example.soullive.databinding.FragmentGuideDialogBinding

class GuideDialogFragment : DialogFragment() {

    lateinit var binding: FragmentGuideDialogBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        binding = FragmentGuideDialogBinding.inflate(inflater, container, false)


        dialog?.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        //dialog?.window?.setBackgroundDrawableResource(R.drawable.nameedit_box)
        dialog?.window?.setGravity(Gravity.CENTER)


        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.closeBtn.setOnClickListener {

            // 다이얼로그 종료
            dismiss()
        }
    }

    override fun onResume() {
        super.onResume()

        val windowManager = context?.getSystemService(Context.WINDOW_SERVICE) as WindowManager
        val display = windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)

        val params: ViewGroup.LayoutParams? = dialog?.window?.attributes
        val deviceHeight = size.y
        val deviceWidth = size . x

        // 다이얼로그의 높이를 디바이스 높이의 25%로 설정
        //params?.height = (deviceHeight * 0.25).toInt()
        //params?.width = (deviceWidth * 0.85).toInt()

        dialog?.window?.attributes = params as WindowManager.LayoutParams
    }

}