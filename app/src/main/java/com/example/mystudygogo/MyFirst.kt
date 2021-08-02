package com.example.mystudygogo

import kotlin.math.max

/**
 * @desc 作用描述
 * @author hello word
 * @date 2021/8/2
 */
class MyFirst {


}

fun methodName(param1: Int, param2: Int): Int {
    return 0
}

fun main() {
    var a: Int = 10
    var b: Int = 20

    println("a = " + a)
    println("b = " + b)
    println("a+b = " + a + b)
    println(a * 10)
    val value = largerNumber(a, b)

    println("larger num is : " + value)
    println(getScore("Lily"))

    val num = 10L
    checkNumber(num)
}

fun largerNumber(num1: Int, num2: Int) = if (num1 > num2) num1 else num2

fun getScore(name: String) = when (name) {
    "Tom" -> 86
    "Jim" -> 77
    "Jack" -> 95
    "Lily" -> 100
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
