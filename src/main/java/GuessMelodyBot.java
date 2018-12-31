import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Contact;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardButton;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.ArrayList;
import java.util.List;

public class GuessMelodyBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();
            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            if (message.equals("/start")) {
                sendMessage.setText("Привет это бот Угадай мелодию!");
                ReplyKeyboardMarkup replyKeyboardMarkup = new ReplyKeyboardMarkup();
                replyKeyboardMarkup.setSelective(true);
                replyKeyboardMarkup.setResizeKeyboard(true);
                replyKeyboardMarkup.setOneTimeKeyboard(false);

                List<KeyboardRow> keyboard = new ArrayList<>();

                KeyboardRow keyboardFirstRow = new KeyboardRow();
                keyboardFirstRow.add(new KeyboardButton("Ответить!!!"));
                keyboard.add(keyboardFirstRow);

                replyKeyboardMarkup.setKeyboard(keyboard);

                sendMessage.setReplyMarkup(replyKeyboardMarkup);
            } else if (message.equals("Ответить!!!")) {
                String targetText = "Готов ответить";
                sendMessage.setText(targetText);
            }

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    public String getBotUsername() {
        return "GuessMelodyBot";
    }

    public String getBotToken() {
        return "773196873:AAHQbMH-tlQPEd9uWqFEOuGa2q9hQh20wwc";
    }
}
