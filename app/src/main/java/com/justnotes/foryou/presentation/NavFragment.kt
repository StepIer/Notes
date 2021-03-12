package com.justnotes.foryou.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.justnotes.foryou.R
import com.justnotes.foryou.domain.Note
import dagger.android.support.DaggerFragment
import javax.inject.Inject

class NavFragment : Fragment() {

    @Inject
    lateinit var note: Note

    lateinit var button: Button
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootView = inflater.inflate(R.layout.fragment_nav, container, false)
        button = rootView.findViewById(R.id.button2)



        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)




        button.setOnClickListener {

            Toast.makeText(context, note.toString(), Toast.LENGTH_SHORT).show()
        }
    }

}