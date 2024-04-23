import java.util.Scanner;
import java.util.TreeMap;

public class MeanArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read N and K
        int N = scanner.nextInt();
        int K = scanner.nextInt();
        scanner.nextLine(); // To consume the newline character

        // Initialize an array to store the numbers
        int[] expansionNumbers = new int[N];
        
        // Read each number into the array
        for (int i = 0; i < N; i++) {
            expansionNumbers[i] = scanner.nextInt();
            if (i < N - 1) {
                scanner.nextLine(); // To consume the newline character
            }
        }

        // Close the scanner
        scanner.close();

        // Calculate the number of valid subsequences using the BIT method
        int count = countSubsequences(N, K, expansionNumbers);
        System.out.println(count);
    }

    public static int countSubsequences(int N, int K, int[] expansionNumbers) {
        long[] modifiedArray = new long[N + 1];
        for (int i = 0; i < N; i++) {
            modifiedArray[i + 1] = modifiedArray[i] + expansionNumbers[i];
        }
        //substract K from all elements
        for (int i = 0; i < N; i++) {
            modifiedArray[i] -= K;
        }

        TreeMap<Long, Integer> prefixSumCount = new TreeMap<>();
        prefixSumCount.put(0L, 1); // To handle the sum from the start
        int count = 0;

        for (int j = 1; j <= N; j++) {
            // Sum all counts of prefix sums less than or equal to modifiedArray[j]
            for (Long key : prefixSumCount.headMap(modifiedArray[j] + 1).keySet()) {
                count += prefixSumCount.get(key);
            }
            // Increment the count of the current prefix sum in the map
            prefixSumCount.put(modifiedArray[j], prefixSumCount.getOrDefault(modifiedArray[j], 0) + 1);
        }

        return count;
    }
}
