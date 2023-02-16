import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Main {
  public static void main(String[] args) {
    deleteEvenNumbers(createRandomList(20));
    findMinAndMaxAndAverage(createRandomList(20));
  }

  public static ArrayList<Integer> createRandomList(int lengthList) {
    ArrayList<Integer> randomList = new ArrayList<>(lengthList);
    Random randomNumber = new Random();

    for (int i = 0; i < lengthList; i++) {
      randomList.add(randomNumber.nextInt(10));
    }

    System.out.printf("Исходный список: %s\n", randomList);

    return randomList;
  }

  // 1. Пусть дан произвольный список целых чисел, удалить из него четные числа (в языке уже есть что-то готовое для этого)
  public static void deleteEvenNumbers(ArrayList<Integer> array) {
    for (int i = 0; i < array.size(); i++) {
      if (array.get(i) % 2 == 0) {
        array.remove(i);
      }
    }

    System.out.printf("Массив без четных чисел: %s\n", array);
  }

  // 2. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее арифметическое из этого списка.
  public static void findMinAndMaxAndAverage(ArrayList<Integer> array) {
    int min = Collections.min(array);
    int max = Collections.max(array);
    float sum = 0;
    float count = 0;

    for (int i = 0; i < array.size(); i++) {
      sum += array.get(i);
      count++;
    }

    float average = sum / count;

    System.out.printf("Минимум = %d, максимум = %d, среднее арифметическое = %.2f\n", min, max, average);
  }
}
