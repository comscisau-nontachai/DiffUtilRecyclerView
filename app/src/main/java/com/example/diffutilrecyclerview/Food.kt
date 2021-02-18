package com.example.diffutilrecyclerview

data class Food(
    val id : Int?=null,
    val name : String?=null,
    val type : FoodEnum
)
enum class FoodEnum(type:String){
    JUICE("juice"),
    FOOD("food"),
    DESSERT("dessert")
}