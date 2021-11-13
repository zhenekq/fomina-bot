package by.zhenekns.dev.telegram.bot;

import by.zhenekns.dev.telegram.bot.entity.Bot;
import by.zhenekns.dev.telegram.bot.util.Database;

import javax.xml.crypto.Data;
import java.util.Arrays;

public class Starter {
    public static void main(String[] args) {
        new Bot().serve();
    }
}
