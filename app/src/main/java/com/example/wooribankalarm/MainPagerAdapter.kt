package com.example.wooribankalarm

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.wooribankalarm.history.HistoryFragment
import com.example.wooribankalarm.story.StoryFragment

class MainPagerAdapter(fm:FragmentManager):
   FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT){
        override fun getItem(position:Int): Fragment{
            return when(position){
                0-> HistoryFragment()
                1-> StoryFragment()
                else -> AlarmFragment()
            }
        }
    override fun getCount() =3
}