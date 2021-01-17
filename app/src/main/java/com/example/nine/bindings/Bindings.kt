package com.example.nine.bindings

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.example.nine.data.models.Category
import com.example.nine.databinding.CategoryTextviewBinding
import com.squareup.picasso.Picasso

@BindingAdapter("imageUrl")
fun getImagePicasso(view: ImageView, url: String?) {
    Picasso.get().load("$url").fit().centerInside().into(view)
}

@BindingAdapter("categories")
fun setCategories(container: ViewGroup, categories: List<Category>) {
    val inflater = LayoutInflater.from(container.context)

    for (c in categories) {
        val binding = CategoryTextviewBinding.inflate(inflater, container, false)
        binding.item = c

        binding.categoryTextview.text = c.name

        container.addView(binding.root)
    }
}