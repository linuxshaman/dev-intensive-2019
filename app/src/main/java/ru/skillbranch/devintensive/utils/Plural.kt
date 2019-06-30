package ru.skillbranch.devintensive.utils

import kotlin.math.abs

/**
 * Created by linuxshaman on 30,June,2019
 */

class Plural(
    private val zero : String,
    private val one : String,
    private val few : String,
    private val many : String
)
{
    fun pluralString(number : Long) : String {
        if(number == 0L) return zero
        val n = abs(number) % 100
        val n10 = n % 10

        val pluralForm = when{
            n in 11..19 -> many
            n10 in 2..4 -> few
            n10 == 1L -> one
            else -> many
        }
        return "$number $pluralForm"
    }


}