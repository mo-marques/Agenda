package com.example.agenda.fragments.update

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.example.agenda.R
import kotlinx.android.synthetic.main.fragment_up_date.view.*

class UpDateFragment : Fragment() {

    private val args by navArgs<UpDateFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_up_date, container, false)

//        view.til_updateTitulo.setText()

        return view
    }

}