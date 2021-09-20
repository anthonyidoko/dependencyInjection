package com.example.week9bclasswork.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.week9bclasswork.R
import com.example.week9bclasswork.data.UserDataClass
import com.example.week9bclasswork.data.UserDataClassItem

class UsersAdapter() : RecyclerView.Adapter<UsersAdapter.ViewHolder>() {
    var list = ArrayList<UserDataClassItem>()

    class ViewHolder(view : View) :RecyclerView.ViewHolder(view){
        val name :TextView = view.findViewById(R.id.name)
        val username :TextView = view.findViewById(R.id.userName)
        val id :TextView = view.findViewById(R.id.id)
        val phone :TextView  = view.findViewById(R.id.phone)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.users_list_item,parent,false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = list[position]
        holder.name.text = currentItem.name
        holder.username.text = currentItem.username
        holder.id.text = currentItem.id.toString()
        holder.phone.text = currentItem.phone
    }

    override fun getItemCount() = list.size
}
