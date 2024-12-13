package com.example.mobilewalletfigma.other_screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilewalletfigma.R
import com.example.mobilewalletfigma.ui.theme.Blue300
import com.example.mobilewalletfigma.ui.theme.Blue400


@Preview
@Composable
fun CardInfo() {
    Box(
        modifier = Modifier
            .background(color = Black)
            .wrapContentSize()
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 36.dp, end = 36.dp, top = 88.dp)
                .height(40.dp)
                .background(Blue300, RoundedCornerShape(12.dp))


        )
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 28.dp, end = 28.dp, top = 82.dp)
                .height(40.dp)
                .background(Blue400, shape = RoundedCornerShape(14.dp))
        )


        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp, end = 20.dp, top = 12.dp)
        ) {
            Column(
                modifier = Modifier
                    .background(color = Color(0xFF3C7BF3), shape = RoundedCornerShape(size = 16.dp))
                    .fillMaxWidth()
                    .height(102.dp)
                    .padding(20.dp)
            ) {
                Row {
                    Text(
                        text = "**** 9299",
                        style = TextStyle(
                            fontWeight = FontWeight(400),
                            fontSize = 16.sp,
                            lineHeight = 25.6.sp,
//                        fontFamily = interTight400,
                            letterSpacing = 0.2.sp,
                            color = White,
                        )
                    )

                    Spacer(Modifier.width(16.dp))

                    Image(
                        painter = painterResource(R.drawable.icon_label_visa),
                        contentDescription = "",
                    )
                }

                Spacer(modifier = Modifier.weight(1f))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = "Jon Smith",
                        style = TextStyle(
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            lineHeight = 20.sp,
//                        fontFamily = interTight400,
                            letterSpacing = 0.3.sp,
                            color = Color(0xFFC0D4FB),
                        )
                    )
                    Text(
                        text = "03/26",
                        style = TextStyle(
                            fontWeight = FontWeight(400),
                            fontSize = 12.sp,
                            lineHeight = 20.sp,
//                        fontFamily = interTight400,
                            letterSpacing = 0.3.sp,
                            color = Color(0xFFC0D4FB),
                        )
                    )
                }
            }
            Row {
                Image(
                    painter = painterResource(R.drawable.icon_bg_2),
                    contentDescription = "",
                    modifier = Modifier,
                    contentScale = ContentScale.Crop
                )
                Image(
                    painter = painterResource(R.drawable.icon_bg_3),
                    contentDescription = "",
                    modifier = Modifier
                        .offset((-6).dp),
                    contentScale = ContentScale.Crop,

                    )
            }
        }
    }
}
