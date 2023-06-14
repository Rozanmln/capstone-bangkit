package com.example.hereapp.adapter.patient

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.hereapp.ui.medical.patient.list.ListFragment

class SectionPagerAdapter(activity: AppCompatActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        val fragment = ListFragment()
        fragment.arguments = Bundle().apply {
            putInt(ListFragment.ARG_SECTION_NUMBER, position + 1)
        }
        return fragment
    }
}
