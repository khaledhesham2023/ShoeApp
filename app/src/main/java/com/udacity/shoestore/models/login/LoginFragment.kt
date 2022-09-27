package com.udacity.shoestore.models.login

import android.os.Bundle
import android.view.*
import android.view.inputmethod.InputMethodManager
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // instance of data binding to bind the login fragment with its layout
        val binding = DataBindingUtil.inflate<FragmentLoginBinding>(
            inflater,
            R.layout.fragment_login,
            container,
            false
        )

        // clicking on either new login or login with existing account buttons to navigate to welcome screen
        binding.apply {
            newLoginButton.setOnClickListener {
                view?.findNavController()
                    ?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
            existingLoginButton.setOnClickListener {
                view?.findNavController()
                    ?.navigate(LoginFragmentDirections.actionLoginFragmentToWelcomeFragment())
            }
        }

        // returns the whole view with binding
        return binding.root
    }
}
