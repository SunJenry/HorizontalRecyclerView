package com.example.android.horizontalrecyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<View>(R.id.btn_horizontal).setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            intent.putExtra(RecyclerViewActivity.KEY_TYPE, RecyclerViewActivity.TYPE_HORIZONTAL)
            startActivity(intent)
        }

        findViewById<View>(R.id.btn_vertical).setOnClickListener {
            val intent = Intent(this, RecyclerViewActivity::class.java)
            intent.putExtra(RecyclerViewActivity.KEY_TYPE, RecyclerViewActivity.TYPE_VERTICAL)
            startActivity(intent)
        }
    }
}