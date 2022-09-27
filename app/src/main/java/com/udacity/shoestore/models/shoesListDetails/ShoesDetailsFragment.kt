package com.udacity.shoestore.models.shoesListDetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoesDetailsBinding

class ShoesDetailsFragment : Fragment() {

    // instance of data binding
    private lateinit var binding: FragmentShoesDetailsBinding

    // instance of shoeViewModel
    private lateinit var shoeViewModel: ShoeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        //  binding the fragment with the layout
        binding = DataBindingUtil.inflate<FragmentShoesDetailsBinding>(
            inflater,
            R.layout.fragment_shoes_details,
            container,
            false
        )
        // An instance of shoeViewModel
        shoeViewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        // connect the viewModel variable in view to viewModel
        binding.shoeViewModel = shoeViewModel
        // making liveData aware of fragment lifecycle
        binding.lifecycleOwner = requireActivity()


        // returns the view with binding
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        // actions done by data binding when pressing the buttons in this fragment
        binding.apply {
            // clicking the cancel button to navigate back to shoes list screen
            cancel.setOnClickListener {
                view?.findNavController()?.navigateUp()
            }
        }
    }
}