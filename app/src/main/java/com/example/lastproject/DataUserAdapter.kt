package com.example.tugaspraktikummodul4

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lastproject.DataUser
import com.example.lastproject.ProfileActivity
import com.example.lastproject.R

class DataUserAdapter(private val courseList: ArrayList<DataUser>) : RecyclerView.Adapter<DataUserAdapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val courseNama: TextView = itemView.findViewById(R.id.tvNama)
        val courseNim: TextView = itemView.findViewById(R.id.nim)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView: View = LayoutInflater.from(parent.context).inflate(R.layout.item_recycler, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentUser = courseList[position]

        holder.courseNama.text = currentUser.nama
        holder.courseNim.text = currentUser.nim

        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, ProfileActivity::class.java)
            intent.putExtra("nama", currentUser.nama)
            intent.putExtra("nim", currentUser.nim)
            holder.itemView.context.startActivity(intent)
        }
    }


    override fun getItemCount(): Int = courseList.size
}
