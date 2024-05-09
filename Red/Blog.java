package Red;

import java.util.PriorityQueue;
import java.util.Scanner;

/*小红书笔试第二题，博客有点赞数和评论数，在n篇博客中选取k篇，使得评分最高。
评分规则：选取的博客中的点赞数之和与评论数最小值的乘积。
例子：n=4, k=2
点赞：[1,2,3,4]
评论数： [4,3,2,1]
最大评分：10（选取第二篇与第三篇）

每次固定一个最小评论数，然后从剩下的里面选择 k-1 个最大点赞数的文章，然后计算评论数之和与最小评论数的乘积，取最大值即可。
所以先把评论数按从大到小排序。比如一开始，k个文章选的是评论数最大的k篇文章，这个时候最小评论数就是评论数第k大的那个数。剩余的k-1篇文章，只能是比它评论数还要大的文章
那么考虑评论数第(k-1)大的文章， 剩下的(k-1)篇文章要从比它评论数大的k篇文章中选。这 k篇文章里面，点赞数最小的那篇文章我们不需要考虑了，反正它的评论数我们也用不到。


*/
public class Blog {
        public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int N=in.nextInt();
        int K=in.nextInt();
        int[] like=new int[N];
        int[] comment=new int[N];
        for(int i=0;i<N;i++){
            like[i]=in.nextInt();
        }
        for(int i=0;i<N;i++){
            comment[i]=in.nextInt();
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();



    }
}
