package com.rahayu.barterfin.ui.presentation.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.DockedSearchBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rahayu.barterfin.R
import com.rahayu.barterfin.ui.theme.BarterfinTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar(
    modifier: Modifier = Modifier,
    query: String,
    onQueryChange: (String) -> Unit,
    onSearch: (String) -> Unit,
    expanded: Boolean = false,
    searchHistory: List<String> = emptyList(),
) {
    DockedSearchBar(
        inputField = {
            OutlinedTextField(
                value = query,
                onValueChange = onQueryChange,
                modifier = modifier.fillMaxWidth(),
                placeholder = {
                    Text(
                        stringResource(R.string.search_placeholder),
                        style = MaterialTheme.typography.bodyLarge.copy(
                            color = Color(0xFF6B7280)
                        ),
                    )
                },
                trailingIcon = {
                    Icon(
                        imageVector = Icons.Default.Search,
                        contentDescription = stringResource(R.string.search_description),
                        modifier = Modifier.clickable { onSearch(query) }
                    )
                },
                singleLine = true,
            )
        },
        expanded = expanded,
        onExpandedChange =  { expanded ->
            if (!expanded) {
                onQueryChange("")
            }
        },
        shape = RoundedCornerShape(16.dp),
    ) {
        if (searchHistory.isNotEmpty()) {
            Text(
                text = stringResource(R.string.recent_searches),
                style = MaterialTheme.typography.bodyMedium.copy(
                    color = Color(0xFF6B7280)
                ),
                modifier = Modifier.padding(start = 16.dp, top = 8.dp)
            )
            searchHistory.forEach { historyItem ->
                Spacer(Modifier.height(8.dp))
                Text(
                    text = historyItem,
                    maxLines = 1,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onQueryChange(historyItem) }
                        .padding(horizontal = 16.dp),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewMySearchBar() {
    BarterfinTheme {
        SearchBar(
            query = "",
            onQueryChange = {},
            onSearch = {},
            expanded = true,
            searchHistory = listOf("Item 1", "Item 2", "Item 3")
        )
    }
}