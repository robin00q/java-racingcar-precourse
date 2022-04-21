package racingcar.util;

public class StringUtils {

    private static final String EMPTY = "";
    public static final String SPACE = " ";
    public static final String DASH = "-";
    public static final String COLON = ":";

    private StringUtils() {
    }

    public static String removeSpace(String input) {
        return input.replaceAll(SPACE, EMPTY);
    }
}
