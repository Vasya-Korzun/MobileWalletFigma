package com.example.mobilewalletfigma.card_addition_screen.extension_fun

import androidx.compose.runtime.Composable

/** Extension fun for Card Number */
@Composable
fun String.cardNumberModificationForAdditionScreen(): String {

    return chunked(4).joinToString(" ")
}

