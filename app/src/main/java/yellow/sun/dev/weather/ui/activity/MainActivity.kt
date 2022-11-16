package yellow.sun.dev.weather.ui.activity

import android.os.Bundle
import androidx.fragment.app.Fragment
import yellow.sun.dev.weather.R
import yellow.sun.dev.weather.base.BaseActivity
import yellow.sun.dev.weather.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import yellow.sun.dev.weather.ui.fragment.WeatherFragment

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int = R.layout.activity_main
    private val viewModel: MainViewModel by viewModel()
    private lateinit var pageAdapter: MainPageAdapter

    /** init Fragment **/
    private val fragmentList = mutableListOf(
        WeatherFragment() as Fragment
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        initViewModel()
        initViewPager()
    }

    /**
     * viewPager UI 세팅
     */
    private fun initViewPager(){
        pageAdapter = MainPageAdapter(this, fragmentList)
        with(binding.vpMain) {
            adapter = pageAdapter
            isUserInputEnabled = false      // 스와이프 막기
        }
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