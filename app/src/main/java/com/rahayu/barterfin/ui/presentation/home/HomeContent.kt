package com.rahayu.barterfin.ui.presentation.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rahayu.barterfin.ui.presentation.components.ItemProduct
import com.rahayu.barterfin.ui.presentation.components.SearchBar
import com.rahayu.barterfin.utilities.dummyProducts
import kotlinx.coroutines.delay

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeContent(
    modifier: Modifier = Modifier,
) {
    var searchQuery by remember { mutableStateOf("") }
    var searchActive by remember { mutableStateOf(false) }
    val searchHistoryList = remember { mutableStateOf(listOf("Sneakers", "Bag", "Camera")) }

    Column(
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            query = searchQuery,
            onQueryChange = { newQuery ->
                searchQuery = newQuery
                if (newQuery.isNotEmpty() && !searchActive) {
                    searchActive = true
                }
            },
            onSearch = { newSearchQuery ->
                if (newSearchQuery.isNotBlank() && !searchHistoryList.value.contains(newSearchQuery)) {
                    searchHistoryList.value = searchHistoryList.value + newSearchQuery
                }
                println("Searching for: $newSearchQuery")
                searchActive = false
            },
            expanded = searchActive,
            searchHistory = searchHistoryList.value
        )

        LazyVerticalGrid(
            columns = GridCells.Fixed(2),
            modifier = Modifier.fillMaxSize(),
            contentPadding = PaddingValues(
                horizontal = 16.dp,
                vertical = 0.dp
            ),
            horizontalArrangement = Arrangement.spacedBy(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items (
                items = dummyProducts,
                key = { product -> product.id }
            ) { product ->
                val currentLoadingStatus = remember { mutableStateOf(false) }
                if (product.id == "1") {
                    LaunchedEffect(Unit) {
                        currentLoadingStatus.value = true
                        delay(2000)
                        currentLoadingStatus.value = false
                    }
                }

                ItemProduct(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(IntrinsicSize.Max),
                    onClick = {
                        println("Product clicked: ${product.title}")
                    },
                    loading = currentLoadingStatus.value,
                    title = product.title,
                    imageUrl = product.imageUrl,
                    category = product.category,
                    location = product.location,
                    price = product.price,
                    desc = product.description
                )
            }
        }
    }
}