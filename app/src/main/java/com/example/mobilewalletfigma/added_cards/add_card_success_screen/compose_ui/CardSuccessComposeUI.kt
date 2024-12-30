package com.example.mobilewalletfigma.added_cards.add_card_success_screen.compose_ui

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
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilewalletfigma.R
import com.example.mobilewalletfigma.added_cards.add_card_success_screen.CardSuccessIntent
import com.example.mobilewalletfigma.added_cards.add_card_success_screen.CardSuccessState
import com.example.mobilewalletfigma.main_screen.extension_fun.changeCardHolder
import com.example.mobilewalletfigma.main_screen.extension_fun.changeCardNumber
import com.example.mobilewalletfigma.main_screen.extension_fun.changeValidityPeriod
import com.example.mobilewalletfigma.ui.theme.BackgroundCardSuccessColor
import com.example.mobilewalletfigma.ui.theme.ButtonColor
import com.example.mobilewalletfigma.ui.theme.InfoText1
import com.example.mobilewalletfigma.ui.theme.InfoText2
import com.example.mobilewalletfigma.ui.theme.Text40
import com.example.mobilewalletfigma.ui.theme.TextButtonColor

@Composable
fun CardSuccessScreen(
    viewState: CardSuccessState,
    dispatch: (CardSuccessIntent) -> Unit,
    onButtonClickBack: () -> Unit,
    textCardNumber: String
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            TopBar()
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(start = 20.dp, end = 20.dp, top = 12.dp, bottom = 50.dp)
            ) {
                CreditCard(viewState, textCardNumber)
                Spacer(modifier = Modifier.height(48.dp))
                Info()
                Spacer(modifier = Modifier.weight(1f))
                CardButton(onButtonClickBack)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCardSuccessScreen() {
    CardSuccessScreen(
        viewState = CardSuccessState.initial(),
        dispatch = {},
        onButtonClickBack = {},
        textCardNumber = stringResource(R.string.t_label1),
    )
}

@Composable
fun TopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        horizontalArrangement = Arrangement.End,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Image(
            modifier = Modifier.padding(horizontal = 20.dp),
            painter = painterResource(R.drawable.icon_close_outline),
            contentDescription = "",
        )
    }
}

@Composable
fun CreditCard(
    viewState: CardSuccessState,
    textCardNumber: String,
) {
    Box(
        modifier = Modifier
            .padding(horizontal = 26.dp)
            .height(156.dp)
            .background(color = BackgroundCardSuccessColor, shape = RoundedCornerShape(16.dp))
    ) {
        Image(
            painter = painterResource(R.drawable.icon_bg),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )
        Image(
            painter = painterResource(R.drawable.icon_label_visa),
            contentDescription = "",
            modifier = Modifier
                .padding(start = 20.dp, top = 20.dp)
        )
        Column(
            modifier = Modifier.padding(top = 75.dp)
        ) {
            Text(
                text = textCardNumber.changeCardNumber(),
                style = TextStyle(
                    fontWeight = FontWeight(400),
                    fontSize = 13.sp,
                    lineHeight = 21.sp,
                    color = White,
                ),
                modifier = Modifier
                    .padding(start = 16.4.dp)
            )
            Spacer(modifier = Modifier.height(26.6.dp))
            Row(modifier = Modifier.padding(horizontal = 16.4.dp)) {
                Text(
                    text = viewState.cardHolder.changeCardHolder(),
                    style = TextStyle(
                        color = Text40,
                        fontSize = 10.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 16.4.sp,
                    ),
                )
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    text = viewState.validityPeriod.changeValidityPeriod(),
                    style = TextStyle(
                        color = Text40,
                        fontSize = 10.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 16.4.sp,
                    ),
                )
            }
        }
    }
}

@Composable
fun Info() {
    Column(
        modifier = Modifier
            .padding(horizontal = 7.dp)
            .fillMaxWidth()
    ) {
        Text(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = stringResource(R.string.card_success_text1),
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = InfoText1,
                fontSize = 28.sp,
                fontWeight = FontWeight(600),
                lineHeight = 42.sp,
            ),
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(
            modifier = Modifier.align(alignment = Alignment.CenterHorizontally),
            text = stringResource(R.string.card_success_text2),
            textAlign = TextAlign.Center,
            style = TextStyle(
                color = InfoText2,
                fontSize = 14.sp,
                fontWeight = FontWeight(400),
                lineHeight = 22.sp,
            ),
        )
    }
}

@Composable
fun CardButton(onButtonClickBack: () -> Unit) {
    Button(
        onClick = { onButtonClickBack() },
        shape = RoundedCornerShape(12.dp),
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp),
        colors = ButtonDefaults.buttonColors(containerColor = ButtonColor)
    ) {
        Text(
            stringResource(R.string.button_home),
            style = TextStyle(
                color = TextButtonColor,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                lineHeight = 24.sp,
            )
        )
    }
}