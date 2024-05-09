package 阅文;

import java.util.Arrays;

//5 -4 -2 8 -11

public class MaxProduct {
    /**
     * 代码中的类名、方法名、参数名已经指定，请勿修改，直接返回方法规定的值即可
     *
     * 
     * @param nums int整型一维数组 
     * @return int整型
     */
    public int maxProduct (int[] nums) {
        // write code here
        int n=nums.length;
        int[] minus=new int[n];
        int[] positive=new int[n];

        if(n==1){
            return nums[0];
        }
        if(nums[0]>0){
            positive[0]=nums[0];
        }else if(nums[0]<0){
            minus[0]=nums[0];
        }
        
        for(int i=1;i<n;i++){
            if(nums[i]<0){
                minus[i]=Math.min(positive[i-1]*nums[i],nums[i]);
                positive[i]=minus[i-1]*nums[i];
            }
            if(nums[i]>0){
                positive[i]=Math.max(positive[i-1]*nums[i],nums[i]);
                minus[i]=minus[i-1]*nums[i];
            }
        }
        int res=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            res=Math.max(res,positive[i]);
            res=Math.max(res,minus[i]);
        }
        return res;
    }
}