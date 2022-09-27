package com.udacity.shoestore.models.welcome

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentWelcomeBinding
import com.udacity.shoestore.models.shoesList.ShoesListFragmentDirections

class WelcomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // data binding the Welcome fragment with its layout
        val binding = DataBindingUtil.inflate<FragmentWelcomeBinding>(
            inflater,
            R.layout.fragment_welcome,
            container,
            false
        )

        // binding the fragment to the button that navigate to the instructions
        binding.instructionsButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(WelcomeFragmentDirections.actionWelcomeFragmentToInstructionsFragment())
        }

        // return the view along with binding
        return binding.root
    }
}