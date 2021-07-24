package com.example.custome_tablayout_with_fragment_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = MyView(supportFragmentManager)
        adapter.addFragment(AndroidFragment(),"Android")
        adapter.addFragment(KotlinFragment(),"Kotlin")
        adapter.addFragment(JavaFragment(),"Java")
        viewpager.adapter = adapter
        tabLayout.setupWithViewPager(viewpager)
    }

    class MyView(manager: FragmentManager) : FragmentPagerAdapter(manager) {
        val fragmentList: MutableList<Fragment> = ArrayList()
        val titleList: MutableList<String> = ArrayList()

        override fun getCount(): Int {
           return titleList.size
        }

        override fun getItem(position: Int): Fragment {
            return fragmentList[position]
        }

        override fun getPageTitle(position: Int): CharSequence? {
            return titleList[position]
        }
        fun addFragment(fm : Fragment, title:String){
            fragmentList.add(fm)
            titleList.add(title)
        }
    }
}