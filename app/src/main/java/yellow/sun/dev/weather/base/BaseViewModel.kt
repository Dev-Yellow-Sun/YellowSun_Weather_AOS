package yellow.sun.dev.weather.base

import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import org.koin.core.component.KoinComponent

abstract class BaseViewModel: ViewModel(), KoinComponent {

    private val compositeDisposable = CompositeDisposable()

    fun addDisposable(disposable: Disposable) = compositeDisposable.add(disposable)

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}