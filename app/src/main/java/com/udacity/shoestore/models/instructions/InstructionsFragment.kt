package com.udacity.shoestore.models.instructions

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentInstructionsBinding
import com.udacity.shoestore.models.shoesList.ShoesListFragmentDirections


class InstructionsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // data binding the instructions to its layout.
        val binding = DataBindingUtil.inflate<FragmentInstructionsBinding>(
            inflater,
            R.layout.fragment_instructions,
            container,
            false
        )
        // clicking the button to navigate to the fragment containing the shoes list.
        binding.clickToShoesStore.setOnClickListener {
            view?.findNavController()
                ?.navigate(InstructionsFragmentDirections.actionInstructionsFragmentToShoesListFragment())
        }

        // return the instructions view along with binding
        return binding.root

    }
}