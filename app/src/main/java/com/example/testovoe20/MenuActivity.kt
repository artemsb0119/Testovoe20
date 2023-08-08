package com.example.testovoe20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager.widget.ViewPager
import com.example.testovoe20.databinding.ActivityMenuBinding
import com.google.android.material.tabs.TabLayout

class MenuActivity : AppCompatActivity() {

    private lateinit var tabLayout: TabLayout
    private lateinit var binding: ActivityMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)
        val tabLayout = findViewById<TabLayout>(R.id.tabLayout)
        val viewPager = findViewById<ViewPager>(R.id.viewPager)

        // Создаем кастомный вид для каждой вкладки с помощью нашего макета
        val tab1: TabLayout.Tab = tabLayout.newTab()
        tab1.customView = layoutInflater.inflate(R.layout.custom_tab_layout, null)
        tab1.customView?.findViewById<ImageView>(R.id.tabIcon)?.setImageResource(R.drawable.star)
        tabLayout.addTab(tab1)

        val tab2: TabLayout.Tab = tabLayout.newTab()
        tab2.customView = layoutInflater.inflate(R.layout.custom_tab_layout, null)
        tab2.customView?.findViewById<ImageView>(R.id.tabIcon)?.setImageResource(R.drawable.ball)
        tabLayout.addTab(tab2)

        val tab3: TabLayout.Tab = tabLayout.newTab()
        tab3.customView = layoutInflater.inflate(R.layout.custom_tab_layout, null)
        tab3.customView?.findViewById<ImageView>(R.id.tabIcon)?.setImageResource(R.drawable.tennis)
        tabLayout.addTab(tab3)

        val tab4: TabLayout.Tab = tabLayout.newTab()
        tab4.customView = layoutInflater.inflate(R.layout.custom_tab_layout, null)
        tab4.customView?.findViewById<ImageView>(R.id.tabIcon)?.setImageResource(R.drawable.hockey)
        tabLayout.addTab(tab4)

        val adapter = ViewPagerAdapter(supportFragmentManager)

        adapter.addFragment(AllFragment(), "")
        adapter.addFragment(FootballFragment(), "")
        adapter.addFragment(TennisFragment(), "")
        adapter.addFragment(HockeyFragment(), "")

        viewPager.adapter = adapter

        viewPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))
        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab) {
                viewPager.currentItem = tab.position
            }

            override fun onTabUnselected(tab: TabLayout.Tab) {}

            override fun onTabReselected(tab: TabLayout.Tab) {}
        })
    }
}