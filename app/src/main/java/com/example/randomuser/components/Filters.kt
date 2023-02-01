package com.example.randomuser.components


import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.randomuser.data.Filter
import com.example.randomuser.data.filters

@Composable
fun FilterButtons(
    selectedFilter: MutableState<Filter?>,
    onClickFilter: () -> Unit
) {
    LazyRow(
        modifier = Modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        itemsIndexed(items = filters) { _, item ->
            IconButton(
                btnText = item.text,
                selectedFilter = selectedFilter,
                onClickFilter = onClickFilter,
                item = item
            )
        }
    }
}



@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun FiltersPreview() {
    randomuserTheme {
        FilterButtons()
    }

