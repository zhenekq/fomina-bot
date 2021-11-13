package by.zhenekns.dev.telegram.bot.util;

public class Database {

    private static String[] niceWords = File.getFileStrings("NiceWords.txt", 412);
    private static String[] niceProverbs = File.getFileStrings("NiceProverbs.txt", 330);
    private static String[] animations = File.getFileStrings("NiceAnimations.txt", 10);
    private static int listIndexWords = 0;
    private static int listIndexProverbs = 0;
    private static int listIndexAnimations = 0;

    private static final String VOZNY_LOVE = "Обратись к Возному, видимо у меня закончились" + " приятные слова, пускай придумывает еще, раз он так сильно тебя любит))";


    public static String getRandomMessageWithProverbs() {
        System.out.println("INDEX RANDOM PROVERB: " + listIndexProverbs);
        if (listIndexProverbs <= niceProverbs.length - 1) {
            return niceProverbs[listIndexProverbs++];
        }
        return VOZNY_LOVE;
    }


    public static String getRandomMessageWithWords() {
        System.out.println("INDEX RANDOM WORD: " + listIndexWords);
        if (listIndexWords <= niceWords.length - 1) {
            return niceWords[listIndexWords++];
        }
        return VOZNY_LOVE;
    }

    public static String getRandomAnimations(){
        if (listIndexAnimations <= animations.length - 1) {
            return animations[listIndexAnimations++];
        }
        return VOZNY_LOVE;
    }
}
