package KeysForRequest;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;

import java.util.ArrayList;
import java.util.List;

public class CovidCountry {
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

        inlineKeyboardButton1.setText("���");
        inlineKeyboardButton1.setCallbackData("ssha");
        inlineKeyboardButton2.setText("������");
        inlineKeyboardButton2.setCallbackData("rossiya");
        inlineKeyboardButton3.setText("��������");
        inlineKeyboardButton3.setCallbackData("germaniya");
        inlineKeyboardButton4.setText("�������");
        inlineKeyboardButton4.setCallbackData("vietnam");
        inlineKeyboardButton5.setText("������");
        inlineKeyboardButton5.setCallbackData("italiya");
        inlineKeyboardButton6.setText("�������");
        inlineKeyboardButton6.setCallbackData("taivan");
        inlineKeyboardButton7.setText("�������");
        inlineKeyboardButton7.setCallbackData("frantsiya");
        inlineKeyboardButton8.setText("����� (�����)");
        inlineKeyboardButton8.setCallbackData("yuzhnaya-koreya");
        inlineKeyboardButton9.setText("������");
        inlineKeyboardButton9.setCallbackData("polsha");

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
        message.setText("������");
        message.setReplyMarkup(inlineKeyboardMarkup);
        return message;
    }
}
