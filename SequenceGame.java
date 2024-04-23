import java.io.*;
import java.util.*;

public class SequenceGame {

    // MOD value as per the problem statement
    private static final int MOD = 1000000007;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt(); // Reading number of test cases

        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();
            int K = scanner.nextInt();
            int[] sequence = new int[N];

            for (int i = 0; i < N; i++) {
                sequence[i] = scanner.nextInt();
            }

            System.out.println(solve(N, K, sequence));
        }

        scanner.close();
    }

    private static long solve(int N, int K, int[] sequence) {
        // Sort the sequence first
        Arrays.sort(sequence);

        long result = 1L;

        // Calculate the product of numbers for each valid subsequence
        for (int i = 1; i <= N - K + 1; i++) {
            long subResult = 1L;

            // Compute the product of the middle K-2 numbers
            for (int j = i; j < i + K - 2; j++) {
                subResult = (subResult * sequence[j]) % MOD;
            }

            result = (result * subResult) % MOD;
        }

        return result;
    }
}
