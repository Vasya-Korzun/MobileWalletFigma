package com.example.mobilewalletfigma.main_screen.extension_fun

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.mobilewalletfigma.R

/** Extension fun for Card Number */
fun String.changeCardNumber(): String {
    // Step 1: Заполним строку символами "Х" до длины 19 без пробелов
    val paddedString = this.padEnd(16, 'Х')

    // Step 2: Разбиваем строку на группы по 4 символа
    val groups = paddedString.chunked(4)

    // Step 3: Соединяем группы с пробелами
    return groups.joinToString(" ")
}


/** Extension fun for Card Holder */
@Composable
fun String.changeCardHolder(): String {
    val maskStr = stringResource(R.string.t_label2)
    return this.ifEmpty { maskStr }
}

/** Extension fun for ValidityPeriod */
@Composable
fun String.changeValidityPeriod(): String {
    val maskString = stringResource(R.string.t_label3)
    if (this.isEmpty()) {
        return maskString
    } else {
        val paddedString = this.padEnd(4)
        val groups = paddedString.chunked(2)
        return groups.joinToString("/")
    }
}