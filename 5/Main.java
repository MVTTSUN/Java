import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class Main {
  public static void main(String[] args) {
    System.out.println(isCorrectParentheses("[]{}((<>))"));
  }

  /*
  * Написать метод, определяющую правильность расстановки скобок в выражении.
  * Могут содержаться следующие скобки: ()[]{}<>
  * () -> true
  * []{}((<>)) -> true
  * ) -> false
  * [) -> false
  * []{}(<)> -> false
  */
  private static boolean isCorrectParentheses(String parentheses) {
    Map<Character,Character> dict = new HashMap<Character,Character>();
    dict.put(')', '(');
    dict.put('}', '{');
    dict.put(']', '[');
    dict.put('>', '<');

    ArrayDeque<Character> stack = new ArrayDeque<>();
    
    for (int i = 0; i < parentheses.length(); i++) {
      if (dict.values().contains(parentheses.charAt(i))) {
        stack.addFirst(parentheses.charAt(i));
      }
      try {
        if (dict.keySet().contains(parentheses.charAt(i)) && stack.getFirst() == dict.get(parentheses.charAt(i))) {
          stack.removeFirst();
        }
      } catch (NoSuchElementException e) {
        return false;
      }
    }

    return stack.size() > 0 ? false : true;
  }
}
