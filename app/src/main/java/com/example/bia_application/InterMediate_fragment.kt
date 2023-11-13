package com.example.bia_application

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import kotlin.properties.Delegates

class InterMediate_fragment : Fragment() {
    private var isTransitionDone = false
    private val handler = Handler()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.intermediatefragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (!isTransitionDone && !requireFragmentManager().isStateSaved) {
            handler.postDelayed({
                try {
                    if (viewLifecycleOwner.lifecycle.currentState.isAtLeast(Lifecycle.State.CREATED)) {
                        val fragment = TaskFragment()
                        parentFragmentManager.beginTransaction()
                            .replace(R.id.framer, fragment)
                            .addToBackStack(null)
                            .commitAllowingStateLoss()
                        isTransitionDone = true
                        Log.d("intermed", "im ready")
                    } else {
                        Log.d("intermed", "View is not in a valid state for the transition.")
                    }
                } catch (e: IllegalStateException) {
                    Log.e("intermed", "Error during fragment transaction: ${e.message}")
                }
            }, 2000)
        } else {
            Log.d("intermed", "Transition is already done or state is saved.")
        }
    }

    override fun onDestroyView() {
        handler.removeCallbacksAndMessages(null)
        super.onDestroyView()
    }
}

