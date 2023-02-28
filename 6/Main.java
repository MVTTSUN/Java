public class Main {
  public static void main(String[] args) throws InterruptedException {
    // Кот (имя, аппетит, сытность)
    // Тарелка (содержит какое-то количество еды)
    // Кот ест из тарелки. Если в тарелке недостаточно еды - кот ее не трогает

    // ДЗ:
    // while (true) -> while (!plate.isEmpty())
    // 1. Создать массив котов. Пусть все коты из массива по очереди едят из одной тарелки.
    // В конце каждого цикла мы досыпаем в тарелку еду.
    // Для добавления еды сделать метод increaseFood в классе Plate.
    // 2. Поменять поле satiety у кота с boolean на int.
    // Допустим у кота аппетит 10, сытость 3. Значит кот захочет поесть 7 единиц.
    // 3. * Доработать поток thread в классе Cat, чтобы он каждую секунду уменьшал сытость кота на 1.

    Cat[] arrCat = new Cat[3];
    arrCat[0] = new Cat("Murzik", 15, 10);
    arrCat[1] = new Cat("Keks", 5, 3);
    arrCat[2] = new Cat("Dymok", 8, 5);

    Plate plate = new Plate(80);

    while (true) {
      for (int i = 0; i < arrCat.length; i++) {
        if (arrCat[i].isHungry()) {
          arrCat[i].eat(plate);
        }
        System.out.println(plate);
        System.out.println(arrCat[i]);
        arrCat[i].signal();
      }

      plate.increaseFood(5);

      Thread.sleep(1000);
    }
  }
}