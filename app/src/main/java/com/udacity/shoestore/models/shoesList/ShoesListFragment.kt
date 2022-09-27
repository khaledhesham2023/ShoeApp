package com.udacity.shoestore.models.shoesList

import android.os.Bundle
import android.view.*
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import com.udacity.shoestore.R
import com.udacity.shoestore.ShoeViewModel
import com.udacity.shoestore.databinding.FragmentShoesListBinding
import com.udacity.shoestore.models.Shoe


class ShoesListFragment : Fragment() {

    // instance of data binding
    private lateinit var binding: FragmentShoesListBinding
    private lateinit var shoeViewModel: ShoeViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // binding the fragment with layout
        binding = DataBindingUtil.inflate<FragmentShoesListBinding>(
            inflater,
            R.layout.fragment_shoes_list,
            container,
            false
        )

    // to enable options menu in shoesList fragment
        setHasOptionsMenu(true)

        // setting up the viewModel
        shoeViewModel = ViewModelProvider(requireActivity())[ShoeViewModel::class.java]
        // setting up the observer to observe the changes in shoes list in viewModel
        shoeViewModel.shoesList.observe(viewLifecycleOwner, Observer {
            addView(it)
        }
        )

    // return the whole view along with binding
        return binding.root
    }

    /**
     * function addView is used to create a view as well as setting the attributes
     * @param it refers to list of shoes observed from viewModel
     *
     */
    private fun addView(it: MutableList<Shoe>?) {
        for (shoe in 0 until it!!.size) {
            val textView = TextView(context)
            textView.setTextColor(resources.getColor(R.color.greenYellow))
            textView.textSize = 20F
            textView.text = it[shoe].name
            binding.shoeListItemsLinearLayout.addView(textView)
        }
    }


    override fun onStart() {
        super.onStart()

        // Click the floating button to navigate to add shoes details screen
        binding.shoeListActionButton.setOnClickListener {
            view?.findNavController()
                ?.navigate(ShoesListFragmentDirections.actionShoesListFragmentToShoesDetailsFragment())
        }

    }

    // inflating the menu
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu, menu)
    }

    // actions called when clicking on an option
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.logout -> findNavController().navigate(ShoesListFragmentDirections.actionShoesListFragmentToLoginFragment())
        }
        return super.onOptionsItemSelected(item)
    }


}