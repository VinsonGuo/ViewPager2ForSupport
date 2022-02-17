package com.vinsonguo.viewpager2.demo

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class TestFragment:Fragment() {

    companion object{
        fun newInstance(index: Int) = TestFragment().apply {
            val args = Bundle()
            args.putInt("index", index)
            arguments = args
        }
    }

    private val TAG by lazy {
        "TestFragment" + arguments?.getInt("index")
    }

    private lateinit var tv:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d(TAG, "onCreate \n")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        tv = TextView(context)
        tv.append("onCreateView \n")
        Log.d(TAG, "onCreateView \n")
        return tv
    }

    override fun onStart() {
        super.onStart()
        tv.append("onStart \n")
        Log.d(TAG, "onStart \n")
    }

    override fun onResume() {
        super.onResume()
        tv.append("onResume \n")
        Log.d(TAG, "onResume \n")
    }

    override fun onPause() {
        super.onPause()
        tv.append("onPause \n")
        Log.d(TAG, "onPause \n")
    }

    override fun onStop() {
        super.onStop()
        tv.append("onStop \n")
        Log.d(TAG, "onStop \n")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        tv.append("onDestroyView \n")
        Log.d(TAG, "onDestroyView \n")
    }

    override fun onDestroy() {
        super.onDestroy()
        tv.append("onDestroy \n")
        Log.d(TAG, "onDestroy \n")
    }
}