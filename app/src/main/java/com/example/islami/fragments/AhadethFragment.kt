package com.example.islami.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.islami.AhadethRecycleAdapter
import com.example.islami.HadethDetails
import com.example.islami.QuranRecycleAdapter
import com.example.islami.R
import kotlin.math.log

class AhadethFragment : Fragment() {
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: AhadethRecycleAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_ahadeth, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = view.findViewById(R.id.ahadeth_recycle)
        adapter = AhadethRecycleAdapter()
        adapter.onItemClick = object :  AhadethRecycleAdapter.OnItemClick{
            override fun onItemClick(position: Int) {
                val intent = Intent (requireActivity() ,HadethDetails::class.java)
                intent.putExtra("position" , position)
                startActivity(intent)
            }

        }
        recyclerView.adapter = adapter
    }
}