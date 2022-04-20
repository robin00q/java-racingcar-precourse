package racingcar.util;

public class StringUtils {

    private static final String EMPTY = "";
    private static final String SPACE = " ";

    private StringUtils() {
    }

    public static String removeSpace(String input) {
        return input.replaceAll(SPACE, EMPTY);
    }
}
