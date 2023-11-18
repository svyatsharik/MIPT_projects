import java.io.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Main {
  private static final Logger logger = Logger.getLogger(Main.class.getSimpleName());

  private static String cipherCaesar(String text, int shift) {
    logger.info("Запущен метод cipherCaesar");
    String ans = "";
    for (int i = 0; i < text.length(); i++) {
      char character = text.charAt(i);
      ans += (char) ((int) character + shift);
    }
    logger.info("Зашифрованный текст: " + ans);
    return ans;
  }

  private static void readerText(BufferedReader reader) throws IOException {
    logger.info("Запущен метод readerText");
    String line = reader.lines().collect(Collectors.joining(System.lineSeparator()));
    ;
    logger.info("Полученный из файла текст: " + line);
    writerText(cipherCaesar(line, 5));
  }

  private static void writerText(String text) throws IOException {
    logger.info("Запущен метод writerText");
    FileWriter writer = new FileWriter("new_test.txt", true);
    try {
      writer.write(text);
      logger.info("Новый файл с зашифрованным текстом создан успешно");
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      writer.close();
    }
  }

  private static void updateText() throws IOException {
    var reader = new BufferedReader(new FileReader("test.txt"));
    logger.info("Запущен метод updateText");
    try {
      readerText(reader);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      reader.close();
    }
  }

  public static void main(String[] args) throws IOException {
    logger.info("Программа запущена");
    updateText();
  }
}