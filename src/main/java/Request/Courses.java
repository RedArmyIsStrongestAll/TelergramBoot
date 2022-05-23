package Request;

import KeysForRequest.CoursesKeys;
import KeysForRequest.CovidCountryKeys;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.URL;

public class Courses extends ResponseWithSendMessage{
    @Override
    public void go(TelegramLongPollingBot bot, Update update) {
        String chatId = update.getMessage().getChatId().toString();
        CoursesKeys ck = new CoursesKeys();
        SendMessage keysMessage = ck.sendInlineKeyBoardMessage(chatId);
        try {
            bot.execute(keysMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String name() {
        return "Курс";
    }

    @Override
    public void goForCallbackQuery(TelegramLongPollingBot bot, Update update, String chatId, String data) {
        try {
            String result = Courses.course(data);
            bot.execute(send(chatId, result));
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

    public static String course(String cur) throws IOException {
        Document document = getPage("https://ru.investing.com/currencies/" + cur + "-rub");
        Element course = document.select("div[class=instrument-price_instrument-price__3uw25 flex items-end flex-wrap font-bold]").first();
        String ourCourse = course.select("span[class=text-2xl]").text();
        return ourCourse;
    }
}
