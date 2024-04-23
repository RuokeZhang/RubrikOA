// Importing necessary classes
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

// Main class for the solution
public class SequenceFinder {

    // Class to mimic the struct 'node' from C++
    // Used for storing and manipulating data during computation
    static class Node {
        int len;  // Length of the sequence
        int ind;  // Index in the string
        char c;   // Character associated with this node

        // Constructor to initialize a Node
        Node(int len, int ind, char c) {
            this.len = len;
            this.ind = ind;
            this.c = c;
        }
    }

    // Method to compute the result based on the provided string 's'
    public static String solution(String s) {
        final int n = s.length();  // Length of the input string
        List<Node> ans = new ArrayList<>(n);  // List to store Node objects for dynamic programming
        for (int i = 0; i < n; i++) {
            ans.add(new Node(Integer.MAX_VALUE, 0, 'z')); // Initialize with default Nodes
        }
        int[] p = new int[26];  // Array to track the latest index of each character
        Arrays.fill(p, -1);  // Initialize all indices as -1

        // Iterate from end to start of the string
        for (int i = n - 1; i >= 0; --i) {
            ans.set(i, new Node(Integer.MAX_VALUE, 0, 'z'));  // Reset the Node at index i
            for (int j = 0; j < 26; ++j) {  // Iterate through all possible lowercase letters
                Node temp = new Node(p[j] < 0 ? 0 : (1 + ans.get(p[j]).len), p[j], (char) ('a' + j));  // Create a temporary Node for comparison
                if (ans.get(i).len > temp.len) {  // If the current Node has a longer length than temp
                    ans.set(i, temp);  // Update the Node at index i to be temp
                }
            }
            p[s.charAt(i) - 'a'] = i;  // Update the last occurrence index of the current character
        }
        int v = 0;  // Variable to store the character index with the smallest sequence length
        // Find the character with the minimal length sequence
        for (int i = 0; i < 26; ++i) {
            if (p[i] < 0) return String.valueOf((char) ('a' + i));  // If any character has not appeared, return it
            if (ans.get(p[v]).len > ans.get(p[i]).len) {  // If the current minimal length is greater than another's
                v = i;  // Update v to the new minimum
            }
        }
        StringBuilder r = new StringBuilder();  // String builder to construct the result string
        r.append((char) ('a' + v));  // Append the character with the minimal length sequence
        // Build the sequence using the Nodes' information
        for (v = p[v]; v >= 0; v = ans.get(v).ind) {
            r.append(ans.get(v).c);  // Append the character from the Node at the current index
        }
        return r.toString();  // Convert the StringBuilder to a String and return it
    }

    // Main method to test the solution method
    public static void main(String[] args) {
        System.out.println(solution("abcdefghijklmnopqrstuvwxyz"));  // Test with a simple alphabetical string
        System.out.println(solution("vefbmmzlgczhvtkzngsfymdhsndshjwwnfzkaywifjdikhyquofnswcbeipfhtuwrbxmfiwopzxtqwbgcafndhickjdiziggsvef"));  // Test with a complex string
    }
}
