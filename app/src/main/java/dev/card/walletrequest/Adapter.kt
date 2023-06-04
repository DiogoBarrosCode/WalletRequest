package dev.card.walletrequest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

class Adapter(var listaDeCards: List<Card>): RecyclerView.Adapter<View>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): View {
        val view:View = LayoutInflater.from(parent.context).inflate(R.layout.card_item,parent,false)
        return View(view)
    }

    override fun getItemCount(): Int {
        return listaDeCards.size
    }

    override fun onBindViewHolder(holder: View, position: Int) {
        val cards:Card = listaDeCards[position]
        holder.configItens(cards)
    }
}