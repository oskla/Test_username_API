package com.example.randomuser.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.randomuser.R
import com.example.randomuser.exampledata.exampleResults
import com.example.randomuser.model.Results
import com.example.randomuser.ui.theme.randomuserTheme


@Composable
fun DetailsBox(
    userData: Results,
    modifier: Modifier = Modifier.fillMaxWidth(),
    cardElevation: Dp = 6.dp,
    cardShape: RoundedCornerShape = RoundedCornerShape(8.dp),
    firstAndLastName: String = "Name",
    horizontalPadding: Dp = 16.dp,
    verticalPadding: Dp = 8.dp

) {
    Card(
        modifier = modifier,
        elevation = cardElevation,
        shape = cardShape
    ) {
        Column() {
            Row(
                modifier = modifier
                    .padding(horizontal = horizontalPadding, vertical = verticalPadding)
            ) {
                InfoBoxDetailsRow(text = firstAndLastName, textCategory = stringResource(R.string.name), fontSize = 22.sp, paddingText = PaddingValues(0.dp, 0.dp, 3.dp, 0.dp))
            }
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = modifier
                    .padding(horizontal = horizontalPadding, vertical = verticalPadding)
                    .height(IntrinsicSize.Max)
            ) {
                Column(
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    InfoBoxDetailsRow(text = userData.gender, textCategory = stringResource(R.string.gender), fontSize = 14.sp)
                    InfoBoxDetailsRow(text = userData.email, textCategory = stringResource(R.string.email), fontSize = 14.sp, maxLines = 2)
                    InfoBoxDetailsRow(text = userData.dob.age.toString(), textCategory = stringResource(R.string.age), fontSize = 14.sp)
                }
                Column(verticalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxHeight()) {
                    InfoBoxDetailsRow(text = userData.nat, textCategory = stringResource(R.string.country), fontSize = 14.sp)
                    InfoBoxDetailsRow(text = userData.pageViews.toString(), textCategory = stringResource(R.string.pageviews), fontSize = 14.sp)
                }
            }
        }
    }
}

@Preview("ComponentPreview (light)", showBackground = true)
@Preview("ComponentPreview (dark)", uiMode = Configuration.UI_MODE_NIGHT_YES)
@Preview("ComponentPreview (big font)", fontScale = 1.5f)
@Preview("ComponentPreview (large screen)", device = Devices.PIXEL_C)
@Composable
fun DetailsBoxPreview() {
    randomuserTheme {
        DetailsBox(userData = exampleResults)
    }
}
