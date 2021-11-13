package by.zhenekns.dev.telegram.bot.util;

public class Database {

    private static String[] niceWords = File.getFileStrings("NiceWords.txt", 412);
    private static String[] niceProverbs = File.getFileStrings("NiceProverbs.txt", 2);
    private static int listIndexWords = 0;
    private static int listIndexProverbs = 0;

    private static final String VOZNY_LOVE = "Обратись к Возному, видимо у меня закончились" + " приятные слова, пускай придумывает еще, раз он так сильно тебя любит))";


    public static String getRandomMessageWithProverbs() {
        if (listIndexProverbs <= niceProverbs.length - 1) {
            return niceProverbs[listIndexProverbs++];
        }
        return VOZNY_LOVE;
    }


    public static String getRandomMessageWithWords() {
        if (listIndexWords <= niceWords.length - 1) {
            return niceWords[listIndexWords++].toString();
        }
        return VOZNY_LOVE;
    }

}
