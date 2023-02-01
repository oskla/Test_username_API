package com.example.randomuser.components

import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.randomuser.data.Filter

@Composable
fun SearchAndFilter(
    verticalPadding: Dp = 16.dp,
    selectedFilter: MutableState<Filter?>,
    onClickFilter: () -> Unit,
    activeFilters: SnapshotStateList<Filter>
) {
    Column(
        verticalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier.padding(vertical = verticalPadding)
    ) {
        FilterButtons(selectedFilter = selectedFilter, onClickFilter = onClickFilter, activeFilters = activeFilters)
        Spacer(modifier = Modifier.height(verticalPadding))
        SearchView()
    }
}

/*@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun SearchAndFilterPreview() {
    randomuserTheme {
        SearchAndFilter()
    }
}*/
