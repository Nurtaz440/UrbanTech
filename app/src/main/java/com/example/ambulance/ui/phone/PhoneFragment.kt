package com.example.ambulance.ui.phone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.ambulance.R
import com.example.ambulance.databinding.FragmentHomeBinding
import com.example.ambulance.databinding.FragmentPhoneBinding


class PhoneFragment : Fragment() {
    private var _binding: FragmentPhoneBinding? = null
    val binding get() = _binding!!
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentPhoneBinding.inflate(layoutInflater)
        return (binding.root)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.cvCrash.setOnClickListener {

            findNavController().navigate(R.id.crashFragment)
        }
        binding.cvYurak.setOnClickListener {

            findNavController().navigate(R.id.crashFragment)
        }
        binding.cvTok.setOnClickListener {

            findNavController().navigate(R.id.crashFragment)
        }
        binding.cvUkol.setOnClickListener {

            findNavController().navigate(R.id.crashFragment)
        }
        binding.cvChokish.setOnClickListener {

            findNavController().navigate(R.id.crashFragment)
        }
    }
}