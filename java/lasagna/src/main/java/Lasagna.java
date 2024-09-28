public class Lasagna {
    private static final int EXPECTED_MINUTES = 40;
    private static final int MINUTES_BY_LAYER = 2;

    public int expectedMinutesInOven() {
      return EXPECTED_MINUTES;
    }

   public int remainingMinutesInOven(final int passedMinutes) {
      return expectedMinutesInOven() - passedMinutes;
   }

   public int preparationTimeInMinutes(final int layers) {
      return layers * MINUTES_BY_LAYER;
   }

    public int totalTimeInMinutes(final int layers, final int passedMinutes) {
      return preparationTimeInMinutes(layers) + passedMinutes;
    }
}
