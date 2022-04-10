package com.vikas.groceryapp

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.RecyclerView
import com.vikas.groceryapp.adapters.GroceryListAdapter
import com.vikas.groceryapp.utilities.KEY_SEARCH_QUERY
import com.vikas.groceryapp.viewmodels.GroceryListViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: GroceryListViewModel by viewModels()
    private var fetchJob: Job? = null
    private val adapter = GroceryListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<RecyclerView>(R.id.groceryItemsRv).adapter = adapter
        //TODO
        //Filter query can be passed from here
        //Skipping that due to lack of time
        fetchGroceries(KEY_SEARCH_QUERY)
    }

    private fun fetchGroceries(query: String) {
        fetchJob?.cancel()
        fetchJob = lifecycleScope.launch {
            viewModel.getGroceries(query).collectLatest {
                adapter.submitData(it)
            }
        }
    }
}