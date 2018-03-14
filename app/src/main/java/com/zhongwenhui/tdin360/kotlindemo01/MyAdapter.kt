package com.zhongwenhui.tdin360.kotlindemo01

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by jeffery on 2018/3/8.
 */
class MyAdapter : RecyclerView.Adapter<MyHolder>(){
    var click: OnItemClick?=null
    var list: List<String> = ArrayList<String>()
    fun add(list: List<String>) {
        this.list = list
    }
    init {
        this.list=list
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyHolder {
        val view = LayoutInflater.from(parent!!.getContext()).inflate(R.layout.item_holder_view, parent, false)
        val holder = MyHolder(view, click!!)
        return holder
    }
    override fun onBindViewHolder(holder: MyHolder?, position: Int) {
        holder!!.textView.setText(list!!.get(position))

    }
    override fun getItemCount(): Int {
        return list!!.size
    }
    fun setItemClick(click: OnItemClick) {
        this.click = click
    }
}