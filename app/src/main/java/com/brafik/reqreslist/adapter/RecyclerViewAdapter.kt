package com.brafik.reqreslist.adapter

import com.brafik.reqreslist.R

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.brafik.reqreslist.data.models.User
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.user_item_card.view.*

class RecyclerViewAdapter : RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder>() {

    var listDataUser: List<User>? = null

    fun setListData(listDataUser: List<User>?) {
        this.listDataUser = listDataUser
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): MyViewHolder {
        return MyViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.user_item_card, parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(listDataUser?.get(position)!!)
    }

    override fun getItemCount(): Int {
        if (listDataUser == null) return 0
        return listDataUser?.size!!
    }

    class MyViewHolder(view: View) :
        RecyclerView.ViewHolder(view) {

        private val userIdTextView = view.userIdTextView
        private val userAvatarImageView = view.userAvatarImageView
        private val userFirstNameTextView = view.userFirstNameTextView
        private val userLastNameTextView = view.userLastNameTextView
        private val userEmailTextView = view.userEmailTextView


        fun bind(dataUser: User) {
            userIdTextView.text = dataUser.id.toString()
            userFirstNameTextView.text = dataUser.first_name
            userLastNameTextView.text = dataUser.last_name
            userEmailTextView.text = dataUser.email

            Glide.with(userAvatarImageView)
                .load(dataUser.avatar)
                .into(userAvatarImageView)
        }
    }
}
