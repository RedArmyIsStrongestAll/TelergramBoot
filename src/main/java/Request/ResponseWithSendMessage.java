package Request;

import KeysForRequest.StartKeys;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;

public abstract class ResponseWithSendMessage implements  Response {
    @Override
    public abstract void go(TelegramLongPollingBot bot, Update update);
    @Override
    public abstract String name();

    protected StartKeys startKey = new StartKeys();

    protected SendMessage send(String chatId, String inputText) {
        SendMessage message = new org.telegram.telegrambots.meta.api.methods.send.SendMessage();
        message.setChatId(chatId);
        message.setText(inputText);
        startKey.setButton(message);
        return message;
    }
}
