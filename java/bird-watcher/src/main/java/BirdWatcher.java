import java.util.Arrays;

class BirdWatcher {
    private final int[] birdsPerDay;
    private final static int[] LAST_WEEK = new int[]{0, 2, 5, 3, 7, 8, 4};

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return LAST_WEEK;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        birdsPerDay[birdsPerDay.length - 1]++;
    }

    public boolean hasDayWithoutBirds() {
        return Arrays.stream(birdsPerDay)
            .anyMatch(i -> i == 0);
    }

    public int getCountForFirstDays(int numberOfDays) {
        int count = 0;
        if(numberOfDays > birdsPerDay.length - 1) return Arrays.stream(birdsPerDay).sum();
        for(int i = 0; i < numberOfDays; i++) count += birdsPerDay[i];
        return count;
    }

    public int getBusyDays() {
        return (int) Arrays.stream(birdsPerDay)
            .filter(i -> i >= 5)
            .count();
    }
}
