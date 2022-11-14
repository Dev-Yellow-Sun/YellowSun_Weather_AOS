package yellow.sun.dev.weather.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import yellow.sun.dev.weather.R
import yellow.sun.dev.weather.base.BaseActivity
import yellow.sun.dev.weather.databinding.ActivityMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel
import android.os.ext.SdkExtensions.getExtensionVersion

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override val layoutId: Int = R.layout.activity_main
    private val viewModel: MainViewModel by viewModel()

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