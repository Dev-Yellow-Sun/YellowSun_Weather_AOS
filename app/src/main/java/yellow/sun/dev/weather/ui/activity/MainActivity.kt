package yellow.sun.dev.weather.ui.activity

import android.content.SharedPreferences
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import yellow.sun.dev.weather.R
import yellow.sun.dev.weather.base.BaseActivity
import yellow.sun.dev.weather.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import yellow.sun.dev.weather.ui.fragment.WeatherFragment
import yellow.sun.dev.weather.utils.L

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

        handleDeepLink()
        testSharedPreference()

        binding.tv2.setOnClickListener {
            val uri = Uri.parse("https://instagram.com/")
            val i = Intent(Intent.ACTION_VIEW, uri)
            i.setPackage("com.instagram.android")
            startActivity(i)
        }
    }


    private fun testSharedPreference() {
        val sharedPreference = getSharedPreferences("myName", MODE_PRIVATE)
        L.d("testSharedPreference name : ${sharedPreference.getString("name", "No Data!")}")
        val editor: SharedPreferences.Editor = sharedPreference.edit()
        editor.putString("name", "KIU")

        editor.commit()


        L.d("testSharedPreference name : ${sharedPreference.getString("name", "No Data!")}")
    }

    /**
     * DeepLink 데이터 수신
     */
    private fun handleDeepLink() {
        val deepLink: Uri? = intent.data
        L.d("handleDeepLink deepLink : $deepLink")

        val age = deepLink?.getQueryParameter("age") ?: ""
        val name = deepLink?.getQueryParameter("name") ?: ""

        L.d("handleDeepLink age : $age")
        L.d("handleDeepLink name : $name")
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