public class Cat {
  private String name;
  private int appetite;
  private volatile int satiety;

  public Cat(String name, int appetite, int satiety) {
    this.name = name;
    this.appetite = appetite;
    this.satiety = satiety;

    Thread backgroundSatietyManagement = new Thread(() -> {
      while (true) {
        if (this.isHungry() && this.satiety != 0) {
          this.satiety -= 1;
        }
        try {
          Thread.sleep(1000L);
        } catch (InterruptedException e) {
          throw new RuntimeException(e);
        }
      }
    });
    backgroundSatietyManagement.setDaemon(true);
    backgroundSatietyManagement.start();
  }

  public void eat(Plate plate) {
    if (this.isHungry()) {
      boolean hasFood = plate.decreaseFood(this.appetite - this.satiety);

      if (hasFood) {
        this.satiety += 1;
      }
    }
  }

  public void signal() {
    if (this.satiety == 0) {
      System.out.println("Мяу");
    } else {
      System.out.println("Муррр");
    }
  }

  public boolean isHungry() {
    return (this.appetite - this.satiety) > 0;
  }

  @Override
  public String toString() {
    return this.name + "{appetite=" + this.appetite + ", satiety=" + this.satiety + "}";
  }
}
