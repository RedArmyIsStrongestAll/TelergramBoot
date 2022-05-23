package Request;

import KeysForRequest.CovidCountryKeys;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.io.IOException;
import java.net.URL;

public class Covid extends ResponseWithSendMessage{
    @Override
    public void go(TelegramLongPollingBot bot, Update update) {
        String chatId = update.getMessage().getChatId().toString();
        CovidCountryKeys rk = new CovidCountryKeys();
        SendMessage keysMessage = rk.sendInlineKeyBoardMessage(chatId);
        try {
            bot.execute(keysMessage);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void goForCallbackQuery(TelegramLongPollingBot bot, Update update, String chatId, String data) {
        try {
            String result = Covid.covid(data);
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
    private static String covid(String place) throws IOException {
        Document document = getPage("https://coronavirus-graph.ru/" + place);
        Element tem = document.select("div[class=x x_cases]").first();
        String res = "Всего случаев заражения: " + tem.select("b").text() + "( " + document.select("div[class=x x_cases]").first().select("span").text() + " за день)\nУмерло: " + document.select("div[class=x x_deaths]").first().select("b").text() + " (" + document.select("div[class=x x_deaths]").first().select("span").text() + ")\nНа данный момент болеет: " + document.select("div[class=x x_active]").first().select("b").text() + "\n\n Данные взяты с сайта coronavirus-graph.ru";
        return res;
    }

    @Override
    public String name() {
        return "Коронавирус";
    }


}
