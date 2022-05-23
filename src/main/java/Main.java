


import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

public class Main {
    public static void main(String[] args) throws TelegramApiException {
        try {
            TelegramBotsApi botsApi =
                    new TelegramBotsApi(
                            DefaultBotSession.class);
            botsApi.registerBot(new MyBot());
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }

        /*ApiContextInitializer.init();
        TelegramBotsApi telegramBotsApi = new TelegramBotsApi();
        try {
            telegramBotsApi.registerBot(new MyBot());
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }*/

    }
}

