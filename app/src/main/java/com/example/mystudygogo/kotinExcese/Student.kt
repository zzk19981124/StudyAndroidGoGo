package com.example.mystudygogo.kotinExcese

/**
 * @desc 作用描述
 * @author hello word
 * @date 2021/8/3
 */
class Student(val sno: String, val grade: Int, name: String, age: Int) : Person(name, age), Study {

    constructor(name: String, age: Int) : this("", 0, name, age) {
    }

    constructor() : this("", 0) {
    }
    val name1 ="hello world"
    val name2 = 0
    init {
        println("sno is " + sno)
        println("grade is " + grade)
    }

    override fun readBooks() {
        println(name + " is reading.")
    }

    /*override fun doHomeWork() {
        println(name + " is doing homework")
    }*/
}
var content:String? = "hello"
fun printUpperCase(){
    val upperCase = content?.toUpperCase()
    println(upperCase)
}
fun main() {
    printUpperCase()
    Thread {
        println("Thread is running")
    }.start()
    val student = Student("Jack", 19)
    println(student.sno)
    doStudy(student)
    doStudy(null)
    // val student1 = Student()
    //student1.readBooks()
    /*val list = ArrayList<String>()
    list.add("Apple")
    list.add("Banana")
    list.add("Pear")
    list.add("Grape")*/
    val list = listOf("Apple", "Banana", "Pear", "Grape")

    for (fruit in list) {
        println(fruit)
    }
    println("")
    val list2 = mutableListOf("Apple", "Banana", "Pear", "Grape")


    list2.add("WaterMelon")
    for (fruit in list2) {
        println(fruit)
    }
    val maxLengthFruit = list2.maxByOrNull { it.length }
    println("max length fruit is " + maxLengthFruit)
    val newList = list2.map { it.toUpperCase() }
    for (fruit in newList) {
        println(fruit)
    }
    println("")
    val map = mapOf("Apple" to 1, "Banana" to 2, "Orange" to 3, "Pear" to 4, "Grape" to 5)
    for (fruit in map) {
        println(fruit)
    }
    for ((fruit, number) in map) {
        println("fruit is " + fruit + ", number is " + number)
    }
}

fun doStudy(study: Study?) {
    study?.let {
        it.readBooks()
        it.doHomeWork()
    }

}

fun getTextLength(text: String?): Int {
    if (text != null) {
        return text.length
    }
    return 0
}

fun getTextLength2(text: String?) = text?.length ?: 0