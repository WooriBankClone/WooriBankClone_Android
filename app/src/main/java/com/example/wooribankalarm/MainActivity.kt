package com.example.wooribankalarm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.PagerAdapter
import androidx.viewpager.widget.ViewPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        vp_main.adapter=MainPagerAdapter(supportFragmentManager)
        vp_main.offscreenPageLimit=2
        vp_main.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                btnv_main.menu.getItem(position).isChecked=true
            }
        })

        btnv_main.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.menu_history->vp_main.currentItem=0
                R.id.menu_story->vp_main.currentItem=1
                R.id.menu_alarm->vp_main.currentItem=2
            }
            true
        }
    }
}
