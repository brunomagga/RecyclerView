package com.devspace.recyclerview


import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView


class ContactListAdapter :
    ListAdapter<contact, ContactListAdapter.ContactViewHolder>(ContactDiffUtils()){

        private lateinit var OnClickListener: (contact) -> Unit

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent ,false)
        return ContactViewHolder(view)

    }
    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val contact = getItem(position)
        holder.bind(contact, OnClickListener)
    }

     fun setOnClickListener(OnClick: (contact) -> Unit){
        OnClickListener = OnClick
    }


    class ContactViewHolder(private val view: View) : RecyclerView.ViewHolder(view){
        private val tvName = view.findViewById<TextView>(R.id.tv_name)
        private val tvPhone = view.findViewById<TextView>(R.id.tv_phone)
        private val image = view.findViewById<ImageView>(R.id.image)

        fun bind(contact : contact, OnClick: (contact) -> Unit){
            tvName.text = contact.name
            tvPhone.text = contact.phone
            image.setImageResource(contact.icon)

            view.setOnClickListener{
                OnClick.invoke(contact)
            }
        }
    }

    class ContactDiffUtils : DiffUtil.ItemCallback<contact>(){
        override fun areItemsTheSame(oldItem: contact, newItem: contact): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: contact, newItem: contact): Boolean {
            return oldItem.name == newItem.name
        }

    }

}
