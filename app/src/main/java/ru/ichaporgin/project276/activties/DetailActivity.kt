package ru.ichaporgin.project276.activties

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import ru.ichaporgin.project276.Helper.ManagmentCart
import ru.ichaporgin.project276.R
import ru.ichaporgin.project276.databinding.ActivityDetailBinding
import ru.ichaporgin.project276.domain.ItemsModel

class DetailActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailBinding
    private lateinit var item: ItemsModel
    private lateinit var managmentCart: ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        managmentCart = ManagmentCart(this)

        bundle()
        initSizeList()
    }

    private fun initSizeList() {
        binding.apply {
            smallBtn.setOnClickListener {
                smallBtn.setBackgroundResource(R.drawable.brown_full_corner)
                smallBtn.setTextColor(getResources().getColor(R.color.white))
                mediumBtn.setTextColor(getResources().getColor(R.color.black))
                largeBtn.setTextColor(getResources().getColor(R.color.black))
                mediumBtn.setBackgroundResource(0)
                largeBtn.setBackgroundResource(0)
            }
            mediumBtn.setOnClickListener {
                mediumBtn.setBackgroundResource(R.drawable.brown_full_corner)
                mediumBtn.setTextColor(getResources().getColor(R.color.white))
                smallBtn.setTextColor(getResources().getColor(R.color.black))
                largeBtn.setTextColor(getResources().getColor(R.color.black))
                smallBtn.setBackgroundResource(0)
                largeBtn.setBackgroundResource(0)
            }
            largeBtn.setOnClickListener {
                largeBtn.setBackgroundResource(R.drawable.brown_full_corner)
                largeBtn.setTextColor(getResources().getColor(R.color.white))
                smallBtn.setTextColor(getResources().getColor(R.color.black))
                mediumBtn.setTextColor(getResources().getColor(R.color.black))
                smallBtn.setBackgroundResource(0)
                mediumBtn.setBackgroundResource(0)
            }
        }
    }

    private fun bundle() {
        binding.apply {
            item = intent.getSerializableExtra("object") as ItemsModel

            Glide.with(this@DetailActivity)
                .load(item.picUrl[0])
                .into(binding.picMain)

            titleTxt.text = item.title
            descriptionTxt.text = item.description
            priceTxt.text = "$" + item.price
            item.numberInCart = 1
            ratingTxt.text = item.rating.toString()

            addToCartBtn.setOnClickListener {
                item.numberInCart = Integer.valueOf(numberInCart.text.toString())
                managmentCart.insertItems(item)
            }

            backBtn.setOnClickListener { finish() }

            plusBtn.setOnClickListener {
                numberInCart.text = (item.numberInCart + 1).toString()
                item.numberInCart++
            }

            minusBtn.setOnClickListener {
                if (item.numberInCart > 0) {
                    numberInCart.text = (item.numberInCart - 1).toString()
                    item.numberInCart--
                }
            }
        }
    }
}