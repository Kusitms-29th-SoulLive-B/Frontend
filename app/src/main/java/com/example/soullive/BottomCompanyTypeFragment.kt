package com.example.soullive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomCompanyTypeFragment : BottomSheetDialogFragment() {

    interface TypeChangeListener {
        fun onTypeChanged(type: String)
    }

    private var typeChangeListener: TypeChangeListener? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_bottom_company_type, container, false)

        // BottomSheet 높이/스타일 설정
        dialog?.setOnShowListener {
            val bottomSheetDialog = it as BottomSheetDialog
            val bottomSheet = bottomSheetDialog.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            val layoutParams = bottomSheet?.layoutParams
            bottomSheet?.setBackgroundResource(R.drawable.bottom_sheet_rounded_corner)
            layoutParams?.height = 1300
            bottomSheet?.layoutParams = layoutParams
        }

        val button1 = view.findViewById<TextView>(R.id.search1)
        button1.setOnClickListener {
            typeChangeListener?.onTypeChanged("광고/마케팅")
            dismiss() // 다이얼로그 닫기
        }

        val button2 = view.findViewById<TextView>(R.id.search2)
        button2.setOnClickListener {
            typeChangeListener?.onTypeChanged("IT")
            dismiss() // 다이얼로그 닫기
        }

        val button3 = view.findViewById<TextView>(R.id.search3)
        button3.setOnClickListener {
            typeChangeListener?.onTypeChanged("영업/고객상담")
            dismiss() // 다이얼로그 닫기
        }

        val button4 = view.findViewById<TextView>(R.id.search4)
        button4.setOnClickListener {
            typeChangeListener?.onTypeChanged("경영/사무")
            dismiss() // 다이얼로그 닫기
        }

        val button5 = view.findViewById<TextView>(R.id.search5)
        button5.setOnClickListener {
            typeChangeListener?.onTypeChanged("생산/제조")
            dismiss() // 다이얼로그 닫기
        }

        val button6 = view.findViewById<TextView>(R.id.search6)
        button6.setOnClickListener {
            typeChangeListener?.onTypeChanged("교육")
            dismiss() // 다이얼로그 닫기
        }

        return view
    }

    fun setTypeChangeListener(listener: TypeChangeListener) {
        this.typeChangeListener = listener
    }

}