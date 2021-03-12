package com.justnotes.foryou.presentation.ui.login

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.core.widget.addTextChangedListener
import com.justnotes.foryou.R

class LoginFragment : Fragment() {


    lateinit var editText_login : EditText
    lateinit var editText_password: EditText


    companion object {
        fun newInstance() = LoginFragment()
    }

    private lateinit var viewModel: LoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {




        val rootView = inflater.inflate(R.layout.fragment_login, container, false)
        editText_login = rootView.findViewById(R.id.editText_login)
        editText_password = rootView.findViewById(R.id.editText_password)

        var loginViewModel = LoginViewModel()


        editText_login.addTextChangedListener()
        {
            loginViewModel.loginLiveData.value = editText_login.text.toString()
            editText_password.setText(loginViewModel.loginLiveData.value)

        }

        return rootView







    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        // TODO: Use the ViewModel
    }

}