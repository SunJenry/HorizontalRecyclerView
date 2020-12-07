package com.example.android.horizontalrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {

    companion object {
        const val KEY_TYPE = "type"
        const val TYPE_HORIZONTAL = "HORIZONTAL"
        const val TYPE_VERTICAL = "VERTICAL"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        val recyclerView = findViewById<RecyclerView>(R.id.rv)

        val type = intent.getStringExtra(KEY_TYPE)

        if (type == TYPE_HORIZONTAL) {
            recyclerView.layoutManager =
                LinearLayoutManager(recyclerView.context, RecyclerView.HORIZONTAL, false)
        } else {
            recyclerView.layoutManager = LinearLayoutManager(recyclerView.context)
        }

        val outerAdapter = OuterAdapter()
        recyclerView.adapter = outerAdapter
        val mutableListOf = mutableListOf<Any>()
        for (i in 0..50) {
            mutableListOf.add(Any())
        }
        outerAdapter.addData(mutableListOf)
    }
}