package com.octo.funicular
import com.octo.funicular.service.RememberInMemoryService
import com.octo.funicular.util.DiscordUtil
import dev.kord.core.Kord
import dev.kord.core.entity.ReactionEmoji
import dev.kord.core.event.message.MessageCreateEvent
import dev.kord.core.on

suspend fun main() {
    val rememberService = RememberInMemoryService()
    val client = Kord(DiscordUtil.getBotToken())
    val pingPong = ReactionEmoji.Unicode("\uD83C\uDFD3")

    client.on<MessageCreateEvent> {
        if (message.content == "!ping") {
            val response = message.channel.createMessage("Pong!")
            response.addReaction(pingPong)
            return@on
        }

        if (message.content.startsWith("!remember")) {
            rememberService.store(message.content)
            return@on
        }

        if (message.content == "!list") {
            message.channel.createMessage(rememberService.list())
            return@on
        }
    }

    client.login()
}