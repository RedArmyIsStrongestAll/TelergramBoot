package Request;

import KeysForRequest.TimeKeys;
import KeysForRequest.WeatherSityKeys;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

public class Time extends ResponseWithSendMessage{
    @Override
    public void go(TelegramLongPollingBot bot, Update update) {
        String chatId = update.getMessage().getChatId().toString();
        TimeKeys tk = new TimeKeys();
        SendMessage message = tk.sendInlineKeyBoardMessage(chatId);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String name() {
        return "Время";
    }

    @Override
    public void goForCallbackQuery(TelegramLongPollingBot bot, Update update, String chatId, String data) {
        try {
            System.out.println(data);
            String result = Time.weather(data);
            System.out.println(data);
            bot.execute(createMessage(chatId, result));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    private static Document getPage(String ssilka) throws IOException {
        String url = ssilka;
        Document page = Jsoup.parse(new URL(url), 3000);
        return page;
    }

    public static String weather(String city) throws IOException {
        Document document = getPage("https://yandex.ru/search/?text=время+в+" + city);
        Element tempEl = document.select("a[class=link link_theme_black i-bem]").first();
        String weat = tempEl.select("a[class=link link_theme_black i-bem]").text();

        return weat;
    }
}
