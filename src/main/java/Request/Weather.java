package Request;

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

public class Weather extends ResponseWithSendMessage{
    @Override
    public void go(TelegramLongPollingBot bot, Update update) {
        String chatId = update.getMessage().getChatId().toString();
        WeatherSityKeys wk = new WeatherSityKeys();
        SendMessage message = wk.sendInlineKeyBoardMessage(chatId);
        try {
            bot.execute(message);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String name() {
        return "Погода";
    }

    @Override
    public void goForCallbackQuery(TelegramLongPollingBot bot, Update update, String chatId, String data) {
        try {
            System.out.println(data);
            String result = Weather.weather(data);
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
        Document document = getPage("https://yandex.ru/search/?text=погода+в+" + city);
        Element tempEl = document.select("div[class=weather-forecast__current]").first();
        String[] a =  tempEl.select("div[class=weather-forecast__current-details]").text().split(" ");
        String[] wind =  tempEl.select("div[class=weather-forecast__desc-value]").text().split(" ");
        String weat = a[0] + "\n" + tempEl.select("div[class=weather-forecast__current-temp]").text() + "\n Ветер " + wind[0] + wind[1];

        return weat;
    }
}
