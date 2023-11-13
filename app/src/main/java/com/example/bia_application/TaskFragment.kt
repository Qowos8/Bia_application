package com.example.bia_application

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import task_page.Page1
import task_page.Page2
import task_page.ViewPagerAdapter
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.bia_application.databinding.MenuBinding

class TaskFragment : Fragment() {
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var binding: MenuBinding
    private var isFragmentsInitialized = false

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.menu, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = binding.pager
        adapter = ViewPagerAdapter(requireActivity())
        viewPager.adapter = adapter

        val button1 = binding.button1
        val button2 = binding.button2
        button1.setOnClickListener {
            viewPager.setCurrentItem(0, true)
        }
        button2.setOnClickListener {
            viewPager.setCurrentItem(1, true)
        }
        //if (!isFragmentsInitialized) {
            initializeFragments()
           // isFragmentsInitialized = true
        //}
    }

    private fun initializeFragments() {
        val bottomNavigationView = binding.navigator
        val fragmentContainer = binding.frameContainer2

        bottomNavigationView.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.taskFragment -> {
                    replaceFragment(TaskFragment())
                    true
                }
                R.id.chart_fragment -> {
                replaceFragment(Chart_fragment())
                true
                }
                R.id.chat_fragment -> {
                    replaceFragment(Chat_fragment())
                    true
                }
                R.id.profile_fragment -> {
                    replaceFragment(Profile_fragment())
                    true
                }

                else -> false
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val transaction = requireFragmentManager().beginTransaction()
        transaction.replace(R.id.frame_container2, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }


}
