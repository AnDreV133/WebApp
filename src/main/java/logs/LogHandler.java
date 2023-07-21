package logs;


import java.io.IOException;
import java.util.logging.*;

public class LogHandler {

   // объект для хранения логгера
   static private final Logger LOGGER = Logger.getLogger(Logger.class.getName());

   // конструктор класса
   static {
      // создаем объект для хранения обработчика логов
      Handler handler;
      try {
         // создаем обработчик логов, который будет записывать в файл
         handler = new FileHandler("log.log");
         // устанавливаем формат записи лога
         handler.setFormatter(new SimpleFormatter());
         // добавляем обработчик к логгеру
         LOGGER.addHandler(handler);
      } catch (IOException e) {
         System.err.println("Error creating log file: " + e.getMessage());
      }
   }

   public void info(String message) {
      LOGGER.log(Level.INFO, message);
   }

   public void error(String msg, Exception e) {
      LOGGER.log(Level.SEVERE, msg, e);
   }
}