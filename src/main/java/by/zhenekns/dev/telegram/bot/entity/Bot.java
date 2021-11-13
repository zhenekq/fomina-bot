package by.zhenekns.dev.telegram.bot.entity;

import by.zhenekns.dev.telegram.bot.util.Database;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.Message;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.KeyboardButton;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.*;

import javax.xml.crypto.Data;
import java.io.File;
import java.util.Locale;
import java.util.TimerTask;

public class Bot extends TimerTask {

    private final TelegramBot bot = new TelegramBot(System.getenv("BOT_TOKEN"));

    private final String BEAUTIFUL_WORD = "/get_beautiful_word";
    private final String BEAUTIFUL_PHRASE = "/get_pleasant_phrase";
    private final String BEAUTIFUL_VOICE = "/get_husband_voice";
    private final String GIF = "/get_gif";
    private final String START = "/start";

    public void serve() {
        bot.setUpdatesListener(updates -> {
            updates.forEach(this::process);
            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });
    }

    private void process(Update update) {
        Message message = update.message();
        BaseRequest request = null;
        long chatId = message.chat().id();
        if (message.text().startsWith(BEAUTIFUL_WORD)) {
            request = new SendMessage(chatId, Database.getRandomMessageWithWords());
        } else if (message.text().startsWith(BEAUTIFUL_PHRASE)) {
            request = new SendMessage(chatId, Database.getRandomMessageWithProverbs());
        } else if (message.text().startsWith(BEAUTIFUL_VOICE)) {
            request = new SendVoice(chatId, new File("voices/2.mp3"));
        } else if(message.text().startsWith(GIF)){
            String path = Database.getRandomAnimations();
            if(path.contains(".jpg")){
                request = new SendPhoto(chatId, new File(path));
            }
            else if(path.contains(".gif")){
                request = new SendAnimation(chatId, new File(path));
            }else{
                request = new SendMessage(chatId, "Ээээ нееет, тебе малышка, разрешено только читать приятные словечки и фразочки, а не писать сюда всякое, говорю тут я \uD83D\uDC3C ");
            }
        }else if (message.text().startsWith(START)) {
            request = new SendMessage(chatId, "Знай, я очень сильно тебя люблю, малыш\uD83D\uDC23 \n"
                                      +"/get_beautiful_word - Приятное слово для моей девочки\uD83E\uDD70\n"+
                                      "/get_pleasant_phrase - Приятную фразочку для моей кошечки❤\n" +
                                      "/get_husband_voice - Услышать мужа\uD83D\uDC68\uD83C\uDFFD\u200D\uD83D\uDCBB\n"+
                                      "/get_gif - любовное послание от тайного поклонника\uD83E\uDD77\uD83C\uDFFD");
        } else if(message.text().toUpperCase(Locale.ROOT).contains("ху")){
            request = new SendMessage(chatId, "Ты думаешь я тебя настолько плохо знаю, что не смог предугадать что ты напишешь сюда ХУЙ??? Челл, я гений\uD83D\uDC68\uD83C\uDFFD\u200D\uD83D\uDCBB\uD83D\uDC68\uD83C\uDFFD\u200D\uD83D\uDCBB\uD83D\uDC68\uD83C\uDFFD\u200D\uD83D\uDCBB");
        }else {
            request = new SendMessage(chatId, "Ээээ нееет, тебе малышка, разрешено только читать приятные словечки и фразочки, а не писать сюда всякое, говорю тут я \uD83D\uDC3C ");
        }
        bot.execute(request);
    }

    private static long getTime() {
        return 5000;
    }

    @Override
    public void run() {

    }
}
