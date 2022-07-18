package com.example.week04day02

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {

    private var buttonOpenFirst:Button? = null
    private var buttonOpenSecond:Button? = null
    private var frameLayout:FrameLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        connectViews()
        openFragment(buttonOpenFirst!!, "FIRST_FRAGMENT", FirstFragment())
        openFragment(buttonOpenSecond!!, "SECOND_FRAGMENT", SecondFragment())
//        openFragmentOne()
//        openFragmentTwo()
    }

    private fun connectViews() {
        buttonOpenFirst = findViewById(R.id.btn_open_first_fragment)
        buttonOpenSecond = findViewById(R.id.btn_open_second_fragment)
        frameLayout = findViewById(R.id.frame_layout)
    }

//    private fun openFragmentOne() {
//        buttonOpenFirst?.setOnClickListener {
//            val fragmentTransaction:FragmentTransaction = supportFragmentManager.beginTransaction()
//            fragmentTransaction.replace(R.id.frame_layout, FirstFragment(), "FIRST_FRAGMENT")
//            fragmentTransaction.addToBackStack("FIRST_FRAGMENT")
//            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//            fragmentTransaction.commit()
//        }
//
//    }
//
//    private fun openFragmentTwo() {
//        buttonOpenSecond?.setOnClickListener {
//            val fragmentTransaction:FragmentTransaction = supportFragmentManager.beginTransaction()
//            fragmentTransaction.replace(R.id.frame_layout, SecondFragment(), "SECOND_FRAGMENT")
//            fragmentTransaction.addToBackStack("SECOND_FRAGMENT")
//            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//            fragmentTransaction.commit()
//        }
//    }

    private fun openFragment(button:Button, tag:String, fragment:Fragment) {
        button.setOnClickListener {
            val fragmentTransaction:FragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.replace(R.id.frame_layout, fragment, tag)
            fragmentTransaction.addToBackStack(tag)
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            fragmentTransaction.commit()
        }
    }
}