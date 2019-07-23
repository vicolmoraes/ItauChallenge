package com.vicolmoraes.itauchallenge

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import kotlinx.android.synthetic.main.contato_item.view.*


class ContatosAdapter(val items: List<String>, val context: Context, val clickListener: (String) -> Unit) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
        (p0 as BuildingViewHolder).bind(items[p1], clickListener)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): BuildingViewHolder {
        return BuildingViewHolder(LayoutInflater.from(context).inflate(R.layout.contato_item, p0, false))
    }

    override fun getItemCount(): Int {
        return items.size
    }

    class BuildingViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemVieww = view
        fun bind(part: String, clickListener: (String) -> Unit) {
            itemVieww.tv_nome_contato_item.text = part

            val animZoomin = AnimationUtils.loadAnimation(
                itemVieww.context,
                R.anim.zoom_from_center
            )
            val x = 200 * adapterPosition
            animZoomin.startOffset = x.toLong()
            itemVieww.setAnimation(animZoomin)

            itemVieww.setOnClickListener { clickListener(part) }
        }

    }

}