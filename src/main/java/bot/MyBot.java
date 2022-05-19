package bot;

import Request.ByeReqest;
import Request.Covid;
import Request.HelloRequest;
import Request.Response;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        return "ZxcRedArmyTest1_bot";
    }

    @Override
    public String getBotToken() {
        {
            return "5331252563:AAFdVRp7s3G4PWL_tgn4bD4NroYsL_o5sfU";
        }
    }

   
    @Override
    public void onUpdateReceived(Update update) {
        String request = update.getMessage().getText();
        for(int i = 0; i < responsesArray.length; ++i ){
                if (responsesArray[i].name().equals(request)){
                    responsesArray[i].go(this, update);
                }
        }
    }
    private  Response[] responsesArray = new Response[]{
            new HelloRequest(),
            new ByeReqest(),
            new Covid()
    };
}
