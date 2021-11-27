package com.example.cryptoinvestcenter.ui.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.loadAny
import com.example.cryptoinvestcenter.R
import com.example.cryptoinvestcenter.data.model.Moneda
import com.example.cryptoinvestcenter.databinding.CardCryptoMonedasBinding
import com.squareup.picasso.Picasso

class MonedaAdapter (private val monedas:List<Moneda>, private val context: Context): RecyclerView.Adapter<MonedaAdapter.ViewHolder>(), View.OnClickListener
{
    private lateinit var listener: View.OnClickListener

    inner class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView)
    {
        val binding = CardCryptoMonedasBinding.bind(itemView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder
    {
        val card = LayoutInflater.from(parent.context).inflate(R.layout.card_crypto_monedas, parent, false)
        card.setOnClickListener(this)
        return ViewHolder(card)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int)
    {
        holder.binding.itemNameMoneda.text = this.monedas.get(position).name
        holder.binding.itemSymbol.text = this.monedas.get(position).symbol
        //holder.binding.itemIcon.loadSvg(this.monedas.get(position).logo_url)

        Picasso.get().load(this.monedas.get(position).logo_url).into(holder.binding.itemIcon)
        //Picasso.with(context).load(this.books[position].imageLink).placeholder(R.drawable.placeholder).error(R.drawable.error).fit().centerInside().noFade().into(viewHolder.itemImage);
        //Picasso.with(context).load(this.books.get(position).imageLink).into(holder.binding.itemImage)
    }

    override fun getItemCount(): Int
    {
        return monedas.size
    }

    fun setOnClickListener(listener: View.OnClickListener)
    {
        this.listener = listener
    }

    override fun onClick(view: View)
    {
        if(listener!=null)
        {
            listener.onClick(view)
        }
    }
}