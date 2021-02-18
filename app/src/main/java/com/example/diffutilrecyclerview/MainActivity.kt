package com.example.diffutilrecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.diffutilrecyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    lateinit var mAdapter: FoodAdapter
    lateinit var foodList: MutableList<Food>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        foodList = arrayListOf(
            Food(1,"Orange Juice",FoodEnum.JUICE),
            Food(2,"Apple Juice",FoodEnum.JUICE),
            Food(3,"chess cake",FoodEnum.DESSERT),
            Food(4,"chicken root",FoodEnum.FOOD),
            Food(5,"coconut juice",FoodEnum.JUICE),
            Food(6,"egg fire",FoodEnum.FOOD),
            Food(7,"mango juice",FoodEnum.JUICE),
            Food(8,"rice with egg",FoodEnum.FOOD),
            Food(9,"noodle",FoodEnum.FOOD),
            Food(3,"rice chicken",FoodEnum.FOOD),
            Food(10,"honey toast",FoodEnum.DESSERT),
        )

        mAdapter = FoodAdapter()
        binding.rvFood.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = mAdapter
        }
        mAdapter.submitList(foodList)


        binding.btnJuice.setOnClickListener {
            mAdapter.submitList(foodList.filter { it.type == FoodEnum.JUICE})
        }
        binding.btnFood.setOnClickListener {
            mAdapter.submitList(foodList.filter { it.type == FoodEnum.FOOD})
        }
        binding.btnDessert.setOnClickListener {
            mAdapter.submitList(foodList.filter { it.type == FoodEnum.DESSERT})
        }
        binding.btnClear.setOnClickListener {
            mAdapter.submitList(foodList)
        }
    }
}