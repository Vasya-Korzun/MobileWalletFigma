package com.example.mobilewalletfigma.faq_screen

import androidx.lifecycle.viewModelScope
import com.example.testfigma1.base.AbstractMviViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterIsInstance
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.merge
import kotlinx.coroutines.flow.scan
import kotlinx.coroutines.flow.stateIn

class FAQViewModel : AbstractMviViewModel<FAQIntent, FAQState, FAQEvent>() {
    override val viewState: StateFlow<FAQState>

    init {
        val initialVS = FAQState.initial()
        viewState = intentSharedFlow
            .shareWhileSubscribed()
            .toPartialStateChangeFlow()
            .scan(initialVS) { vs, change -> change.reduce(vs) }
            .stateIn(
                viewModelScope,
                SharingStarted.Eagerly,
                initialVS
            )
    }

    private fun SharedFlow<FAQIntent>.toPartialStateChangeFlow(): Flow<PartialStateChange> {
        val initialQuestion = filterIsInstance<FAQIntent.Initial>().map {
            PartialStateChange.Initial(Questions)
        }.shareWhileSubscribed()
        return merge(
            initialQuestion
        )
    }

    companion object {
        val Questions = listOf(
            Question(
                "Что такое Mobile Wallet?",
                "Мобильное приложение от ОсОО «Мобильный кошелек» лицензированной " +
                        "платежной компании, которое позволяет пользователям переводить и " +
                        "оплачивать банковские и обязательные услуги физических лиц."
            ),
            Question(
                "Как скачать и установить приложение?",
                "Для пользователей iOS: Загрузите приложение из App Store, найдя " +
                        "его по названию Mobile Wallet. Для пользователей Android:" +
                        " Найдите приложение в Google Play и установите его на ваше устройство."
            ),
            Question(
                "Как зарегистрироваться?",
                "Чтобы зарегистрироваться, выполните следующие шаги:\n" +
                        "1. Откройте приложение и нажмите \"Регистрация\".\n" +
                        "2. Введите свои данные (карточные данные *нужны для проведения платежей," +
                        " имя, адрес электронной почты, телефон).\n" +
                        "3. Создайте надежный пароль.\n" +
                        "4. Примите условия использования и нажмите \"Зарегистрироваться\"."
            ),
            Question(
                "Как защитить свои данные и учетную запись?",
                "Являясь лицензированной Компанией, мы строго соблядаем и " +
                        "придерживаемся международным стандартам безопасности, не храним в " +
                        "открытом доступе пароли, карточные данные и иные персональные данные."
            ),
            Question(
                "Как провести оплату с Mobile Wallet?",
                "Для проведения оплаты вам достаточно привязать вашу Банковскую" +
                        " карту МИР Visa Mastercard, в Мобильное приложения, на которой включены" +
                        " интернет оплаты и есть доступные средства для проведения платежа " +
                        "или перевода."
            ),
            Question(
                "Как отправить перевод?",
                "Для перевода выполните следующие шаги:\n" +
                        "1. Перейдите в раздел \"Переводы\".\n" +
                        "2. Выберите карту (если привязана не одна карта).\n" +
                        "3. Укажите сумму и подтвердите операцию."
            ),
            Question(
                "Какие комиссии применяются?",
                "Комиссии в зависимости от типа перевода и суммы платежа."
            ),
            Question(
                "Что делать, если я забыл пароль?",
                "Чтобы восстановить пароль, выполните следующие шаги:\n" +
                        "1. На экране входа нажмите \"Забыли пароль?\".\n" +
                        "2. Введите адрес электронной почты, связанный с вашей учетной записью.\n" +
                        "3. Следуйте инструкциям в отправленном на ваш адрес письме."
            ),
            Question(
                "Как получить консультацию специалиста?",
                "В мобильном приложении доступен сервис по отправке сообщения " +
                        "технической поддержке."
            ),
            Question(
                "Как оставить отзыв о приложении?",
                "Мы будем рады услышать ваше мнение! Отзывы можно оставить в " +
                        "магазине приложений, где вы его скачали, или отправив их " +
                        "по электронной почте на (email)."
            )
        )
    }
}
