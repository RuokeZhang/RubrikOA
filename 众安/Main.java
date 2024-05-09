package 众安;
/*第一行输入一个正整数 ，代表字符串长度。

第二行输入一个长度为  的仅由小写字母构成的字符串 .

输出描述
输出一共  行，每行输出  个整数，其中：

第  行的第  个整数，代表以下标  为界的后缀中，有多少个字符串至少含有一个字母 ；
第  行的第  个整数，代表以下标  为界的后缀中，有多少个字符串至少含有一个字母 ；
...
第  行的第  个整数，代表以下标  为界的后缀中，有多少个字符串至少含有一个字母 . 
以 \mathit i\ =\ \text 1 为界的后缀，只有一个字符串 "x"，因此，在第一行的输出中，只有 \mathit x 的位置上是 \text 1，其余均为 \text 0；

以 \mathit i\ =\ \text 2 为界的后缀，有两个字符串，"xy"，"y"，其中，字符 \mathit x 在一个字符串中出现，而字符 \mathit y 在两个字符串中出现，因此，在第二行的输出中，\mathit x,\ \mathit y 对应的位置上分别是 \text 1,\ \text 2，其余均为 \text 0；

以 \mathit i\ =\ \text 3 为界的后缀，有三个字符串，"xyh"，"yh"，"h"，其中，字符 \mathit x 在一个字符串中出现，字符 \mathit y 在两个字符串中出现，字符 \mathit h 在三个字符串中出现，因此，在第三行的输出中，\mathit x,\ \mathit y,\ \mathit h 对应的位置上分别是 \text 1,\ \text 2,\ \text 3，其余均为 \text 0；

以 \mathit i\ =\ \text 4 为界的后缀，有四个字符串，"xyhx"，"yhx"，"hx"，"x"，其中，字符 \mathit x 在四个字符串中出现，字符 \mathit y 在两个字符串中出现，字符 \mathit h 在三个字符串中出现，因此，在第四行的输出中，\mathit x,\ \mathit y,\ \mathit h 对应的位置上分别是 \text 4,\ \text 2,\ \text 3，其余均为 \text 0。*/
/*4 xyhx 
 *  0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 0 0
    0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 2 0
    0 0 0 0 0 0 0 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 1 2 0
    0 0 0 0 0 0 0 3 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 4 2 0
*/
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt(); // 读取长度
        in.nextLine(); // 跳过行结束符
        String s = in.nextLine(); // 读取字符串

        char[] chars = s.toCharArray();

        int[][] res = new int[len][26]; // 存储结果的二维数组
        int[] last = new int[26]; // 存储每个字母最后一次出现的位置加1

        // 初始化last数组
        for (int i = 0; i < 26; i++) {
            last[i] = 0; // 最开始设置为0，因为还未出现
        }

        for (int i = 0; i < len; i++) {
            int index = chars[i] - 'a';
            last[index] = i + 1; // 更新当前字符最后一次出现的位置加1
            for (int j = 0; j < 26; j++) {
                res[i][j] = last[j]; // 将last数组的当前状态复制到res中
            }
        }

        // 输出结果
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < 26; j++) {
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }
}
