import org.example.Main;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CaesarTest {
  @Test
  void testCipherCaesar1() {
    String text = "Это тестирование шифра Цезаря!";
    int shift = 5;
    String result = "вчу%чкцчнхузетнк%энщхе%Ыкмехє&";
    assertEquals(Main.cipherCaesar(text, shift), result);
  }

  @Test
  void testCipherCaesar2() {
    String text = "Это тоже тестирование шифра Цезаря! @#$%^&*()";
    int shift = 10;
    String result = "зьш*ьшрп*ьпыьтъшмкчтп*ђтюък*апскъљ+*J-./h0423";
    assertEquals(Main.cipherCaesar(text, shift), result);
  }

  @Test
  void testCipherCaesar3() {
    String text = "иЭтоТестированиеШифраЦезаря1234567890";
    int shift = -5;
    String result = "гШнйНамнглйЭЫигаУгплЫСавЫлъ,-./01234+";
    assertEquals(Main.cipherCaesar(text, shift), result);
  }

  @Test
  void testCipherCaesar4() {
    String text = "Это ещё одно тестирование шифра Цезаря!";
    int shift = 0;
    String result = "Это ещё одно тестирование шифра Цезаря!";
    assertEquals(Main.cipherCaesar(text, shift), result);
  }
}
