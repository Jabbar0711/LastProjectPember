package com.example.lastproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.*
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspraktikummodul4.Adaptor
import com.example.tugaspraktikummodul4.DataView

class ProfileFragment : Fragment() {
    // deklarasi repository

    private var courseList = ArrayList<DataView>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = activity as AppCompatActivity
        activity.supportActionBar?.hide()

        val view = inflater.inflate(R.layout.fragment_profile, container, false) as ViewGroup

        courseList.addAll(getDataMahasiswa())
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycleView)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        val adapter = Adaptor(courseList)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        return view
    }

    private fun getDataMahasiswa(): ArrayList<DataView> {

        val datanama = resources.getStringArray(R.array.judul)
        val datasubnama = resources.getStringArray(R.array.sub_judul)
        val datadeskripsi = resources.getStringArray(R.array.deskripsi)
        val dataImg = resources.getStringArray(R.array.gambar)
        val listData = ArrayList<DataView>()

        for (i in 0 until datanama.size) {
            val imageResId = resources.getIdentifier(
                dataImg[i].toLowerCase(),
                "drawable",
                requireContext().packageName
            )
            listData.add(DataView(datanama[i],datasubnama[i],datadeskripsi[i], imageResId))
        }
        return listData
    }
}
