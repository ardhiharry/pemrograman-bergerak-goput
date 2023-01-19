package com.ardhiharry.goput.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ardhiharry.goput.R
import com.ardhiharry.goput.entities.Order
import kotlinx.android.synthetic.main.adapter_order.view.*

class OrderAdapter(private  val orders: ArrayList<Order>, private val listener: OnAdapterListener)
    : RecyclerView.Adapter<OrderAdapter.OrderViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OrderViewHolder {
        return OrderViewHolder(
            LayoutInflater.from(parent.context).inflate( R.layout.adapter_order, parent, false )
        )
    }

    override fun onBindViewHolder(holder: OrderViewHolder, position: Int) {
        val order = orders[position]
        holder.view.textOrder.text = order.customerName
        holder.view.textOrder.setOnClickListener {
            listener.onClick( order )
        }
    }

    override fun getItemCount() = orders.size

    class OrderViewHolder(val view: View) : RecyclerView.ViewHolder(view)

    fun setData(list: List<Order>) {
        orders.clear()
        orders.addAll(list)
        notifyDataSetChanged()
    }

    interface OnAdapterListener {
        fun onClick(order: Order)
    }

}