package com.example.mobilewalletfigma.main_screen.compose_ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.Black
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
import com.example.mobilewalletfigma.main_screen.MainIntent
import com.example.mobilewalletfigma.main_screen.MainState
import com.example.mobilewalletfigma.ui.theme.Blue40
import com.example.mobilewalletfigma.ui.theme.BorderColor
import com.example.mobilewalletfigma.ui.theme.ButtonColor
import com.example.mobilewalletfigma.ui.theme.FocusedBorderColor
import com.example.mobilewalletfigma.ui.theme.Text40
import com.example.mobilewalletfigma.ui.theme.Text50
import com.example.mobilewalletfigma.ui.theme.TextButtonColor
import com.example.mobilewalletfigma.ui.theme.TextPlaceholder

@Composable
fun AddNewCardScreen(
    innerPadding: PaddingValues,
    viewState: MainState,
    dispatch: (MainIntent) -> Unit,
) {
    Column(
        modifier = Modifier
            .padding(innerPadding)
    ) {
        AddCard()
        Spacer(modifier = Modifier.height(12.dp))
        CreditCard()
        Spacer(modifier = Modifier.height(24.dp))
        CardInfo(viewState, dispatch)
        Spacer(modifier = Modifier.weight(1f))
        Button(
            onClick = { },
            shape = RoundedCornerShape(12.dp),
            modifier = Modifier
                .fillMaxWidth()
                .height(56.dp)
                .padding(horizontal = 20.dp),
            colors = ButtonDefaults.buttonColors(containerColor = ButtonColor)
        ) {
            Text(
                stringResource(R.string.button_add),
                style = TextStyle(
                    color = TextButtonColor,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(600),
                    lineHeight = 24.sp,
                )
            )
        }
        Spacer(modifier = Modifier.height(50.dp))
    }
}


@Composable
fun AddCard() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .padding(start = 22.dp, top = 16.dp, bottom = 16.dp)
    ) {
        Image(
            painter = painterResource(R.drawable.icon_back),
            contentDescription = "",
            modifier = Modifier
                .align(Alignment.TopStart)
        )
        Text(
            text = stringResource(R.string.add_card),
            style = TextStyle(
                color = Black,
                fontSize = 16.sp,
                fontWeight = FontWeight(600),
                lineHeight = 24.sp,
            ),
            modifier = Modifier.align(Alignment.Center)
        )
    }
}


@Composable
fun CreditCard() {
    Box(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .wrapContentHeight()
            .background(color = Blue40, shape = RoundedCornerShape(16.dp))
    ) {

        Image(
            modifier = Modifier.fillMaxWidth(),
            painter = painterResource(R.drawable.icon_bg),
            contentDescription = "",
            contentScale = ContentScale.Crop
        )


        Image(
            painter = painterResource(R.drawable.icon_label_card),
            contentDescription = "",
            modifier = Modifier
                .padding(20.dp)
        )

        Column(modifier = Modifier.padding(top = 92.dp)) {

            Text(
                text = stringResource(R.string.t_label1),
                style = TextStyle(
                    color = White,
                    fontSize = 16.sp,
                    fontWeight = FontWeight(400),
                    lineHeight = 25.6.sp,
                ),
                modifier = Modifier
                    .width(190.dp)
                    .height(26.dp)
                    .padding(horizontal = 20.dp)
            )

            Spacer(modifier = Modifier.height(32.dp))

            Row(modifier = Modifier.padding(horizontal = 20.dp)) {
                Text(
                    text = stringResource(R.string.t_label2),
                    style = TextStyle(
                        color = Text40,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 20.sp,
                    ),
                )

                Text(
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End,
                    text = stringResource(R.string.t_label3),
                    style = TextStyle(
                        color = Text40,
                        fontSize = 12.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 20.sp,
                    ),
                )
            }

        }

    }
}


@Composable
fun CardInfo(viewState: MainState, dispatch: (MainIntent) -> Unit) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
            .height(289.dp)
    ) {

        Text(
            text = stringResource(R.string.card_number),
            style = TextStyle(
                color = Text50,
                fontSize = 14.sp,
                fontWeight = FontWeight(600),
                lineHeight = 22.sp,
            ),
        )

        Spacer(modifier = Modifier.height(8.dp))

        val cardNumber = remember { mutableStateOf(viewState.cardInfo.cardNumber) }    //TODO  ????

        OutlinedTextField(
            value = cardNumber.value,
            onValueChange = { newText -> cardNumber.value = newText },
            placeholder = {
                Text(
                    text = stringResource(R.string.card_placeholder1),
                    style = TextStyle(
                        color = TextPlaceholder,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 24.sp,
                    )
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = BorderColor,
                focusedBorderColor = FocusedBorderColor
            ),
            shape = RoundedCornerShape(12.dp),
        )

        Spacer(modifier = Modifier.height(16.dp))

        Row {
            Column(modifier = Modifier.weight(0.5f)) {
                Text(
                    text = stringResource(R.string.validity_period),
                    style = TextStyle(
                        color = Text50,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        lineHeight = 22.sp,
                    ),
                )

                Spacer(modifier = Modifier.height(8.dp))

                val validityPeriod =
                    remember { mutableStateOf(viewState.cardInfo.validityPeriod) }    //TODO  ????

                OutlinedTextField(
                    value = validityPeriod.value,
                    onValueChange = { newText -> validityPeriod.value = newText },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.card_placeholder2),
                            style = TextStyle(
                                color = TextPlaceholder,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                lineHeight = 24.sp,
                            )
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = BorderColor,
                        focusedBorderColor = FocusedBorderColor
                    ),
                    shape = RoundedCornerShape(12.dp),
                )
            }

            Spacer(modifier = Modifier.width(16.dp))

            Column(modifier = Modifier.weight(0.5f)) {
                Text(
                    text = stringResource(R.string.card_cvv),
                    style = TextStyle(
                        color = Text50,
                        fontSize = 14.sp,
                        fontWeight = FontWeight(600),
                        lineHeight = 22.sp,
                    ),
                )

                Spacer(modifier = Modifier.height(8.dp))

                val cardCvv =
                    remember { mutableStateOf(viewState.cardInfo.cardCvv) }    //TODO  ????

                OutlinedTextField(
                    value = cardCvv.value,
                    onValueChange = { newText -> cardCvv.value = newText },
                    placeholder = {
                        Text(
                            text = stringResource(R.string.card_placeholder3),
                            style = TextStyle(
                                color = TextPlaceholder,
                                fontSize = 16.sp,
                                fontWeight = FontWeight(400),
                                lineHeight = 24.sp,
                            )
                        )
                    },
                    colors = OutlinedTextFieldDefaults.colors(
                        unfocusedBorderColor = BorderColor,
                        focusedBorderColor = FocusedBorderColor
                    ),
                    shape = RoundedCornerShape(12.dp),
                )
            }

        }

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = stringResource(R.string.card_holder),
            style = TextStyle(
                color = Text50,
                fontSize = 14.sp,
                fontWeight = FontWeight(600),
                lineHeight = 22.sp,
            ),
        )

        Spacer(modifier = Modifier.height(8.dp))

        val cardHolder = remember { mutableStateOf(viewState.cardInfo.cardHolder) }    //TODO  ????

        OutlinedTextField(
            value = cardHolder.value,
            onValueChange = { newText -> cardHolder.value = newText },
            placeholder = {
                Text(
                    text = stringResource(R.string.full_name),
                    style = TextStyle(
                        color = TextPlaceholder,
                        fontSize = 16.sp,
                        fontWeight = FontWeight(400),
                        lineHeight = 24.sp,
                    )
                )
            },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = BorderColor,
                focusedBorderColor = FocusedBorderColor
            ),
            shape = RoundedCornerShape(12.dp),
        )

    }
}


@Preview(showBackground = true)
@Composable
fun PreviewAddNewCardScreen() {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        contentColor = White
    ) { innerPadding ->
        AddNewCardScreen(
            innerPadding,
            viewState = MainState.initial(),
            dispatch = {}
        )
    }
}
