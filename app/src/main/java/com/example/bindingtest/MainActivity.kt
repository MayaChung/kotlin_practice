package com.example.bindingtest

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.bindingtest.databinding.ActivityMainBinding
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null

    val secretNumber=SecretNumber()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        //取得binging物件 getLayoutInflater()是每個Activity都有的方法 目的是為了產生物件
        setContentView(binding!!.root)
        //getRoot() 得到物件的view
        Log.d("MainActivity","Screct:"+secretNumber.secret)
    }

    @SuppressLint("SetTextI18n")
    fun BMI(view: View?) {
        val w = binding!!.weightText.text.toString()
        val h = binding!!.heightText.text.toString()
        val w1 = w.toFloat()
        val h1 = h.toFloat()
        val bmi = w1 / (h1 * h1)
        Toast.makeText(this, "BMI=$bmi", Toast.LENGTH_SHORT).show()
        binding!!.BMI.text = "BMI=$bmi"
    }

    fun check(view: View){
        //    binding!!.editTextNumber.text.toString()
        val n:Int=editTextNumber.text.toString().toInt()
        //        Toast.makeText(this,"Numer:$n",Toast.LENGTH_SHORT).show()
        println("Number:$n")
        Log.d("MainActivity","Number:$n")
        val diff:Int=secretNumber.varlidate(n)
        var message=getString(R.string.bingo)
        if(diff<0){
            message=getString(R.string.bigger)
        }else if(diff>0){
            message=getString(R.string.smaller)
        }
        // Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
        //AlertDialog.Builder模式 能讓我們方便產出
        AlertDialog.Builder(this)
                .setTitle(getString(R.string.message))
                .setMessage(message)
                .setPositiveButton(getString(R.string.ok)) { dialog, which ->
                    if (diff == 0) {
                        val intent = Intent(this, Record::class.java)
                        //載生出新Activity之前,定義COUNTER標籤的intent物件，裡面附有count值，可知道答題幾次
                        intent.putExtra("COUNTER",secretNumber.count)
                        startActivity(intent)
                    }
                }
                .show()
    }
}