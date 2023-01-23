package com.example.islami
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder


class AhadethRecycleAdapter ():Adapter<AhadethRecycleAdapter.viewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): viewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.ahadeth_item_recylcer,parent,false)
        return viewHolder(view)
    }

    override fun onBindViewHolder(holder: viewHolder, position: Int) {
        holder.hadethName.text = " الحديث رقم ${position+1} "
        holder.itemView.setOnClickListener{

            onItemClick?.onItemClick(position)
        }
    }

    var onItemClick : OnItemClick? = null
    interface OnItemClick {
        fun onItemClick(position: Int)
    }

    override fun getItemCount(): Int {
      return 50
    }


    class  viewHolder (itemView: View):ViewHolder(itemView){

        val hadethName : TextView = itemView.findViewById(R.id.hadeth_name)

    }
}