package by.zhenekns.dev.telegram.bot.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class File {

    private File(){}

    public static String[] getFileStrings(String filename, int fileSize){
        String[] words = new String[fileSize];
        int index = 0;
        try {
            java.io.File file = new java.io.File(filename);
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                words[index++] = line;
                line = reader.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return words;
    }

}
