package com.example.bindingtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_record.*

class Record : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_record)
        //getIntExtra() 專門取用Int種類的intent資訊
        //當找不到COUNTER標籤的intent.沒有讀取到任何資料時 他就是-1
        val count:Int=intent.getIntExtra("COUNTER",-1)
        counter1.setText(count.toString())

    }
}