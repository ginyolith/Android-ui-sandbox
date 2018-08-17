package jp.ginyolith.androiduisandbox

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import jp.ginyolith.androiduisandbox.databinding.ActivityMainBinding
import jp.ginyolith.androiduisandbox.databinding.ItemListBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.list.adapter = ArticleListAdapter(listOf("hoge","fuga","foo", "bar").map { HogeModel(it) })
        binding.list.layoutManager = LinearLayoutManager(this)
    }

    class ArticleListAdapter(private val dataList : List<HogeModel>)
        : RecyclerView.Adapter<ArticleListAdapter.BindingHolder>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BindingHolder {
            val inflater : LayoutInflater = LayoutInflater.from(parent.context)
            val binding = ItemListBinding.inflate(inflater, parent, false)
            return BindingHolder(binding)
        }

        override fun getItemCount(): Int = dataList.size

        override fun onBindViewHolder(holder: BindingHolder, position: Int) {
            val model= dataList[position]
            model.isTop = position == 0
            model.isBottom = position == dataList.size - 1

            holder.binding.model = model
        }

        class BindingHolder(var binding : ItemListBinding) : RecyclerView.ViewHolder(binding.root)
    }

}
