package yellow.sun.dev.weather.ui.fragment

import android.os.Bundle
import androidx.fragment.app.activityViewModels
import yellow.sun.dev.weather.R
import yellow.sun.dev.weather.base.BaseFragment
import yellow.sun.dev.weather.databinding.FragmentWeatherBinding
import yellow.sun.dev.weather.ui.activity.MainViewModel

class WeatherFragment: BaseFragment<FragmentWeatherBinding>() {
    override val layoutId: Int = R.layout.fragment_weather

    private val viewModel by activityViewModels<MainViewModel>()

    companion object {
        const val KEY = "key"
        fun newInstance(data: String): WeatherFragment = WeatherFragment().apply {
            arguments = Bundle().apply {
                val args = Bundle()
                args.putString(KEY, data)
                arguments = args

            }
        }
    }


}