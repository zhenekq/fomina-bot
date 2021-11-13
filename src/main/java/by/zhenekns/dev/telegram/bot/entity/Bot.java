package by.zhenekns.dev.telegram.bot.entity;

import by.zhenekns.dev.telegram.bot.util.Database;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.*;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.request.BaseRequest;
import com.pengrad.telegrambot.request.SendAudio;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.request.SendVoice;

import javax.xml.crypto.Data;
import java.io.File;

public class Bot {

    private final TelegramBot bot = new TelegramBot(System.getenv("BOT_TOKEN"));

    private final String BEAUTIFUL_WORD = "/get_beautiful_word";
    private final String BEAUTIFUL_PHRASE = "/get_pleasant_phrase";
    private final String BEAUTIFUL_VOICE = "/get_husband_voice";

    public void serve() {
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::process);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private void process(Update update) {
        Message message = update.message();
        CallbackQuery callbackQuery = update.callbackQuery();
        InlineQuery inlineQuery = update.inlineQuery();
        BaseRequest request = null;

        if (message != null) {
            long chatId = message.chat().id();
            request = new SendMessage(chatId, "Hello!");
        }
        if (message.text().startsWith(BEAUTIFUL_WORD)) {
            long chatId = message.chat().id();
            request = new SendMessage(chatId, Database.getRandomMessageWithWords());
        }

        if(message.text().startsWith(BEAUTIFUL_PHRASE)){
            long chatId = message.chat().id();
            request = new SendMessage(chatId, Database.getRandomMessageWithProverbs());
        }
        if(message.text().startsWith(BEAUTIFUL_VOICE)){
            long chatId = message.chat().id();
            request = new SendVoice(chatId,"/voices/1.mp3");
        }

        if(request != null) {
            bot.execute(request);
        }
    }

}
