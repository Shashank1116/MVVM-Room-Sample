package com.example.testapplication.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.testapplication.User
import com.example.testapplication.databinding.UserListItemBinding

class UserListAdapter(private val list: List<User>): RecyclerView.Adapter<UserListAdapter.UserViewHolder>(){
    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): UserViewHolder {
        val inflater = LayoutInflater.from(p0.context)
        val binding  = UserListItemBinding.inflate(inflater)
        return UserViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(list[position])
    }

    class UserViewHolder(val binding:UserListItemBinding):RecyclerView.ViewHolder(binding.root){
        fun bind(user: User){
            binding.userId.text = user.id.toString()
            binding.userName.text = user.name

        }

    }
}