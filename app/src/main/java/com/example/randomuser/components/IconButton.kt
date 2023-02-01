package com.example.randomuser.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.snapshots.SnapshotStateList
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.randomuser.data.Filter

@Composable
fun IconButton(
    btnText: String,
    btnTextColor: Color = Color.Black,
    btnBg: Color = MaterialTheme.colors.secondary,
    btnBgSelected: Color = MaterialTheme.colors.secondaryVariant,
    btnShape: RoundedCornerShape = RoundedCornerShape(4.dp),
    paddingVertical: Dp = 8.dp,
    paddingHorizontal: Dp = 16.dp,
    selectedFilter: MutableState<Filter?>,
    onClickFilter: () -> Unit,
    filter: Filter,
    activeFilters: SnapshotStateList<Filter>
) {
    // var selected by rememberSaveable { mutableStateOf(false) }
    // var color by rememberSaveable { mutableStateOf( btnBg )
    val selectedColor = remember { mutableStateOf(btnBg) }

    Box(
        modifier = Modifier
            .clip(shape = btnShape)
            .background(selectedColor.value)
            .padding(horizontal = paddingHorizontal, vertical = paddingVertical)
            .clickable(onClick = {
                // Set the selected filter to this one
                selectedFilter.value = filter

                // If it's not selected, set it to selected and vice versa
                selectedFilter.value?.let { it.selected = !it.selected }

                // If selected - set bg to orange
                // if not - set bg to gray
                if (selectedFilter.value?.selected == true) {
                    selectedColor.value = btnBgSelected
                } else {
                    selectedColor.value = btnBg
                }

                onClickFilter()
            })

    ) {
        Text(text = btnText, color = btnTextColor)
    }
}
