public class Plate {
  private int food;

  public Plate(int food) {
    this.food = food;
  }

  public boolean decreaseFood(int foodToDecrease) {
    if (this.food >= foodToDecrease) {
      this.food -= foodToDecrease;
      return true;
    }

    return false;
  }

  public void increaseFood(int countFood) {
    this.food += countFood;
  }

  @Override
  public String toString() {
    return "Plate[" + this.food + "]";
  }
}
