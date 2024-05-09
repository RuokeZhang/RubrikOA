package zijie;
import java.util.Scanner;
//1 2 3 4
//5 6 7 8
// 注意类名必须为 Main, 不要有任何 package xxx 信息
public class MatrixArea {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            int b = in.nextInt();
            System.out.println(a + b);
        }
    }
}