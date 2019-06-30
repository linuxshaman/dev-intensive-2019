package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

/**
 * Created by linuxshaman on 30,June,2019
 */

class TextMessage(id: String, from: User?, chat: Chat, isIncoming: Boolean, date: Date, val text : String) :
    BaseMessage(id, from, chat, isIncoming, date)
{

    override fun formatMessage(): String {
        return "${from?.firstName} ${sendState()} соообщение \"$text\", ${date.humanizeDiff()}"
    }


}