import Request.ByeReqest;
import Request.Covid;
import Request.HelloRequest;
import Request.Registry.ResponseRegistry;
import Request.Response;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        //return "ZxcRedArmyTest1_bot";
        return "Pp_Petrov_Berejnoi_bot";
    }

    @Override
    public String getBotToken() {
        {
            //return "5331252563:AAFdVRp7s3G4PWL_tgn4bD4NroYsL_o5sfU";
            return "5303595468:AAGjQuigtYLuzFWNpqmdof4APMELW0dorzQ";
        }
    }

    final ResponseRegistry responseRegistry = new ResponseRegistry();
    @Override
    public void onUpdateReceived(Update update) {

        if (update.hasMessage()) {
            String request = update.getMessage().getText();
            for (int i = 0; i < responseRegistry.getSizeListResponse(); ++i) {
                if (responseRegistry.getResponseName(i).equals(request)) {
                    Response response = responseRegistry.getResponse(i);
                    response.go(this, update);
                    responseRegistry.setNumberResponseForCallbackQuery(i);
                }
            }
        }
        if (update.hasCallbackQuery()){
            CallbackQuery callbackQuery = update.getCallbackQuery();
            String callbackQueryData = callbackQuery.getData();
            Message ms = callbackQuery.getMessage();
            String chatId = ms.getChatId().toString();

            int numberResponse = responseRegistry.getNumberResponseForCallbackQuery();
            Response response = responseRegistry.getResponse(numberResponse);
            responseRegistry.getResponse(numberResponse).goForCallbackQuery(this, update, chatId,callbackQueryData);
        }
    }
}
