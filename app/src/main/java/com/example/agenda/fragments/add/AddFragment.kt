package com.example.agenda.fragments.add

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.agenda.R
import com.example.agenda.data.User
import com.example.agenda.data.UserViewModel
import kotlinx.android.synthetic.main.fragment_add.*
import kotlinx.android.synthetic.main.fragment_add.view.*

class AddFragment : Fragment() {

    private lateinit var mUserViewModel: UserViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_add, container, false)

        mUserViewModel = ViewModelProvider(this).get(UserViewModel::class.java)

        view.btn_criar.setOnClickListener {
            insertDatatoDataBase()
        }

        return view
    }

    private fun insertDatatoDataBase() {
        val task = til_title.toString()
        val description = til_descricao.toString()
        val date = til_data.toString()
        val hour = til_hora.toString()

        if (inputCheck(task, description, date, hour)) {
                //Create User Object
                val user = User(id = 0, task, description, date, hour)
                //Add Data to Database
                mUserViewModel.addUser(user)
                Toast.makeText(requireContext(), "Sucessfuly addead", Toast.LENGTH_LONG).show()
                //Navigate Back
                findNavController().navigate(R.id.action_addFragment_to_listFragment)
            }else{
                Toast.makeText(requireContext(), "Please fill out all fields.", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(task: String, description: String, date: String, hour: String): Boolean{
        return !(TextUtils.isEmpty(task) && TextUtils.isEmpty(description) && TextUtils.isEmpty(date) && TextUtils.isEmpty(hour))
    }

}