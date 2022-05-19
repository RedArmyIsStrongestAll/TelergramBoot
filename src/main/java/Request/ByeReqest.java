package Request;

import Request.KeysForRequest.RateKeys;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class ByeReqest extends ResponseWithSendMessage {
    @Override
    public void go(TelegramLongPollingBot bot, Update update) {
        String chatId = update.getMessage().getChatId().toString();
        try {
            bot.execute(send(chatId, "Хули, пока то сразу, " + update.getMessage().getFrom().getFirstName() + ", а?"));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
    @Override
    public String name() {
        return "Пока";
    }
}
