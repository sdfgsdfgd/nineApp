package com.example.nine.ui.news

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import com.example.nine.R
import com.example.nine.bindings.recyclerview.NegativeDiffCallback
import com.example.nine.data.models.Asset
import com.example.nine.data.models.News
import com.example.nine.domain.NewsRepository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject


class NewsViewModel @Inject constructor(private val newsRepository: NewsRepository) : ViewModel() {
    private var portrait = false

    private val disposable = CompositeDisposable()

    val news = MutableLiveData<News>()

    val assets = MutableLiveData<List<Asset>>()
    val assetsDiff: DiffUtil.ItemCallback<Asset> = NegativeDiffCallback()
    val assetsLayoutProvider: (Asset) -> Int = { if (portrait) R.layout.asset_item_portrait else R.layout.asset_item_landscape }

    private val _navigateToWebview = MutableLiveData<String>()
    val navigateToWebview: LiveData<String> get() = _navigateToWebview

    init {
        getNews()
    }

    fun setPortraitOrientation(isPortrait: Boolean) {
        this.portrait = isPortrait
    }


    private fun getNews() {
//        loading.value = true      // Todo: Loading animations, before the network call.
        disposable.add(
            newsRepository.getNews()
            !!.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableSingleObserver<News?>() {
                    override fun onSuccess(news: News) {
                        assets.value = news.assets.onEach { it.onClickHandler = ::onAssetClicked }
                    }

                    override fun onError(e: Throwable) {
                        // TODO: Error handling.
                    }
                })
        )
    }

    private fun onAssetClicked(url: String) {
        _navigateToWebview.value = url
    }
}