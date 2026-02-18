package ru.ichaporgin.project276.activties

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bumptech.glide.Glide
import ru.ichaporgin.project276.adapter.CategoryAdapter
import ru.ichaporgin.project276.adapter.ItemsAdapter
import ru.ichaporgin.project276.databinding.ActivityMainBinding
import ru.ichaporgin.project276.viewModel.MainViewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel = MainViewModel()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initCategory()
        initBanner()
        initPopular()
        initBottomCart()
    }

    private fun initBottomCart() {
       binding.cartBtn.setOnClickListener {
           startActivity(Intent(this, CartActivity::class.java))
       }
    }

    private fun initPopular() {
        binding.progressBarPopular.visibility = View.VISIBLE
        viewModel.loadPopular().observeForever {
            binding.popularView.layoutManager = GridLayoutManager(this, 2)
            binding.popularView.adapter = ItemsAdapter(it)
            binding.progressBarPopular.visibility = View.GONE
        }
        viewModel.loadPopular()
    }

    private fun initBanner() {
        binding.progressBarBanner.visibility = View.VISIBLE
        viewModel.loadBanner().observeForever {
            Glide.with(this@MainActivity)
                .load(it[0].url)
                .into(binding.banner)
            binding.progressBarBanner.visibility = View.GONE
        }
        viewModel.loadBanner()
    }

    private fun initCategory() {
        binding.progressBarCategory.visibility = View.VISIBLE
        viewModel.loadCategory().observeForever {
            binding.categoryView.layoutManager = LinearLayoutManager(
                this@MainActivity,
                LinearLayoutManager.HORIZONTAL,
                false
            )
            binding.categoryView.adapter = CategoryAdapter(it)
            binding.progressBarCategory.visibility = View.GONE
        }
//        viewModel.loadCategory()
    }
}