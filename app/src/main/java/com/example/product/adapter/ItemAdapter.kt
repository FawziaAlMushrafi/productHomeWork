package com.example.product.adapter
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.product.R
import com.example.product.model.Product
import com.example.product_recycleview.ProductListFragmentDirections


class ItemAdapter(
    private val dataset: List<Product>,
    private val context: Context
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {
    class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val mobileImage: ImageView = view.findViewById(R.id.mobile_image)
        val mobileName: TextView = view.findViewById(R.id.mobile_name)
        val mobilePrice: TextView = view.findViewById(R.id.moblie_price)
        val mobileIsVIP: ImageView = view.findViewById(R.id.isVip_icon)
        val buyBtn: Button = view.findViewById(R.id.buy_btn)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout =
            LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false)
        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        var item = dataset[position]

        holder.mobileImage.setImageResource(item.imageResourceInt)
        holder.mobileName.text = context.resources.getString(item.name)
        holder.mobilePrice.text = context.resources.getString(item.price)
        if (item.isVip)
            holder.mobileIsVIP.visibility = View.VISIBLE

        holder.buyBtn.setOnClickListener {
            if (item.quantityNumber != 0) {
                val action =
                    ProductListFragmentDirections.actionProductListFragmentToBuyMobileFragment(
                        item.imageResourceInt.toString(),
                        context.resources.getString(item.name),
                        context.resources.getString(item.price),
                        context.resources.getString(item.url)
                    )
                holder.view.findNavController().navigate(action)
            } else {
                Toast.makeText(
                    holder.view.context,
                    "The product is not available right now",
                    Toast.LENGTH_LONG
                ).show()
            }
        }

    }

    override fun getItemCount(): Int = dataset.size
}