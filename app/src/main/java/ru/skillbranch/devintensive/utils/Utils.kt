package ru.skillbranch.devintensive.utils

/**
 * Created by linuxshaman on 30,June,2019
 */

object Utils {

    fun parseFullName(fullName : String?) : Pair<String?, String?> {
        return when (fullName) {
            null -> return Pair(null, null)
            else -> run {
                val parts = fullName.split(" ")

                val firstName = parts.getOrNull(0)
                val lastName = parts.getOrNull(1)

                Pair(
                    returnIfNotEmpty(firstName),
                    returnIfNotEmpty(lastName)
                )
            }
        }
    }

    private fun returnIfNotEmpty(str : String?) : String?{
        return if(str.isNullOrEmpty()) null else str
    }

    fun toInitials(firstName : String?, lastName : String?) : String? {
        val first = toInitial(firstName)
        val last = toInitial(lastName)

        if(first.isNullOrEmpty() && last.isNullOrEmpty()) return null
        if(first.isNullOrEmpty()) return last
        if(last.isNullOrEmpty()) return first
        return "$first$last"

    }

    private fun toInitial(str : String?) : String? {
        if(str.isNullOrEmpty()) return null
        val trimmed = str.trim()
        if(trimmed.isEmpty()) return null
        return trimmed.substring(0, 1).toUpperCase()
    }



    fun transliteration(payload : String, divider : String = " ") : String {
        var result = payload.replace(" ", divider)
        lowerCaseTranslations.forEach { entry ->
            result = result.replace(entry.key, entry.value)
        }
        upperCaseTranslations.forEach { entry ->
            result = result.replace(entry.key, entry.value)
        }
        return result
    }


    private val lowerCaseTranslations = mapOf(
        "а" to "a",
        "б" to "b",
        "в" to "v",
        "г" to "g",
        "д" to "d",
        "е" to "e",
        "ё" to "e",
        "ж" to "zh",
        "з" to "z",
        "и" to "i",
        "й" to "i",
        "к" to "k",
        "л" to "l",
        "м" to "m",
        "н" to "n",
        "о" to "o",
        "п" to "p",
        "р" to "r",
        "с" to "s",
        "т" to "t",
        "у" to "u",
        "ф" to "f",
        "х" to "h",
        "ц" to "c",
        "ч" to "ch",
        "ш" to "sh",
        "щ" to "sh'",
        "ъ" to "",
        "ы" to "i",
        "ь" to "",
        "э" to "e",
        "ю" to "yu",
        "я" to "ya"
    )

    private val upperCaseTranslations = hashMapOf<String, String>().apply {
        lowerCaseTranslations.forEach { entry ->
            put(entry.key.toUpperCase(), entry.value.toUpperCase())
        }
    }


}