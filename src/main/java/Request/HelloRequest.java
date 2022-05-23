package Request;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class HelloRequest extends ResponseWithSendMessage {
        @Override
        public void go(TelegramLongPollingBot bot, Update update){
                String chatId = update.getMessage().getChatId().toString();
                try {
                        bot.execute(send(chatId, "Привет, " + update.getMessage().getFrom().getFirstName()));
                } catch (TelegramApiException e) {
                        e.printStackTrace();
                }
        }
        @Override
        public String name() {
                return "Привет";
        }

        @Override
        public void goForCallbackQuery(TelegramLongPollingBot bot, Update update, String chatId, String data) {

        }
}
