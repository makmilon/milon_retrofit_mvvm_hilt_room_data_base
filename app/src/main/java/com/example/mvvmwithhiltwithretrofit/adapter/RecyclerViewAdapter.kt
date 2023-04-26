package com.example.mvvmwithhiltwithretrofit.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mvvmwithhiltwithretrofit.R
import com.example.mvvmwithhiltwithretrofit.favorite.AppDatabase
import com.example.mvvmwithhiltwithretrofit.favorite.ProductFav
import com.example.mvvmwithhiltwithretrofit.netWork.dataClass.Product
import com.example.mvvmwithhiltwithretrofit.pages.DetailsActivity



class RecyclerViewAdapter: RecyclerView.Adapter<RecyclerViewAdapter.MyRecViewHolder>() {


    private var listData : List<Product>?=null

    fun setListData(listData : List<Product>){
        this.listData= listData

    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.MyRecViewHolder {

        val view= LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        return MyRecViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.MyRecViewHolder, position: Int) {
        holder.bind(listData?.get(position)!!)

    }

    override fun getItemCount(): Int {
        return listData?.size ?: 0
    }

    class MyRecViewHolder(view: View): RecyclerView.ViewHolder(view){

        var message: Double?=null

     val img= view.findViewById<ImageView>(R.id.imgView)
     val tex1= view.findViewById<TextView>(R.id.textView)
     val tex2= view.findViewById<TextView>(R.id.textView2)
     val tex3= view.findViewById<TextView>(R.id.textView3)
     val heart= view.findViewById<ImageView>(R.id.imageView3)



        fun bind(data: Product){

            tex1.text = data.title
            tex2.text= data.brand
            Glide.with(img).load(data.imageURL).into(img)

            val priceList = data.price
            if (priceList.isNotEmpty()) {
                message = priceList[0].value

                tex3.text = "$message RS"
                // Use the price value as needed
            }

            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val context = itemView.context
                    val intent = Intent(context, DetailsActivity::class.java)
                    intent.putExtra("position", position)

                    intent.putExtra("title", data.title)
                    intent.putExtra("imageURL", data.imageURL)
                    intent.putExtra("id", data.id)
                    intent.putExtra("brand", data.brand)
                    intent.putExtra("message", message)

                    context.startActivity(intent)
                }
            }

            val dataF = object {
                var isFavorite = true // or false
            }
                     // Add an OnClickListener to the favorite button
            heart.setOnClickListener {
                // Update the product's isFavorite property
                dataF.isFavorite = !dataF.isFavorite

                // Update the favorite button image
                if (dataF.isFavorite) {
                    heart.setImageResource(R.drawable.heart_black)
                } else {
                    heart.setImageResource(R.drawable.heart_red)
                }

              //data save to local database

            }
        }


    }
}