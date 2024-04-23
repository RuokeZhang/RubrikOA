import java.util.Scanner;

public class LexicographicallyGreatestStringFinder {

    // Your provided method with slight modifications to fit the context
    public static String optString(String str) {
        char[] chars = str.toCharArray();
        // If the first character is not 'z', swap it with 'z' and return
        if (chars[0] != 'z') {
            return swap(chars[0], 'z', str);
        }
        // Find the smallest character that is not properly placed
        char min = chars[0];
        int minIndex = 0;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1] || chars[i] == chars[i - 1] - 1) {
                min = chars[i];
                minIndex = i;
            } else if (chars[i] > chars[i - 1]) {
                if (chars[i - 1] != 'a') {
                    return swap(chars[i - 1], (char) (chars[i - 1] - 1), str);
                } else {
                    return swap(chars[i], chars[i - 1], str);
                }
            } else if (chars[i] < chars[i - 1]) {
                return swap(chars[i], (char) (chars[i - 1] - 1), str);
            }
        }
        // If the minimum character is not 'a', swap it with the character just before it in the alphabet
        if (min != 'a') {
            return swap(chars[minIndex], (char) (chars[minIndex] - 1), str);
        } else {
            return swap(chars[minIndex], chars[minIndex - 1], str);
        }
    }

    // Method to swap characters in the string
    public static String swap(char a, char b, String s) {
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == a) {
                chars[i] = b;
            } else if (chars[i] == b) {
                chars[i] = a;
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Read the number of strings
        int T = Integer.parseInt(scanner.nextLine());
        String[] results = new String[T];

        // Process each string
        for (int i = 0; i < T; i++) {
            String str = scanner.nextLine();
            results[i] = optString(str);
        }

        scanner.close();
        
        // Print all the results together
        for (String result : results) {
            System.out.println(result);
        }
    }
}
