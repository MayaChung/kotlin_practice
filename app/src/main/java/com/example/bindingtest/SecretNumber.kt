package com.example.bindingtest

import java.util.*

class SecretNumber {
    //Random().nextInt()此方法可以產生範圍內的整數值
    // ex:nextInt(10) 會產生0~9
    // ex:nextInt(10)+1 會產生1~10
    //secret是存活在SecretNumber內的類別屬性
    val secret =Random().nextInt(10)+1
    var count=0
    //可變動的變數值count
    fun varlidate(number:Int) :Int{
        return number-secret
    }
    //設計一個能回應使用者猜測數據大小 值number:Int 回傳Int
    fun main(){
        var  secretNumber=SecretNumber()
        println(secretNumber.secret)
        println("${secretNumber.varlidate(2)},count:${secretNumber.count}")
    }
}