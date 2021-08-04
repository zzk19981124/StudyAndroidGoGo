package com.example.mystudygogo.kotinExcese

/**
 * @desc 作用描述
 * @author hello word
 * @date 2021/8/3
 */
open class Person (val name:String,val age:Int){
    //var name = ""
    //var age = 0

    fun eat(){
        println(name+ " is eating. He is "+ age + " years old.")
    }

}
fun main(){
    val p = Person("Jack",10)
   // p.name = "Jack"
    //p.age  =19
    p.eat()
    Singleton.singletonTest()
}