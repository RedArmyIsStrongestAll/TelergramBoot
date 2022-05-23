package KeysForRequest;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class WeatherSityKeys {
    public static SendMessage sendInlineKeyBoardMessage(String chatId) {
        InlineKeyboardMarkup inlineKeyboardMarkup = new InlineKeyboardMarkup();

        List<InlineKeyboardButton> keyboardButtonsRow1 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow2 = new ArrayList<>();
        List<InlineKeyboardButton> keyboardButtonsRow3 = new ArrayList<>();

        InlineKeyboardButton inlineKeyboardButton1 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton2 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton3 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton4 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton5 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton6 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton7 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton8 = new InlineKeyboardButton();
        InlineKeyboardButton inlineKeyboardButton9 = new InlineKeyboardButton();

        inlineKeyboardButton1.setText("Париж");
        inlineKeyboardButton1.setCallbackData("Paris");
        inlineKeyboardButton2.setText("Рим");
        inlineKeyboardButton2.setCallbackData("Rome");
        inlineKeyboardButton3.setText("Венеция");
        inlineKeyboardButton3.setCallbackData("Vence");
        inlineKeyboardButton4.setText("Рио-де-Жанейро");
        inlineKeyboardButton4.setCallbackData("Rio");
        inlineKeyboardButton5.setText("Стамбул");
        inlineKeyboardButton5.setCallbackData("Istanbul");
        inlineKeyboardButton6.setText("Нью-Йорк");
        inlineKeyboardButton6.setCallbackData("New-York");
        inlineKeyboardButton7.setText("Амстердам");
        inlineKeyboardButton7.setCallbackData("Amsterdam");
        inlineKeyboardButton8.setText("Прага");
        inlineKeyboardButton8.setCallbackData("Prague");
        inlineKeyboardButton9.setText("Ярик");
        inlineKeyboardButton9.setCallbackData("Yaroslav");

        keyboardButtonsRow1.add(inlineKeyboardButton1);
        keyboardButtonsRow1.add(inlineKeyboardButton2);
        keyboardButtonsRow1.add(inlineKeyboardButton3);
        keyboardButtonsRow2.add(inlineKeyboardButton4);
        keyboardButtonsRow2.add(inlineKeyboardButton5);
        keyboardButtonsRow2.add(inlineKeyboardButton6);
        keyboardButtonsRow3.add(inlineKeyboardButton7);
        keyboardButtonsRow3.add(inlineKeyboardButton8);
        keyboardButtonsRow3.add(inlineKeyboardButton9);

        List<List<InlineKeyboardButton>> rowList = new ArrayList<>();
        rowList.add(keyboardButtonsRow1);
        rowList.add(keyboardButtonsRow2);
        rowList.add(keyboardButtonsRow3);
        inlineKeyboardMarkup.setKeyboard(rowList);

        SendMessage message = new SendMessage();
        message.setChatId(chatId);
        message.setText("Города");
        message.setReplyMarkup(inlineKeyboardMarkup);
        return message;
    }
}
