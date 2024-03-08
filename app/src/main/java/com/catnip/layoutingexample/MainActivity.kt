package com.catnip.layoutingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.catnip.layoutingexample.adapter.CatalogAdapter
import com.catnip.layoutingexample.adapter.CategoryAdapter
import com.catnip.layoutingexample.databinding.ActivityMainBinding
import com.example.layoutexaple.model.Catalog
import com.example.layoutexaple.model.Category
import java.lang.IllegalStateException

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val categoryAdapter = CategoryAdapter()
    private val catalogAdapter = CatalogAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setAction()
        setListCategory()
        setListCatalog()
    }

    private fun setListCategory(){
        val data = listOf(
            Category(image = R.drawable.ic_all, name = "All"),
            Category(image = R.drawable.ic_chicken, name = "Chicken"),
            Category(image = R.drawable.ic_pizza, name = "Pizza"),
            Category(image = R.drawable.ic_burger, name = "Burger"),
            Category(image = R.drawable.ic_mie, name = "Mie"),
        )
        binding.rvCategory.apply {
            adapter = categoryAdapter
        }
        categoryAdapter.submitData(data)
    }

    private fun setListCatalog(){
        val data = listOf(
            Catalog(image = R.drawable.ic_all, name = "pical", price = 30000.0),
            Catalog(image = R.drawable.ic_chicken, name = "Chicken" , price = 80000.0),
            Catalog(image = R.drawable.ic_pizza, name = "Pizza", price = 100000.0),
            Catalog(image = R.drawable.ic_burger, name = "Burger", price = 50000.0),
        )
        binding.rvCatalog.apply {
            adapter = catalogAdapter
        }
        catalogAdapter.submitData(data)
    }


    private fun setAction() {
        binding.layoutHeader.ivProfile.setOnClickListener {
            Toast.makeText(this@MainActivity, "Hai Rohit", Toast.LENGTH_SHORT).show()
        }
        binding.layoutHeader.tvName.text = "Rohit!"
    }
}
