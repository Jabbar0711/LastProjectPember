package com.example.tugaspraktikummodul4

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.lastproject.R
import com.example.lastproject.jurusan1

// on below line we are creating
// a course rv adapter class.
class Adaptor(private val courseList: ArrayList<DataView>) : RecyclerView.Adapter<Adaptor.getView>() {
    class getView(itemView: View) : RecyclerView.ViewHolder(itemView) {
        // on below line we are initializing our course name text view and our image view.
        val courseNama: TextView = itemView.findViewById(R.id.namaJurusan_tv)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adaptor.getView {
        val itemView : View = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent, false)

        return getView(itemView)
    }

    override fun onBindViewHolder(holder: Adaptor.getView, position: Int) {
        // on below line we are setting data to our text view and our image view.couse
        val currentUser = courseList[position]
        holder.courseNama.text = currentUser.jurusan

        holder.itemView.setOnClickListener{
            val intent = Intent(holder.itemView.context, jurusan1::class.java)
            intent.putExtra("tif_judul", currentUser.jurusan)
            intent.putExtra("subJudul", currentUser.sub_judul)
            intent.putExtra("deskripsi", currentUser.deskripsi)
            intent.putExtra("gambar", currentUser.pics)

            holder.itemView.context.startActivity(intent)
            }
        }
    override fun getItemCount(): Int = courseList.size
    }
