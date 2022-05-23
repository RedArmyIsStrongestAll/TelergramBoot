package KeysForRequest;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class StartKeys {
    public static void setButton(SendMessage sendMassage){
        ReplyKeyboardMarkup replykeyboardmarkup = new ReplyKeyboardMarkup(); //создание клавы самой по себе
        sendMassage.setReplyMarkup(replykeyboardmarkup); //установка кнопок
        replykeyboardmarkup.setSelective(true); // клавиатура видна всем а не конкретному пользователю
        replykeyboardmarkup.setResizeKeyboard(true);// диномическая настройка размера
        replykeyboardmarkup.setOneTimeKeyboard(false); //клава остаётся после нажатия

        List<KeyboardRow> keyRaw = new ArrayList<>();

        KeyboardRow keyFirstRow1 = new KeyboardRow();
        keyFirstRow1.add(new KeyboardButton("Привет"));
        keyFirstRow1.add(new KeyboardButton("Пока"));
        keyRaw.add(keyFirstRow1);
        KeyboardRow keyFirstRow2 = new KeyboardRow();
        keyFirstRow2.add(new KeyboardButton("Коронавирус"));
        keyFirstRow2.add(new KeyboardButton("Курс"));
        keyRaw.add(keyFirstRow2);
        KeyboardRow keyFirstRow3 = new KeyboardRow();
        keyFirstRow3.add(new KeyboardButton("Погода"));
        keyFirstRow3.add(new KeyboardButton("Время"));
        keyRaw.add(keyFirstRow3);

        replykeyboardmarkup.setKeyboard(keyRaw);
    }
}
