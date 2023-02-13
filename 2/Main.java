import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
  public static void main(String[] args) {
    System.out.println(isPalindrom("шалаш"));
    writeTest("TEST");
  }

  // 1. Создать метод, который проверяет, является ли строка палиндромом.
  // Палиндром - шалаш
  private static boolean isPalindrom(String source) {
    boolean sameChar = false;
    for (int i = 0; i < source.length() / 2 + source.length() % 2; i++) {
      sameChar = source.charAt(i) == source.charAt(source.length() - (i + 1));
      if(!sameChar) break;
    }

    return sameChar;
  }
  
  // 2. С помощью Java создать файл file.txt, и записать в него слово TEST 100 раз.
  // Если уже файл создан, то перезаписываем его.
  private static void writeTest(String word) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < 100; i++) {
      sb.append(word);
      if (i != 99) sb.append("\n");
    }
    Path test = Path.of("2", "test.txt");
    try {
      Files.createFile(test);
      Files.writeString(test, sb);
    } catch(IOException e) {
      System.out.println(e.getMessage());
    }
  }
}
