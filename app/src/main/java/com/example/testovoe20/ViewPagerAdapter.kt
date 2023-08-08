package com.example.testovoe20

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter

class ViewPagerAdapter (fm: FragmentManager) : FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    private val fragmentList = mutableListOf<Fragment>()
    private val titleList = mutableListOf<String>()

    // Метод для добавления фрагмента и заголовка в адаптер
    fun addFragment(fragment: Fragment, title: String) {
        fragmentList.add(fragment)
        titleList.add(title)
    }

    // Получение фрагмента по позиции
    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    // Получение общего количества вкладок
    override fun getCount(): Int {
        return fragmentList.size
    }

    // Получение заголовка вкладки по позиции
    override fun getPageTitle(position: Int): CharSequence? {
        return ""
    }
}