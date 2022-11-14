package yellow.sun.dev.weather.module

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import yellow.sun.dev.weather.ui.MainViewModel

val viewModelModule = module {
    viewModel {
        MainViewModel()
    }
}