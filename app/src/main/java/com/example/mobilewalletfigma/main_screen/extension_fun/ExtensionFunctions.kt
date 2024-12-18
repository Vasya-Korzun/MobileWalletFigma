package com.example.mobilewalletfigma.main_screen.extension_fun

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
fun String.changeCardHolder(newStr: String): String {
    val result = newStr.ifEmpty { this }
    return result
}


/** Extension fun for ValidityPeriod */
fun String.changeValidityPeriod(newStr: String): String {
    val result: String
    if (newStr.isEmpty()) {
        result = this
    } else {
        val paddedString = newStr.padEnd(4)
        val groups = paddedString.chunked(2)
        result = groups.joinToString("/")
    }
    return result
}