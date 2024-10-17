package com.twakeapps.recyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.twakeapps.recyclerview.databinding.RowCountryBinding

class CountryAdapter(var items:ArrayList<CountryModel>):RecyclerView.Adapter<CountryAdapter.MyViewHolder>()
{
    lateinit var onItemClick:((CountryModel)->Unit)

    fun setItemClick(action:(CountryModel)->Unit){
        onItemClick = action
    }
    override fun getItemCount() : Int
    {
        return items.size
    }

    override fun onCreateViewHolder(parent : ViewGroup, viewType : Int) : MyViewHolder
    {
        val binding = RowCountryBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder : MyViewHolder, position : Int)
    {
       val item = items[position]
       val binding = holder.binding
        binding.tvCountryName.text = item.countryName
        binding.tvCountryCode.text = item.countryCode
    }




    inner class MyViewHolder(var binding : RowCountryBinding):ViewHolder(binding.root){

        init
        {
            binding.root.setOnClickListener {
                onItemClick(items[adapterPosition])

            }
        }

    }

}