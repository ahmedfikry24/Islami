package com.example.islami
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class QuranRecycleAdapter (val items :List<String>):Adapter<QuranRecycleAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.quarn_item_recylcer,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.suraName.text = items[position]
        holder.itemView.setOnClickListener{

            onItemClick?.onItemClick(items[position], position)
        }
    }

    var onItemClick : OnItemClick? = null
    interface OnItemClick {
        fun onItemClick(suraName : String , position: Int)
    }

    override fun getItemCount(): Int {
      return items.size
    }


    class  viewHolder (itemView: View):ViewHolder(itemView){

        val suraName : TextView = itemView.findViewById(R.id.sura_name)

    }
}