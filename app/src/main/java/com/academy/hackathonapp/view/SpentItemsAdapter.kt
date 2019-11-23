package com.academy.hackathonapp.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.academy.hackathonapp.R
import java.io.Serializable
import java.math.BigDecimal

data class SpentItems(
    val category: String,
    val date: BigDecimal,
    val sum: Long,
    val currency: String
) : Serializable

fun getItems(): List<SpentItems> {
    TODO("Get data from the table")
}

class SpentItemsAdapter(private val items: List<SpentItems>) :
    RecyclerView.Adapter<SpentItemsAdapter.ItemsHolder>() {

    override fun onBindViewHolder(holder: ItemsHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ItemsHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))

    class ItemsHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val category: TextView = itemView.findViewById(R.id.category_name)
        private val date: TextView = itemView.findViewById(R.id.item_data)
        private val sum: TextView = itemView.findViewById(R.id.item_sum)
        private val currency: TextView = itemView.findViewById(R.id.item_currency)

        fun bind(item: SpentItems) {
            category.text = item.category
            date.text = item.date.toString()
            sum.text = item.sum.toString()
            currency.text = item.currency
        }
    }
}