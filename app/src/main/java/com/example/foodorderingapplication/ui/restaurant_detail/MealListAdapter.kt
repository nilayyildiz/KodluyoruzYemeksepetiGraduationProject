package com.example.foodorderingapplication.ui.restaurant_detail

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.foodorderingapplication.data.entity.meals.Meals
import com.example.foodorderingapplication.data.entity.meals.MealsItem
import com.example.foodorderingapplication.databinding.ItemMealBinding
import com.example.foodorderingapplication.ui.listeners.IMealClickListener

class MealListAdapter : RecyclerView.Adapter<MealListAdapter.MealViewHolder>() {

    var mealList: Meals? = null

    private var listener: IMealClickListener? = null

    class MealViewHolder(val binding: ItemMealBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(MealItem: MealsItem, listener: IMealClickListener?) {
            binding.mealName.text = MealItem.name
            binding.mealPrice.text = MealItem.price
            binding.itemMealCardView.setOnClickListener { listener?.onClick(MealItem) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MealViewHolder {
        return MealViewHolder(
            ItemMealBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MealViewHolder, position: Int) {
        mealList?.get(position)?.let {
            holder.bind(it, listener)
        }
    }

    override fun getItemCount(): Int {
        return mealList!!.size
    }

    fun setData(newList: Meals?) {
        mealList = newList
        notifyDataSetChanged()
    }

    fun setMealOnClickListener(listener: IMealClickListener) {
        this.listener = listener
    }
}