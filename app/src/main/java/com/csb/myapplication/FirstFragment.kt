package com.csb.myapplication

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import com.csb.myapplication.databinding.FragmentFirstBinding
import com.csb.myapplication.databinding.FragmentSecondBinding

class FirstFragment() : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private var mainActivity: MainActivity? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is MainActivity) {
            mainActivity = context
        }
        Log.d("LifecycleLog","FirstFragment.onAttach()")
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("LifecycleLog","FirstFragment.onCreate()")
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFirstBinding.inflate(inflater,container,false)

        binding.button.setOnClickListener {
            //mainActivity?.replaceFragment(FragmentName.SECOND_FRAGMENT,true,null)

            mainActivity?.supportFragmentManager?.commit {
                replace(R.id.containerMain, SecondFragment())
                     addToBackStack("SecondFragment()")
            }
        }
        //val data = savedInstanceState?.getString("저장")
        Log.d("LifecycleLog","FirstFragment.onCreateView()")
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("LifecycleLog","FirstFragment.onViewCreated()")
    }

//    override fun onViewStateRestored(savedInstanceState: Bundle?) {
//        super.onViewStateRestored(savedInstanceState)
//        val data = savedInstanceState?.getString("저장")
//        Log.d("LifecycleLog","FirstFragment.onViewStateRestored() ${data}")
//    }

    override fun onStart() {
        super.onStart()
        Log.d("LifecycleLog","FirstFragment.onStart()")
    }

    override fun onResume() {
        super.onResume()
        Log.d("LifecycleLog","FirstFragment.onResume()")
    }

    override fun onPause() {
        super.onPause()
        Log.d("LifecycleLog","FirstFragment.onPause()")
    }

    override fun onStop() {
        super.onStop()
        Log.d("LifecycleLog","FirstFragment.onStop()")
    }

//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putString("저장","저장")
//        Log.d("LifecycleLog","FirstFragment.onSaveInstanceState()")
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
        Log.d("LifecycleLog","FirstFragment.onDestroyView()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("LifecycleLog","FirstFragment.onDestroy()")
    }

    override fun onDetach() {
        super.onDetach()
        mainActivity = null
        Log.d("LifecycleLog","FirstFragment.onDetach()")
    }

}