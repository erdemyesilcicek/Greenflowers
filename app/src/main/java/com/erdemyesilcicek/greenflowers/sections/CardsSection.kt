package com.erdemyesilcicek.greenflowers.sections

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.erdemyesilcicek.greenflowers.R
import com.erdemyesilcicek.greenflowers.data.Card
import com.erdemyesilcicek.greenflowers.ui.theme.BlueEnd
import com.erdemyesilcicek.greenflowers.ui.theme.BlueStart
import com.erdemyesilcicek.greenflowers.ui.theme.GreenEnd
import com.erdemyesilcicek.greenflowers.ui.theme.GreenStart
import com.erdemyesilcicek.greenflowers.ui.theme.OrangeEnd
import com.erdemyesilcicek.greenflowers.ui.theme.OrangeStart
import com.erdemyesilcicek.greenflowers.ui.theme.PurpleEnd
import com.erdemyesilcicek.greenflowers.ui.theme.PurpleStart

val cards = listOf(
    Card(
        cardType = "VISA",
        cardNumber = "1752 0502 2611 1902",
        cardName = "Business",
        balance = 1752.02,
        color = getGradient(PurpleStart, PurpleEnd),
    ),

    Card(
        cardType = "MASTER CARD",
        cardNumber = "1705 2002 6161 5858",
        cardName = "Savings",
        balance = 170561.00,
        color = getGradient(BlueStart, BlueEnd),
    ),

    Card(
        cardType = "VISA",
        cardNumber = "2705 2003 0000 6161",
        cardName = "School",
        balance = 9999.99,
        color = getGradient(OrangeStart, OrangeEnd),
    ),

    Card(
        cardType = "MASTER CARD",
        cardNumber = "2705 2003 1705 2002",
        cardName = "Trips",
        balance = 1705.02,
        color = getGradient(GreenStart, GreenEnd),
    )
)

fun getGradient(
    startColor : Color,
    endColor : Color,
) : Brush{
    return Brush.horizontalGradient(
        colors = listOf(startColor, endColor)
    )
}

@Preview
@Composable
fun CardsSection(){
    LazyRow {
        items(cards.size){ index ->
            CardItem(index)
        }
    }
}

@Composable
fun CardItem(index : Int){
    val card = cards[index]
    var lastItemPaddingEnd = 0.dp
    if(index == cards.size -1){
        lastItemPaddingEnd = 16.dp
    }

    var image = painterResource(id = R.drawable.visa)
    if(card.cardType == "MASTER CARD"){
        image = painterResource(id = R.drawable.mastercard)
    }

    Box(modifier = Modifier
        .padding(start = 16.dp, end = lastItemPaddingEnd)
    ){
        Column(
            modifier = Modifier
                .clip(RoundedCornerShape(25.dp))
                .background(card.color)
                .width(250.dp)
                .height(160.dp)
                .clickable {}
                .padding(vertical = 12.dp, horizontal = 16.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = image,
                contentDescription = card.cardName,
                modifier = Modifier.width(60.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "${card.balance}",
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardNumber,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
            Text(
                text = card.cardName,
                color = Color.White,
                fontSize = 17.sp,
                fontWeight = FontWeight.Bold
            )
        }
    }
}





















