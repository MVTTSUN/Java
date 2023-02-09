import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;

public class Main {
  public static void main(String[] args) {
    System.out.println(isSumBetween10And20(5, 15)); // true
    System.out.println(isSumBetween10And20(7, 15)); // false

    System.out.println(isPositive(5));

    printString("abcd", 5); // abcdabcdabcdabcdabcd
    System.out.println(isLeapYear(2024));
    System.out.println(createArray(5, 13));

    String[] stringArray = {"aaa", "aab", "aa"};
    System.out.println(findCommonPrefix(stringArray)); // aa
    String[] stringArray2 = {"abc", "bca", "cda"};
    System.out.println(findCommonPrefix(stringArray2)); // ""

    int[] arrayNoReverse = new int[] { 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 };
    System.out.println(reverseArrayNumber(arrayNoReverse));

    int[] arrayLowerSix = new int[] { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 };
    System.out.println(isLowerSix(arrayLowerSix));

    int[][] arrayInMatrix = new int[5][5]; // [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, x], [0, 0, 0, 1]]
    xInMatrix(arrayInMatrix);

    int[] arrayFind = new int[20];
    Random r = new Random();
    IntStream.range(0, 20)
      .forEach(i -> arrayFind[i] = r.nextInt(20));
    System.out.println(Arrays.toString(arrayFind));
    findMinAndMax(arrayFind);
  }

  /**
  * 1. Написать метод, принимающий на вход два целых числа и проверяющий,
  * что их сумма лежит в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.
  */
  private static boolean isSumBetween10And20(int a, int b) {
    // проверить, что сумма a и b лежит между 10 и 20
    return a + b >= 10 && a + b <= 20;
  }

  private static boolean isPositive(int x) {
    // проверить, что х положительное
    return x >= 0;
  }

  private static void printString(String source, int repeat) {
    // напечатать строку source repeat раз
    String result = "";
    for (int i = 0; i < repeat; i++) {
      result += source;
    }
    System.out.println(result);
  }

  private static boolean isLeapYear(int year) {
    // проверить, является ли год високосным. если да - return true
    return year % 4 == 0;
  }

  private static String createArray(int len, int initialValue) {
    int[] array = new int[len];
    for (int i = 0; i < array.length; i++) {
      array[i] = initialValue;
    }
    // должен вернуть массив длины len, каждое значение которого равно initialValue
    return Arrays.toString(array);
  }

  private static String findCommonPrefix(String[] source) {
    /** Найти общий префикс среди слов из одного массива.
     * ["aaa", "aab", "aa"] -> "aa", ["abc", "bca", "cda"] -> ""
     */
    String result = "";
    int minString = source[0].length();

    for (String str : source) {
      if (str.length() < minString) minString = str.length();
    }

    for (int i = 0; i < minString; i++) {
      for (int j = 0; j < source.length - 1; j++) {
        if (source[j].charAt(i) == source[j + 1].charAt(i) && j + 1 == source.length - 1) {
          result += source[j].charAt(i);
        } else if (source[j].charAt(i) != source[j + 1].charAt(i)) {
          break;
        }
      } 
    }
    return result;
  }

  // 1. Задать целочисленный массив, состоящий из элементов 0 и 1.
  // Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. С помощью цикла и условия заменить 0 на 1, 1 на 0;
  private static String reverseArrayNumber(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 0) {
        array[i] = 1;
      } else if (array[i] == 1) {
        array[i] = 0;
      }
    }
    return Arrays.toString(array);
  }

  // 2. Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ] пройти по нему циклом, и числа меньшие 6 умножить на 2;
  private static String isLowerSix(int[] array) {
    for (int i = 0; i < array.length; i++) {
      if (array[i] < 6) {
        array[i] *= 2;
      }
    }
    return Arrays.toString(array);
  }

  // 3. Создать квадратный двумерный целочисленный массив (количество строк и столбцов одинаковое),
  // и с помощью цикла(-ов) заполнить его диагональные элементы единицами (можно только одну из диагоналей, если обе сложно). 
  // Определить элементы одной из диагоналей можно по следующему принципу: индексы таких элементов равны, то есть [0][0], [1][1], [2][2], …, [n][n];
  private static void xInMatrix(int[][] array) {
    int start = 0;
    int end = array.length - 1;

    for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
        if (j == start || j == end) {
          array[i][j] = 1;
        }
				System.out.print(array[i][j]);
			}
			System.out.println();
      start++;
      end--;
		}
  }
  
  // 4. Задать одномерный массив и найти в нем минимальный и максимальный элементы ;
  private static void findMinAndMax(int[] array) {
    int min = array[0];
    int max = array[0];

    for (int i = 1; i < array.length; i++) {
      if (array[i] < min) min = array[i];
      if (array[i] > max) max = array[i];
    }
    System.out.printf("min = %d, max = %d", min, max);
  }
}