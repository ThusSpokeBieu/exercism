public class LogLevels {
    private static final int INDEX_AFTER_START = 1;
    private static final String PATTERN = "%s (%s)";

    public static String message(final String logLine) {
        final int start = logLine.indexOf(':') + INDEX_AFTER_START;

        return logLine.substring(start).trim();
    }

    public static String logLevel(final String logLine) {
        final int start = logLine.indexOf('[') + INDEX_AFTER_START;
        final int end = logLine.indexOf(']');

        return logLine.substring(start, end).toLowerCase();
    }

    public static String reformat(final String logLine) {
        final var message = message(logLine);
        final var logLevel = logLevel(logLine);

        return PATTERN.formatted(message, logLevel);
    }
}
