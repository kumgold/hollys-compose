package com.test_application.hollyscompose.ui.home

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import androidx.constraintlayout.compose.ConstraintLayout
import com.test_application.hollyscompose.R
import com.test_application.hollyscompose.ui.compose.HollysTopAppBar
import com.test_application.hollyscompose.ui.theme.HollysTypography
import com.test_application.hollyscompose.ui.theme.MainBottomStartRoundShape
import com.test_application.hollyscompose.ui.theme.Red

@Composable
fun HomeScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        topBar = { HollysTopAppBar() },
    ) {
        Column {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(id = R.string.user_intro_comment),
                style = MaterialTheme.typography.caption,
                textAlign = TextAlign.Center
            )

            ConstraintLayout {
                val (delivery, order) = createRefs()

                HomeDropDownButton(
                    modifier = Modifier
                        .constrainAs(delivery) {
                            top.linkTo(parent.top)
                        }
                        .zIndex(1.0f),
                    title = R.string.delivery_button_title,
                    subtitle = R.string.delivery_button_subtitle
                )
                HomeDropDownButton(
                    modifier = Modifier.constrainAs(order) {
                        top.linkTo(parent.top)
                    },
                    mainColor = Red,
                    subColor = Color.White,
                    topMargin = 150.dp,
                    title = R.string.smart_order_button_title,
                    subtitle = R.string.smart_order_button_subtitle,
                    dropdownIcon = Icons.Filled.KeyboardArrowRight
                )
                Spacer(modifier = Modifier.height(50.dp))

            }
        }
    }
}

@Composable
fun HomeDropDownButton(
    modifier: Modifier,
    mainColor: Color = MaterialTheme.colors.background,
    subColor: Color = MaterialTheme.colors.surface,
    thirdColor: Color = Red,
    topMargin: Dp = 30.dp,
    @StringRes title: Int,
    @StringRes subtitle: Int,
    dropdownIcon: ImageVector = Icons.Filled.KeyboardArrowDown
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(MainBottomStartRoundShape)
            .background(mainColor)
            .clickable { }
            .padding(35.dp, topMargin, 20.dp, 40.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column {
            Text(
                text = stringResource(id = title),
                color = subColor,
                style = MaterialTheme.typography.h1
            )
            Text(
                text = stringResource(id = subtitle),
                color = subColor,
                style = MaterialTheme.typography.body1
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Box(
           modifier = Modifier
               .size(30.dp)
               .clip(CircleShape)
               .background(thirdColor)
        ) {
            Icon(
                modifier = Modifier
                    .fillMaxSize(),
                imageVector = dropdownIcon,
                contentDescription = null,
                tint = mainColor
            )
        }
    }
}

@Composable
fun HomeNavigationIconButton() {
    
}

@Composable
@Preview
private fun HomeDropDownButtonPreView() {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) {
        ConstraintLayout {
            val (delivery, order) = createRefs()

            HomeDropDownButton(
                modifier = Modifier
                    .constrainAs(delivery) {
                        top.linkTo(parent.top)
                    }
                    .zIndex(1.0f),
                mainColor = Color.Black,
                subColor = Color.White,
                thirdColor = Red,
                topMargin = 40.dp,
                title = R.string.delivery_button_title,
                subtitle = R.string.delivery_button_subtitle
            )
            HomeDropDownButton(
                modifier = Modifier.constrainAs(order) {
                    top.linkTo(parent.top)
                },
                mainColor = Color.Red,
                subColor = Color.White,
                topMargin = 150.dp,
                title = R.string.smart_order_button_title,
                subtitle = R.string.smart_order_button_subtitle
            )
        }
    }
}