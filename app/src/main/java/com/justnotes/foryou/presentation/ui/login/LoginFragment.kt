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
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class LoginFragment : DaggerFragment() {


    lateinit var editText_login : EditText
    lateinit var editText_password: EditText


    companion object {
        fun newInstance() = LoginFragment()
    }
    @Inject lateinit var viewModel: LoginViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView = inflater.inflate(R.layout.fragment_login, container, false)
        editText_login = rootView.findViewById(R.id.editText_login)
        editText_password = rootView.findViewById(R.id.editText_password)

        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        editText_login.addTextChangedListener()
        {
            viewModel.loginLiveData.value = editText_login.text.toString()
            editText_password.setText(viewModel.loginLiveData.value)
        }
    }
}