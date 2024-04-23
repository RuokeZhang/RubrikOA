import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class XORedSequences {
    
    private static final int MOD = 1000000007;

    // Function to calculate GCD of two numbers
    private static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    // Function to calculate the special XOR power for a given sequence
    private static long calculateSpecialXORPower(List<Integer> sequence) {
        long power = 0;
        for (int i = 0; i < sequence.size() - 1; i++) {
            long gcdValue = gcd(sequence.get(i), sequence.get(i + 1));
            long xorValue = sequence.get(i) ^ sequence.get(i + 1);
            power += gcdValue + xorValue;
        }
        return power;
    }

    // Recursive function to generate all permutations of the array and calculate min and max power
    private static void findAllPowers(List<Integer> sequence, List<Integer> remaining, long[] minMaxPower) {
        if (remaining.isEmpty()) {
            long power = calculateSpecialXORPower(sequence);
            minMaxPower[0] = Math.min(minMaxPower[0], power);
            minMaxPower[1] = Math.max(minMaxPower[1], power);
            return;
        }
        for (int i = 0; i < remaining.size(); i++) {
            int number = remaining.remove(i);
            sequence.add(number);
            findAllPowers(sequence, remaining, minMaxPower);
            sequence.remove(sequence.size() - 1);
            remaining.add(i, number);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(scanner.nextInt());
        }
        scanner.close();

        // Initialize minMaxPower array with [min, max]
        long[] minMaxPower = new long[]{Long.MAX_VALUE, Long.MIN_VALUE};
        
        // Generate all permutations and calculate special XOR power for each
        findAllPowers(new ArrayList<>(), A, minMaxPower);

        // Find the difference between maximum and minimum special XOR power
        long difference = minMaxPower[1] - minMaxPower[0];
        
        System.out.println(difference);
    }
}
