package Request;

import Request.KeysForRequest.RateKeys;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.IOException;
import java.net.URL;

public class Covid extends ResponseWithSendMessage{
    @Override
    public void go(TelegramLongPollingBot bot, Update update) {
        String chatId = update.getMessage().getChatId().toString();
        try {
            RateKeys rk = new RateKeys();
            bot.execute(rk.sendInlineKeyBoardMessage(chatId, update));
            String reqest2 = update.getCallbackQuery().toString();
            Response[] responsesArray= new Response[]{
                    new HelloRequest(),
                    new ByeReqest(),
                    new Covid()
            };;
            for(int i = 0; i < responsesArray.length; ++i ){
                if (responsesArray[i].name().equals(reqest2)){
                    responsesArray[i].go(bot, update);
                }
            };
            /*switch (chatId) {
                case "США" -> bot.execute(send(chatId,  covid("ssha")));
                case "России" -> bot.execute(send(chatId,  covid("rossiya")));
                case "Германии" -> bot.execute(send(chatId,  covid("germaniya")));
                case "Вьетнаме" -> bot.execute(send(chatId,  covid("vietnam")));
                case "Италии" -> bot.execute(send(chatId,  covid("italiya")));
                case "Тайвани" -> bot.execute(send(chatId,  covid("taivan")));
                case "Франции" -> bot.execute(send(chatId,  covid("frantsiya")));
                case "Южной Корее" -> bot.execute(send(chatId,  covid("yuzhnaya-koreya")));
                case "Польше" -> bot.execute(send(chatId,  covid("polsha")));
            }*/
        } catch (TelegramApiException e) {
            e.printStackTrace();
        } /*catch (IOException e) {
            e.printStackTrace();
        }*/
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
