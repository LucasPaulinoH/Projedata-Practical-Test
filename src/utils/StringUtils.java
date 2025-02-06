package utils;

public class StringUtils {
    public static void printHeader(String title) {
        System.out.println(title.toUpperCase());

        for (int i = 0; i < title.length(); i++)
            System.out.print("=");

        System.out.println("\n");
    }
}
