fun main() {
    fun moneyTransfer(transerValue: Int,            //переменная суммы перевода
                      summOfTransfers: Int = 0,     //переменная суммы переводов за месяц
                      accountType: String = "VK Pay" //переменная типа платежной системы
    ): String {
        val comission = when (accountType) {
            "VK Pay" -> if (summOfTransfers + transerValue < 40_000 && transerValue < 15_000) "Комиссия 0 копеек"
                else "Превышен лимит"
            "Mastercard", "Maestro" -> when (summOfTransfers) {
                in 0..75_000 - transerValue-> "Комиссия 0 копеек"
                in 600_000 - transerValue..Int.MAX_VALUE -> "Gревышен месячный лимит"
                else -> "Комиссия " + (transerValue * 0.6 + 2000).toString() + " копеек"
            }
            "Visa", "Мир" -> when (summOfTransfers) {
                in 600_000 - transerValue..Int.MAX_VALUE -> "Превышен месячный лимит"
                else -> if (transerValue * 0.0075 > 35) "Комиссия " + (transerValue * 0.75).toString() + " копеек"
                    else "Комиссия 3 500 копеек"
            }
            else -> "Неверный способ оплаты"
        }
        return comission
    }
    //запуск функции со значениями по умолчанию
    println(moneyTransfer(1000))
}