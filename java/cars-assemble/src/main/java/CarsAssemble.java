public class CarsAssemble {

    private static final double SPEED_BASE = 221;

    public double productionRatePerHour(int speed) {
        return switch (speed) {
            case 5, 6, 7, 8 -> 0.90 * speed * SPEED_BASE;
            case 9 -> 0.80 * speed * SPEED_BASE;
            case 10 -> 0.77 * speed * SPEED_BASE;
            default -> 1.0 * speed * SPEED_BASE;
        };
    }

    public int workingItemsPerMinute(int speed) {
        return (int) (productionRatePerHour(speed) / 60);
    }
}
