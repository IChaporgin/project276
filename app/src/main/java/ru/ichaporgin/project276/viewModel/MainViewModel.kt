package ru.ichaporgin.project276.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.ichaporgin.project276.domain.BannerModel
import ru.ichaporgin.project276.domain.CategoryModel
import ru.ichaporgin.project276.domain.ItemsModel
import ru.ichaporgin.project276.repository.MainRepository

class MainViewModel : ViewModel() {
    private val repository = MainRepository()

    fun loadCategory(): LiveData<MutableList<CategoryModel>> {
        return repository.loadCategory()
    }

    fun loadBanner(): LiveData<MutableList<BannerModel>> {
        return repository.loadBanner()
    }

    fun loadPopular(): LiveData<MutableList<ItemsModel>> {
        return repository.loadPopular()
    }

    fun loadItems(categoryId: String): LiveData<MutableList<ItemsModel>> {
        return repository.loadItemCategory(categoryId)
    }
}