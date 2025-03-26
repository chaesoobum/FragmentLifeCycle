package com.csb.myapplication

import android.os.Bundle
import android.text.TextUtils.replace
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.csb.myapplication.databinding.ActivityMainBinding
import com.google.android.material.transition.MaterialSharedAxis

class MainActivity : AppCompatActivity() {
    private var _binding:ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        supportFragmentManager.commit { replace(R.id.containerMain, FirstFragment()) }
    }

    // 프래그먼트를 교체하는 함수
    fun replaceFragment(fragmentName: FragmentName, isAddToBackStack:Boolean, dataBundle: Bundle?){
        // 프래그먼트 객체
        val newFragment = when(fragmentName){
            FragmentName.FIRST_FRAGMENT -> FirstFragment()
            FragmentName.SECOND_FRAGMENT -> SecondFragment()
        }

        // bundle 객체가 null이 아니라면
        if(dataBundle != null){
            newFragment.arguments = dataBundle
        }

        // 프래그먼트 교체
        supportFragmentManager.commit {

            newFragment.exitTransition = MaterialSharedAxis(MaterialSharedAxis.X, /* forward= */ true)
            newFragment.reenterTransition = MaterialSharedAxis(MaterialSharedAxis.X, /* forward= */ false)
            newFragment.enterTransition = MaterialSharedAxis(MaterialSharedAxis.X, /* forward= */ true)
            newFragment.returnTransition = MaterialSharedAxis(MaterialSharedAxis.X, /* forward= */ false)

            replace(R.id.containerMain, newFragment)
            if(isAddToBackStack){
                addToBackStack(fragmentName.str)
            }
        }
    }

    // 프래그먼트를 BackStack에서 제거하는 메서드
    fun removeFragment(fragmentName: FragmentName){
        supportFragmentManager.popBackStack(fragmentName.str, FragmentManager.POP_BACK_STACK_INCLUSIVE)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

// 프래그먼트들을 나타내는 값들
enum class FragmentName(var number:Int, var str:String){
    FIRST_FRAGMENT(1, "firstFragment"),
    SECOND_FRAGMENT(2, "SecondFragment"),
}