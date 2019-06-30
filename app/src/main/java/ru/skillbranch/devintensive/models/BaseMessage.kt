package ru.skillbranch.devintensive.models

import java.util.*

/**
 * Created by linuxshaman on 30,June,2019
 */

const val MESSAGE_TYPE_TEXT = "text"
const val MESSAGE_TYPE_IMAGE = "image"

abstract class BaseMessage(
    val id: String,
    val from: User?,
    val chat: Chat,
    val isIncoming: Boolean = false,
    val date: Date = Date()
)

{
    protected fun sendState() : String = if(isIncoming) "получил" else "отправил"
    abstract fun formatMessage() : String

    companion object AbstractFactory {
        var messageId : Int = 0

        fun makeMessage(
            from : User?,
            chat : Chat,
            date : Date,
            type : String,
            payload : String,
            isIncoming : Boolean = false
        ) : BaseMessage {
            return when(type){
                MESSAGE_TYPE_TEXT -> TextMessage(messageId.toString(), from, chat, isIncoming, date, payload)
                else -> ImageMessage(messageId.toString(), from, chat, isIncoming, date, payload)
            }.also {
                messageId ++
            }
        }
    }
}