package ru.ichaporgin.project276.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import ru.ichaporgin.project276.domain.CategoryDomain
import ru.ichaporgin.project276.repository.MainRepository

class MainViewModel: ViewModel() {
    private val repository = MainRepository()

    fun loadCategory(): LiveData<MutableList<CategoryDomain>> {
        return repository.loadCategory()
    }
}