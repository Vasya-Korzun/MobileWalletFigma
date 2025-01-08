package com.example.mobilewalletfigma.card_addition_screen.compose

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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mobilewalletfigma.R
import com.example.mobilewalletfigma.card_addition_screen.custom.InputField
import com.example.mobilewalletfigma.main_screen.MainIntent
import com.example.mobilewalletfigma.main_screen.MainState
import com.example.mobilewalletfigma.main_screen.extension_fun.changeCardNumber
import com.example.mobilewalletfigma.main_screen.extension_fun.changeValidityPeriod
import com.example.mobilewalletfigma.main_screen.transformations.DateDefaults.DATE_LENGTH
import com.example.mobilewalletfigma.main_screen.transformations.NumberDefaults.CARD_NUMBER_LENGTH
import com.example.mobilewalletfigma.ui.theme.BackgroundCardSuccessColor

@Composable
fun CardAdditionScreen(
    viewState: MainState,
    dispatch: (MainIntent) -> Unit,
) {
    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(25.dp))
//            .background(backgroundMain),
            .background(BackgroundCardSuccessColor),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 20.dp)
        ) {
//            BottomSheetHeader()
//            TitleAppBar(
//                title = stringResource(R.string.card_additional_add_card)
//            )
            Spacer(modifier = Modifier.height(28.dp))
            CreditCard(viewState)
            Spacer(modifier = Modifier.height(24.dp))
            CardInfoFields(viewState, dispatch)
            Spacer(modifier = Modifier.weight(1f))
//            BaseButton(
//                onClick = {},
//                text = stringResource(R.string.card_additional_add),
//                enabled = true,
//                isInProgress = false
//            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun CreditCard(viewState: MainState) {
    Box(
        modifier = Modifier
            .height(190.dp)
//            .background(color = backgroundBrandPrimary, shape = RoundedCornerShape(16.dp))
            .background(color = Color.White, shape = RoundedCornerShape(16.dp))
    ) {
        Image(
            modifier = Modifier.fillMaxSize(),
//            painter = painterResource(R.drawable.bg_card),
            painter = painterResource(R.drawable.icon_bg),
            contentDescription = "",
            contentScale = ContentScale.FillHeight
        )

        Column(
            modifier = Modifier.padding(20.dp)
        ) {
            Image(
//                painter = painterResource(R.drawable.ic_card_label),
                painter = painterResource(R.drawable.icon_label_card),
                contentDescription = ""
            )

            Spacer(Modifier.weight(1f))
            Text(
                text = viewState.cardNumber.changeCardNumber(),
                style = TextStyle(
//                    fontFamily = interTight400,
                    fontSize = 16.sp,
//                    color = textOnBrandPrimary,
                    color = Color.Black,
                )
            )
            Spacer(modifier = Modifier.height(32.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = viewState.cardHolder.ifEmpty {
                        stringResource(R.string.card_additional_card_holder)
                    },
                    style = TextStyle(
//                        color = textOnBrandSecondary,
                        color = Color.Black,
                        fontSize = 12.sp,
//                        fontFamily = interTight400,
                    ),
                )
                Text(
                    text = viewState.validityPeriod.changeValidityPeriod(),
                    style = TextStyle(
//                        color = textOnBrandSecondary,
                        color = Color.Black,
                        fontSize = 12.sp,
//                        fontFamily = interTight400,
                    )
                )
            }
        }
    }
}


@Composable
fun CardInfoFields(viewState: MainState, dispatch: (MainIntent) -> Unit) {
    Column {
        InputField(
            value = viewState.cardNumber,
//            value = viewState.cardNumber.cardNumberModificationForAdditionScreen(),
//            value = TextFieldValue(
//                text = viewState.cardNumber.cardNumberModificationForAdditionScreen(),
//                selection = TextRange(viewState.cardNumber.length) // Put cursor to the end
//            ),
            onValueChange = { newText ->
                if (newText.length <= CARD_NUMBER_LENGTH) {
                    dispatch(MainIntent.InputCardNumber(newText.filter { it.isDigit() }))
                }
            },
            label = stringResource(R.string.card_additional_card_number),
            enabled = true,
            isError = false,
            onCardNumberInput = true,
//            placeholder = CARD_NUMBER_MASK,
            placeholder = "0000 0000 0000 0000",
            errorText = if (viewState.cardNumber.isEmpty()) {
                stringResource(R.string.card_additional_enter_card_number)
            } else {
                stringResource(R.string.card_additional_card_number)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next,
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        InputField(
            value = viewState.cardHolder,
            onValueChange = { newText ->
                dispatch(MainIntent.InputCardHolder(newText))
            },
            label = stringResource(R.string.card_additional_card_holder),
            enabled = true,
            isError = false,
            placeholder = stringResource(R.string.card_additional_card_holder_placeholder),
            errorText = if (viewState.cardHolder.isEmpty()) {
                stringResource(R.string.card_additional_enter_card_holder)
            } else {
                stringResource(R.string.card_additional_card_holder)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
            )
        )

        Spacer(modifier = Modifier.height(16.dp))

        InputField(
            value = viewState.validityPeriod,
            onValueChange = { newText ->
                if (newText.length <= DATE_LENGTH) {
                    dispatch(MainIntent.InputCardValidityPeriod(newText.filter { it.isDigit() }))
                }
            },
            label = stringResource(R.string.card_additional_card_verify_period),
            enabled = true,
            isError = false,
//            placeholder = stringResource(R.string.card_additional_card_holder_placeholder),
            placeholder = "ММ/ГГ",
            errorText = if (viewState.validityPeriod.isEmpty()) {
                stringResource(R.string.card_additional_enter_card_verify_period)
            } else {
                stringResource(R.string.card_additional_card_verify_period)
            },
            keyboardOptions = KeyboardOptions.Default.copy(
                keyboardType = KeyboardType.Text,
                imeAction = ImeAction.Next,
            )
        )

    }
}

@Preview(showBackground = true)
@Composable
fun PreviewAddNewCardScreen() {
    CardAdditionScreen(
        viewState = MainState.initial(),
        dispatch = {}
    )
}