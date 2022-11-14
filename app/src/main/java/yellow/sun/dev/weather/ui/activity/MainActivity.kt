package yellow.sun.dev.weather.ui.activity

import android.os.Bundle
import yellow.sun.dev.weather.R
import yellow.sun.dev.weather.base.BaseActivity
import yellow.sun.dev.weather.databinding.ActivityMainBinding
import androidx.activity.viewModels

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int = R.layout.activity_main
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()

    }

    /**
     * viewModel observe 세팅
     */
    private fun initViewModel() {
        with(viewModel){
            this.isLoading.observe(this@MainActivity) {

            }
        }
    }

}