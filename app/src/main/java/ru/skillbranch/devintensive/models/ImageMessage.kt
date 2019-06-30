package ru.skillbranch.devintensive.models

import ru.skillbranch.devintensive.extensions.humanizeDiff
import java.util.*

/**
 * Created by linuxshaman on 30,June,2019
 */

class ImageMessage(id: String, from: User?, chat: Chat, isIncoming: Boolean, date: Date, val image : String) :
    BaseMessage(id, from, chat, isIncoming, date)
{

    override fun formatMessage(): String {
        return "${from?.firstName} ${sendState()} изображение \"$image\", ${date.humanizeDiff()}"
    }


}