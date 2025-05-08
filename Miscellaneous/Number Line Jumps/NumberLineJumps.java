import java.io.IOException;

class Result {
    public static String kangaroo(int x1, int v1, int x2, int v2) {
    int startDifference = x2 - x1;
    int jumpDifference = v2 - v1;
    if (startDifference * jumpDifference < 0 && startDifference % jumpDifference == 0) return "YES";
    return "NO";
    }

}

public class NumberLineJumps {
    public static void main(String[] args) throws IOException {
        int x1 = 0;
        int v1 = 3;
        int x2 = 4;
        int v2 = 2;

        String result = Result.kangaroo(x1, v1, x2, v2);
        System.out.println(result);
    }
}
