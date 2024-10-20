package com.erdemyesilcicek.greenflowers.sections

import android.widget.Space
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AttachMoney
import androidx.compose.material.icons.rounded.CurrencyYen
import androidx.compose.material.icons.rounded.Euro
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.currentCompositionErrors
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erdemyesilcicek.greenflowers.data.Currency
import com.erdemyesilcicek.greenflowers.ui.theme.GreenStart

val currencies = listOf(
    Currency(
        name = "USD",
        buy = 35.47f,
        sell = 33.89f,
        icon = Icons.Rounded.AttachMoney
    ),

    Currency(
        name = "EUR",
        buy = 36.00f,
        sell = 35.21f,
        icon = Icons.Rounded.Euro
    ),

    Currency(
        name = "YEN",
        buy = 15.21f,
        sell = 13.09f,
        icon = Icons.Rounded.CurrencyYen
    )
)

@Preview
@Composable
fun CurrenciesSection() {
    var isVisible by remember {
        mutableStateOf(false)
    }
    var iconState by remember {
        mutableStateOf(Icons.Rounded.KeyboardArrowUp)
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 32.dp),
        contentAlignment = Alignment.BottomCenter
    ) {


        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(MaterialTheme.colorScheme.inverseOnSurface)
                .animateContentSize()
        ) {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .animateContentSize()
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .clickable {
                            isVisible = !isVisible
                            iconState = if (isVisible) {
                                Icons.Rounded.KeyboardArrowDown
                            } else {
                                Icons.Rounded.KeyboardArrowUp
                            }
                        }
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.secondary)
                ) {
                    Icon(
                        modifier = Modifier.size(25.dp),
                        imageVector = iconState,
                        contentDescription = "Currencies",
                        tint = MaterialTheme.colorScheme.onSecondary
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = "Currencies",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.onSecondaryContainer
                )
            }
            Spacer(
                modifier = Modifier
                    .height(1.dp)
                    .fillMaxWidth()
                    .background(MaterialTheme.colorScheme.onSecondaryContainer)
            )
            if (isVisible) {
                BoxWithConstraints(
                    modifier = Modifier
                        .clip(RoundedCornerShape(topStart = 25.dp, topEnd = 25.dp))
                        .fillMaxSize()
                        .padding(horizontal = 16.dp)
                        .background(MaterialTheme.colorScheme.background)
                ) {
                    val boxWithConstraintsScope = this
                    val width = (boxWithConstraintsScope.maxWidth / 3)

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Spacer(modifier = Modifier.height(16.dp))

                        Row(
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Currency",
                                modifier = Modifier.width(width),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                //textAlign = TextAlign.End
                            )

                            Text(
                                text = "Buy",
                                modifier = Modifier.width(width),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )

                            Text(
                                text = "Sell",
                                modifier = Modifier.width(width),
                                fontWeight = FontWeight.SemiBold,
                                fontSize = 16.sp,
                                color = MaterialTheme.colorScheme.onBackground,
                                textAlign = TextAlign.End
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))

                        LazyColumn {
                            items(currencies.size) { index ->
                                CurrencyItem(
                                    index = index,
                                    width = width
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CurrencyItem(index: Int, width: Dp) {
    val currency = currencies[index]

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .clip(RoundedCornerShape(8.dp))
                .background(GreenStart)
                .padding(4.dp)
        ) {
            Icon(
                modifier = Modifier.size(18.dp),
                imageVector = currency.icon,
                contentDescription = currency.name,
                tint = Color.White
            )
        }

        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = currency.name,
            fontWeight = FontWeight.Bold,
            fontSize = 18.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "${currency.buy}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground,
            textAlign = TextAlign.Center
        )
        Text(
            modifier = Modifier
                .width(width)
                .padding(start = 10.dp),
            text = "${currency.sell}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            color = MaterialTheme.colorScheme.onBackground
        )
    }
}





















