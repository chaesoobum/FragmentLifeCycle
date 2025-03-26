package com.csb.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.csb.myapplication.databinding.FragmentSecondBinding

class SecondFragment() : Fragment() {
    private var _binding:FragmentSecondBinding? = null
    private val binding get() = _binding!!
    private var mainActivity: MainActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            mainActivity = context
        }
        Log.d("LifecycleLog","SecondFragment.onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LifecycleLog","SecondFragment.onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSecondBinding.inflate(inflater,container,false)

        Log.d("LifecycleLog","SecondFragment.onCreateView()")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("LifecycleLog","SecondFragment.onViewCreated()")
    }

//    override fun onViewStateRestored(savedInstanceState: Bundle?) {
//        super.onViewStateRestored(savedInstanceState)
//        Log.d("LifecycleLog","SecondFragment.onViewStateRestored()")
//    }

    override fun onStart() {
        super.onStart()
        Log.d("LifecycleLog","SecondFragment.onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifecycleLog","SecondFragment.onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifecycleLog","SecondFragment.onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifecycleLog","SecondFragment.onStop()")
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        Log.d("LifecycleLog","SecondFragment.onSaveInstanceState()")
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("LifecycleLog","SecondFragment.onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifecycleLog","SecondFragment.onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        mainActivity = null
        Log.d("LifecycleLog","SecondFragment.onDetach()")
    }



}