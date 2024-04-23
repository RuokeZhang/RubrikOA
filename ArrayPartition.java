import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ArrayPartition {
    
    // Assuming the function is defined as follows:
    // findMaxKAndSubarrayLengths(int[] arr, int G) -> returns an object or a structure with max K and list of subarray lengths

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the input for N and G
        System.out.print("Enter N and G: ");
        int N = scanner.nextInt();
        int G = scanner.nextInt();
        
        // Read the array elements
        int[] arr = new int[N];
        System.out.print("Enter the array elements separated by space: ");
        for (int i = 0; i < N; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Assuming the algorithm is implemented in findMaxKAndSubarrayLengths
        Result result = findMaxKAndSubarrayLengths(arr, G);

        // Output the result
        if (result.maxK == -1) {
            System.out.println(-1);
        } else {
            System.out.println("Max K possible: " + result.maxK);
            System.out.println("Lengths of subarrays in lexicographical order: ");
            for (int length : result.subarrayLengths) {
                System.out.print(length + " ");
            }
        }
        
        scanner.close();
    }

    // You will need to define the Result class according to your output needs
    // and also the findMaxKAndSubarrayLengths function which contains your algorithm.
    private static class Result {
        int maxK;
        List<Integer> subarrayLengths;

        public Result(int maxK, List<Integer> subarrayLengths) {
            this.maxK = maxK;
            this.subarrayLengths = subarrayLengths;
        }
    }
    
    // Mock implementation of the function - replace this with your actual algorithm
    private static Result findMaxKAndSubarrayLengths(int[] arr, int G) {
        List<Integer> subarrayLengths=new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            arr[i]-=G;
        }

        int[] preSum=new int[arr.length+1];
        for(int i=1;i<=arr.length;i++){
            preSum[i]=preSum[i-1]+arr[i-1];
        }

        //greedy
        //0 1 -3 -1 3 2
        int last=preSum[preSum.length-1];
        int prev=0;
        int count=0;
        for(int i=1;i<preSum.length;i++){
           if(preSum[i]>preSum[prev]&&preSum[i]<=last){
                count++;
                subarrayLengths.add(i-prev);
                prev=i;
           }
        }
        if(count==0){
            return new Result(-1, subarrayLengths);
        }
        return new Result(count, subarrayLengths); // placeholder return
    }
}
