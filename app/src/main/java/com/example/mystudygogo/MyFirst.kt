package com.example.mystudygogo

import kotlin.math.max

/**
 * @desc 作用描述
 * @author hello word
 * @date 2021/8/2
 */
class MyFirst {


}



fun main() {

    for (i in 10 downTo 0 step 3){
        println(i)
    }

    val cellphone1 = Cellphone("sumsung",1299.99)
    val cellphone2 = Cellphone("sumsung",1299.99)
    println(cellphone1)
    println(cellphone2)
    println("cellphone1 equals cellphone2 "+ (cellphone1 == cellphone2))

}

fun methodName(param1: Int, param2: Int): Int {
    return 0
}

fun largerNumber(num1: Int, num2: Int) = if (num1 > num2) num1 else num2

fun getScore(name: String) = when {
    name.startsWith("Tom") -> 86
    name=="Jim" -> 77
    name=="Jack" -> 95
    name=="Lily" -> 100
    else -> 0
}
fun checkNumber(num:Number){
    when(num){
        is Int ->println("number is Int")
        is Double -> println("number is Double ")
        is Long -> println("number is Long")
        else -> println("number not support")
    }
}
