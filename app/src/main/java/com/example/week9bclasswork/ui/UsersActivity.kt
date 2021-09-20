package com.example.week9bclasswork.ui

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.week9bclasswork.R
import com.example.week9bclasswork.adapter.UsersAdapter
import com.example.week9bclasswork.data.UserDataClass
import com.example.week9bclasswork.data.UserDataClassItem
import com.example.week9bclasswork.databinding.ActivityUsersBinding
import com.example.week9bclasswork.viewModel.UsersViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_users.*

@AndroidEntryPoint
class UsersActivity : AppCompatActivity() {
    lateinit var binding: ActivityUsersBinding
    private lateinit var usersDataList : ArrayList<UserDataClassItem>
    private lateinit var usersAdapter: UsersAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        usersDataList = UserDataClass()

        initializeRecyclerView()
        initViewModel()
    }

    @SuppressLint("NotifyDataSetChanged")
    private fun initializeRecyclerView() {
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        usersAdapter = UsersAdapter()
        usersAdapter.notifyDataSetChanged()
        recyclerView.adapter = usersAdapter
    }

    private fun initViewModel() {
        val usersViewModel = ViewModelProvider(this)[UsersViewModel::class.java]
        usersViewModel.loadUsers()
        usersViewModel.liveData.observe(this, Observer {
            if (it != null){
                usersAdapter.list = it
            }else{
                Toast.makeText(this,"data fetching error",Toast.LENGTH_SHORT).show()
            }
        })
    }


}