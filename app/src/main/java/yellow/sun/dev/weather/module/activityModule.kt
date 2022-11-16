package yellow.sun.dev.weather.module

import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module
import yellow.sun.dev.weather.ui.activity.MainViewModel

val activityModule = module {
    viewModel {
        MainViewModel(get())
    }
}