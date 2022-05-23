package KeysForRequest;

import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;

import java.util.ArrayList;
import java.util.List;

public class StartKeys {
    public static void setButton(SendMessage sendMassage){
        ReplyKeyboardMarkup replykeyboardmarkup = new ReplyKeyboardMarkup(); //�������� ����� ����� �� ����
        sendMassage.setReplyMarkup(replykeyboardmarkup); //��������� ������
        replykeyboardmarkup.setSelective(true); // ���������� ����� ���� � �� ����������� ������������
        replykeyboardmarkup.setResizeKeyboard(true);// ������������ ��������� �������
        replykeyboardmarkup.setOneTimeKeyboard(false); //����� ������� ����� �������

        List<KeyboardRow> keyRaw = new ArrayList<>();

        KeyboardRow keyFirstRow1 = new KeyboardRow();
        keyFirstRow1.add(new KeyboardButton("������"));
        keyFirstRow1.add(new KeyboardButton("����"));
        keyRaw.add(keyFirstRow1);
        KeyboardRow keyFirstRow2 = new KeyboardRow();
        keyFirstRow2.add(new KeyboardButton("�����������"));
        keyFirstRow2.add(new KeyboardButton("����"));
        keyRaw.add(keyFirstRow2);
        KeyboardRow keyFirstRow3 = new KeyboardRow();
        keyFirstRow3.add(new KeyboardButton("������"));
        keyFirstRow3.add(new KeyboardButton("�����"));
        keyRaw.add(keyFirstRow3);

        replykeyboardmarkup.setKeyboard(keyRaw);
    }
}
