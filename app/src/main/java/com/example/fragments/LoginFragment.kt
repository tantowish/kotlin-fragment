package com.example.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        // Assuming your button has an ID of "your_button_id" in the XML layout
        val button = view.findViewById<Button>(R.id.btnLogin)

        val username = view.findViewById<EditText>(R.id.username)
        val password = view.findViewById<EditText>(R.id.password)

        button.setOnClickListener{
            val usernameText = username.text.toString()
            val passwordText = password.text.toString()
            if (checkCredentials(usernameText, passwordText)) { // Check credentials
                // Remove the current fragment from the container

                // Perform navigation to the next fragment or activity
                // Example: navigate to a new fragment
                val intent = Intent(context, HomeActivity::class.java)
                intent.putExtra("usn", usernameText)
                startActivity(intent)
                activity?.finish()
            } else {
                Toast.makeText(
                    context,
                    "Invalid username or password, please check the input.",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }

        return view
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment LoginFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            LoginFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun checkCredentials(username: String, password: String): Boolean {
        val userCredentials = listOf(
            Pair("tantows001", "123"),
            Pair("jekiyaro", "123"),
        )
        for ((storedUsername, storedPassword) in userCredentials) {
            if (username == storedUsername && password == storedPassword) {
                return true
            }
        }
        return false
    }
}