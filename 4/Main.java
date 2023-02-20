import java.util.LinkedList;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    String str = "";
    LinkedList<String> my_list = new LinkedList<>();
    boolean check = false;

    while (!str.equals("exit")) {
      System.out.println("Введите значение или команду print~{цифра}/exit: ");
      str = sc.nextLine();
      if (str.startsWith("print")) {
        if (my_list.size() == 0) System.out.println("Список пуст");
        for (String item : my_list) {
          if (Integer.parseInt(item.split("~")[1]) == Integer.parseInt(str.split("~")[1])) {
            System.out.println(item.split("~")[0]);
            break;
          }
          if (my_list.indexOf(item) == my_list.size() - 1) {
            System.out.println("Под таким значением нет слова!");
            break;
          }
        }
        continue;
      } else if (!str.equals("exit")) {
        for (int i = 0; i < my_list.size(); i++) {
          if (Integer.parseInt(my_list.get(i).split("~")[1]) == Integer.parseInt(str.split("~")[1])) {
            check = true;
            my_list.add(i, str);
            my_list.remove(i + 1);
            System.out.println(my_list);
            System.out.println(my_list.size());
            break;
          }
        }
      }

      if (!check) {
        my_list.add(str);
      }
      check = false;
      continue;
    }
    sc.close();
  }
}