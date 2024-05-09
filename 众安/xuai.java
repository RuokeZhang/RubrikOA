package 众安;

/*小红拿到了一个矩阵，n行m列共n\times m个小方格。小红有一个2*2的印章，每次可以将一个2*2的子矩阵染成红色，每个格子只能被染一次。小红染了若干个红色的2*2块，并且最终保证了每个2*2红色块都是不相邻的（如果两个红色块共用了同一个边或者同一个角，则称为两个红色块相邻）。
例如：下面矩阵为非法的，因为两个2*2红色块相邻了(共用了同一个角)：
**..
**..
..**
..**

小红忘了自己的染色过程，她拿到了一个矩阵，她想知道这个矩阵是否是按她的要求染色的？
共有t组询问。

输入描述
第一行输入一个正整数t，代表询问的次数。
对于每组询问，先输入两个正整数n和m，代表矩阵的行数和列数。
接下来的n行，每行输入一个长度为m的字符串。字符'*'代表格子被染成红色，'.'代表未被染色。
1\leq t,n,m \leq 50

输出描述
输出t行，每行对应一组询问的答案。
若该图形是小红染色的，则输出"Yes"。否则输出"No"。 */
import java.util.Scanner;

// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class xuai {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        int t = in.nextInt();
        for (int i = 0; i < t; i++) {
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] matrix = new char[n][m];
            for (int j = 0; j < n; j++) {
                String s = in.next();
                for (int k = 0; k < m; k++) {
                    matrix[j][k] = s.charAt(k);
                }
            }
            System.out.println(isRed(matrix) ? "Yes" : "No");
        }
    }

    public static boolean isRed(char[][] matrix) {
        // note that check the boundary

        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                if (i + 1 < matrix.length && j + 1 < matrix[0].length) {
                    if (matrix[i][j] == '*') {
                        if (matrix[i + 1][j] == '*' && matrix[i][j + 1] == '*'
                                && matrix[i + 1][j + 1] == '*') {
                            matrix[i][j] = '.';
                            matrix[i + 1][j] = '.';
                            matrix[i][j + 1] = '.';
                            matrix[i + 1][j + 1] = '.';
                            if (i + 2 < matrix.length && j + 2 < matrix[0].length)
                                if (matrix[i][j + 2] == '*' || matrix[i + 1][j + 2] == '*' || matrix[i + 2][j] == '*'
                                        || matrix[i + 2][j + 1] == '*' || matrix[i + 2][j + 2] == '*') {
                                    return false;
                                }
                        } else {
                            return false;
                        }
                    }
                }

            }
        }

        return true;
    }
}