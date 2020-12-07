package com.example.android.horizontalrecyclerview

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.chad.library.adapter.base.BaseQuickAdapter
import com.chad.library.adapter.base.viewholder.BaseViewHolder

class OuterAdapter : BaseQuickAdapter<Any, BaseViewHolder>(R.layout.layout_item, null) {
    override fun convert(holder: BaseViewHolder, item: Any) {
        val recyclerView = holder.getView<RecyclerView>(R.id.rv_inner)
        recyclerView.layoutManager =
            LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
        val innerAdapter = InnerAdapter()
        recyclerView.adapter = innerAdapter
        val mutableListOf = mutableListOf<Any>()
        for (i in 0..30) {
            mutableListOf.add(Any())
        }
        innerAdapter.addData(mutableListOf)
    }

}

class InnerAdapter : BaseQuickAdapter<Any, BaseViewHolder>(R.layout.layout_item_inner, null) {
    override fun convert(holder: BaseViewHolder, item: Any) {

    }
}