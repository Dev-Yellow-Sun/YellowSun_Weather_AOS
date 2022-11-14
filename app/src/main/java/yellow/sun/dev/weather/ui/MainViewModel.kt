package yellow.sun.dev.weather.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import yellow.sun.dev.weather.base.BaseViewModel

class MainViewModel(

): BaseViewModel() {

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> get() = _isLoading

}