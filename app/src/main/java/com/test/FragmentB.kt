package com.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

class FragmentB : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        return view
    }

    companion object {

        private var fragmentB: FragmentB? = null

        fun getInstance(): FragmentB {
            if (fragmentB == null) {
                fragmentB = FragmentB()
            }
            return fragmentB!!
        }
    }


}