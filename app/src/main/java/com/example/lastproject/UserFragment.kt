package com.example.lastproject

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tugaspraktikummodul4.DataUserAdapter

class UserFragment : Fragment() {

    private var courseList = ArrayList<DataUser>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val activity = activity as AppCompatActivity
        activity.supportActionBar?.show()
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_user, container, false)

        courseList.addAll(getDataMahasiswa())
        val recyclerView = view.findViewById<RecyclerView>(R.id.rvDailyActivity)
//        recyclerView.layoutManager = GridLayoutManager(this, 2)
        recyclerView.layoutManager = LinearLayoutManager( requireContext())

        val adapter = DataUserAdapter(courseList)
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

        return view
    }
    private fun getDataMahasiswa(): ArrayList<DataUser> {

        val datanama = resources.getStringArray(R.array.namaUser)
        val dataNim = resources.getStringArray(R.array.nimUser)
        val dataImg = resources.getStringArray(R.array.imgUser)
        val listData = ArrayList<DataUser>()

        for (i in 0 until datanama.size) {
            val imageResId = resources.getIdentifier(dataImg[i].toLowerCase(), "drawable",  requireContext().packageName)
            listData.add(DataUser(datanama[i],dataNim[i], imageResId))
        }
        return listData

    }
}
