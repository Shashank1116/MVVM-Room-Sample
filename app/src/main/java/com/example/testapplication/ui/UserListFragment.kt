package com.example.testapplication.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.Injection

import com.example.testapplication.R
import com.example.testapplication.User
import com.example.testapplication.UserListViewModel
import com.example.testapplication.databinding.FragmentUserListBinding

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class UserListFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null
    private lateinit var binding:FragmentUserListBinding

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
        binding = FragmentUserListBinding.inflate(inflater,container,false).apply{
            vieWModel = ViewModelProviders.of(this@UserListFragment,UserViewModelFactory(Injection.provideRepository(this@UserListFragment.activity!!.application))).get(UserListViewModel::class.java)
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.userListView.setHasFixedSize(true)
        binding.userListView.scrollToPosition(0)
        binding.userListView.layoutManager = LinearLayoutManager(context,RecyclerView.VERTICAL,false)


    }

    override fun onResume() {
        super.onResume()
        binding.vieWModel!!.getUserList()
        binding.vieWModel!!.observeList().observe(this, Observer {
            binding.userListView.adapter = UserListAdapter(it)
        })
        binding.vieWModel!!.addUsers(getRandomUsers())
    }

    fun getRandomUsers():List<User>{
        val list = ArrayList<User>()
        list.add(User("Shashank",1,"so-so"))
        list.add(User("Shubham",1,"so-so"))
        return list

    }

    companion object {

        const val TAG = "USER LIST FRAGMENT"

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            UserListFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}
