package ru.skillbranch.devintensive.extensions

import ru.skillbranch.devintensive.utils.Plural
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by linuxshaman on 30,June,2019
 */

private val minutesPlural = Plural(
    "минут назад",
    "минуту назад",
    "минуты назад",
    "минут назад"
)

private val hourPlural = Plural(
    "часов назад",
    "час назад",
    "часа назад",
    "часов назад"
)

private val daysPlural = Plural(
    "дней назад",
    "день назад",
    "дня назад",
    "дней назад"
)


fun Date.format(pattern : String = "HH:mm:ss dd.MM.yy") : String {
    val formatter = SimpleDateFormat(pattern, Locale("ru"))
    return formatter.format(this)
}



fun Date.add(value : Int, unit : TimeUnit) : Date{
    val time = this.time + (value * unit.millis)
    this.time = time
    return this
}


fun Date.humanizeDiff(date : Date = Date()) : String {
    return when (val diff = date.time - this.time) {
        in 0 until TimeUnit.SECOND.millis -> "только что"
        in (TimeUnit.SECOND.millis) until (TimeUnit.SECOND.millis * 45) -> "несколько секунд назад"
        in (TimeUnit.SECOND.millis * 45) until (TimeUnit.SECOND.millis * 75) -> "минуту назад"
        in (TimeUnit.SECOND.millis * 75) until (TimeUnit.MINUTE.millis * 45) -> run {
            minutesPlural.pluralString(diff / TimeUnit.MINUTE.millis)
        }
        in (TimeUnit.MINUTE.millis * 45) until (TimeUnit.MINUTE.millis * 75) -> "час назад"
        in (TimeUnit.MINUTE.millis * 75) until (TimeUnit.HOUR.millis * 22) -> run {
            hourPlural.pluralString(diff / TimeUnit.HOUR.millis)
        }
        in (TimeUnit.HOUR.millis * 22) until (TimeUnit.HOUR.millis * 26) -> "день назад"
        in (TimeUnit.HOUR.millis * 26) until (TimeUnit.DAY.millis * 360) -> run {
            daysPlural.pluralString(diff / TimeUnit.DAY.millis)
        }
        else -> "более года назад"
    }

}



enum class TimeUnit(val millis : Long) {
    SECOND(1000L),
    MINUTE(SECOND.millis * 60),
    HOUR(MINUTE.millis * 60),
    DAY(HOUR.millis * 24)
}