import Request.ByeReqest;
import Request.Covid;
import Request.HelloRequest;
import Request.Response;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.CallbackQuery;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class MyBot extends TelegramLongPollingBot {
    @Override
    public String getBotUsername() {
        //return "ZxcRedArmyTest1_bot";
        return "Pp_Petrov_Berejnoi_bot";
        //return "Bot_For_4.0.0version";
    }

    @Override
    public String getBotToken() {
        {
            //return "5331252563:AAFdVRp7s3G4PWL_tgn4bD4NroYsL_o5sfU";
            return "5303595468:AAGjQuigtYLuzFWNpqmdof4APMELW0dorzQ";
            //return "5282059250:AAGxSRj2xqOYNREsHA8QRN1MjCLVGhxtUTI";
        }
    }


    @Override
    public void onUpdateReceived(Update update) {



        if (update.hasMessage()) {
            String request = update.getMessage().getText();
            for (int i = 0; i < responsesArray.length; ++i) {
                if (responsesArray[i].name().equals(request)) {
                    responsesArray[i].go(this, update);
                }
            }
        }
        if (update.hasCallbackQuery()){
            System.out.println("in main");

        }

        /*{
            System.out.println(update.hasCallbackQuery());
            System.out.println(update.hasMessage());


                InlineKeyboardMarkup inlainKeyboardMarkup = new InlineKeyboardMarkup();
                List<List<InlineKeyboardButton>> inlainMajorList = new ArrayList<>();
                List<InlineKeyboardButton> inlainLine1 = new ArrayList<>();
                InlineKeyboardButton inlainButton1 = new InlineKeyboardButton();
                inlainButton1.setText("Привет");
                inlainButton1.setCallbackData("Првиет");
                inlainLine1.add(inlainButton1);
                inlainMajorList.add(inlainLine1);
                inlainKeyboardMarkup.setKeyboard(inlainMajorList);

                if (update.hasCallbackQuery()) {
                    try {
                        System.out.println("hbjk");
                        CallbackQuery callbackQuery = update.getCallbackQuery();
                        String callbackQueryData = callbackQuery.getData();
                        Message ms2 = callbackQuery.getMessage();
                        System.out.println(callbackQueryData);
                        SendMessage message = new SendMessage();
                        message.setChatId(ms2.getChatId().toString());
                        message.setText("nnkl");
                        execute(message);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                } else
                if (update.hasMessage()) {
                    try {
                        SendMessage ms1 = new SendMessage();
                        ms1.setChatId(update.getMessage().getChatId().toString());
                        ms1.setReplyMarkup(inlainKeyboardMarkup);
                        ms1.setText("Привет");

                        execute(ms1);
                    } catch (TelegramApiException e) {
                        e.printStackTrace();
                    }
                }

        }*/


    }

    private Response[] responsesArray = new Response[]{
            new HelloRequest(),
            new ByeReqest(),
            new Covid()
    };
}
