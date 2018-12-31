import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class GuessMelodyBot extends TelegramLongPollingBot {

    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            SendMessage sendMessage = new SendMessage();
            sendMessage.setChatId(chatId);
            if (message.equals("/start"))
                sendMessage.setText("Привет это бот Угадай мелодию!");
            else
                sendMessage.setText(message);

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

//    @Override
//    public void onUpdateReceived(Update update) {
//        if (update.hasMessage() && update.getMessage().hasText()) {
//            String message = update.getMessage().getText();
//            Long chatId = update.getMessage().getChatId();
//
//            SendMessage sendMessage = new SendMessage();
//            sendMessage.setChatId(chatId);
//            sendMessage.setText(message);
//
//            try {
//                execute(sendMessage);
//            } catch (TelegramApiException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    @Override
//    public String getBotUsername() {
//        return "GuessMelodyBot";
//    }
//
//    @Override
//    public String getBotToken() {
//        return "773196873:AAHQbMH-tlQPEd9uWqFEOuGa2q9hQh20wwc";
//    }
}
