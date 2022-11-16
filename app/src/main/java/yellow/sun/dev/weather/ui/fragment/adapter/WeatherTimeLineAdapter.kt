package yellow.sun.dev.weather.ui.fragment.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import yellow.sun.dev.weather.R
import yellow.sun.dev.weather.data.WeatherTimeLineData
import yellow.sun.dev.weather.databinding.ItemWeatherTimeLineBinding

class WeatherTimeLineAdapter(
    private val weatherItems: MutableList<WeatherTimeLineData>
): RecyclerView.Adapter<WeatherTimeLineAdapter.WeatherTimeLineViewHolder>() {

    private val itemList: MutableList<WeatherTimeLineData> = mutableListOf()

    init {
        itemList.addAll(weatherItems)
        setHasStableIds(true)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherTimeLineViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_weather_time_line, parent, false)
        return WeatherTimeLineViewHolder(view)
    }

    override fun onBindViewHolder(holder: WeatherTimeLineViewHolder, position: Int) {
        holder.bindView(position)
    }

    override fun getItemCount(): Int = itemList.size

    override fun getItemId(position: Int): Long = position.toLong()

    fun changeItemList(weatherItems: MutableList<WeatherTimeLineData>) {
        itemList.clear()
        itemList.addAll(weatherItems)
        notifyDataSetChanged()
    }


    inner class WeatherTimeLineViewHolder(
        private val itemView: View
    ): RecyclerView.ViewHolder(itemView) {
        private val binding: ItemWeatherTimeLineBinding? = DataBindingUtil.bind(itemView)

        fun bindView(position: Int) {
            binding?.let { b ->
                with(itemList[position]) {
                    b.tvTime.text = this.time
                    b.tvTemperature.text = this.temperature
                    b.tvPop.text = this.pop
                    this.drawable?.let { d ->
                        b.ivWeather.setImageDrawable(d)
                    }

                }
            }
        }
    }

}