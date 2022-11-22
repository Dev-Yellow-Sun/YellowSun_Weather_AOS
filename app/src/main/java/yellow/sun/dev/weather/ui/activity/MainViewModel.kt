package yellow.sun.dev.weather.ui.activity

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.schedulers.Schedulers
import yellow.sun.dev.weather.base.BaseViewModel
import yellow.sun.dev.weather.repository.WeatherRepository
import javax.inject.Inject


class MainViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository
): BaseViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> get() = _isLoading

}