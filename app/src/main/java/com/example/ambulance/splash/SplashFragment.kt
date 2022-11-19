package com.example.ambulance.splash

import android.content.pm.ActivityInfo
import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.navigation.findNavController
import com.example.ambulance.R
import com.example.ambulance.databinding.FragmentSplashBinding

/**
 * A simple [Fragment] subclass.
 * Use the [SplashFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SplashFragment : Fragment() {
    var _binding: FragmentSplashBinding? = null
    val binding get() = _binding!!

    private var handler: Handler? = null
    var runnable: Runnable? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSplashBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        activity?.window?.statusBarColor = ContextCompat.getColor(requireContext(), R.color.blue)
        activity?.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        handler = Handler()

        runnable = Runnable {
            requireView().findNavController().navigate(SplashFragmentDirections.actionSplashFragmentToHomeFragment())
        }
    }

    override fun onResume() {
        super.onResume()
        handler!!.postDelayed(runnable!!, 3000)
//        handler!!.postDelayed(object : Runnable {
//            override fun run() {
//
//            }
//        }
    }
    override fun onPause() {
        super.onPause()
        handler!!.removeCallbacks(runnable!!)
    }
}