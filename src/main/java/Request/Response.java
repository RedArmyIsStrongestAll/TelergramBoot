package Request;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public interface Response {
    public void go (TelegramLongPollingBot bot, Update update);
    public String name();
    public void goForCallbackQuery(TelegramLongPollingBot bot, Update update, String chatId, String data);
}
