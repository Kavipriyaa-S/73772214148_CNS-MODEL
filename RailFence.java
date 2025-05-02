import java.util.*;

public class RailFenceCipher {
    static String encrypt(String text, int rails) {
        StringBuilder[] fence = new StringBuilder[rails];
        for (int i = 0; i < rails; i++) fence[i] = new StringBuilder();
        int dir = 1, row = 0;
        for (char c : text.toCharArray()) {
            fence[row].append(c);
            row += dir;
            if (row == 0 || row == rails - 1) dir *= -1;
        }
        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : fence) result.append(sb);
        return result.toString();
    }

    static String decrypt(String cipher, int rails) {
        int len = cipher.length(), dir = 1, row = 0, idx = 0;
        boolean[][] mark = new boolean[rails][len];
        for (int i = 0; i < len; i++) {
            mark[row][i] = true;
            row += dir;
            if (row == 0 || row == rails - 1) dir *= -1;
        }
        char[][] rail = new char[rails][len];
        for (int i = 0; i < rails; i++)
            for (int j = 0; j < len; j++)
                if (mark[i][j]) rail[i][j] = cipher.charAt(idx++);
        StringBuilder result = new StringBuilder();
        row = 0; dir = 1;
        for (int i = 0; i < len; i++) {
            result.append(rail[row][i]);
            row += dir;
            if (row == 0 || row == rails - 1) dir *= -1;
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message: ");
        String message = sc.nextLine().replaceAll(" ", "").toUpperCase();
        int rails = 4;
        String cipher = encrypt(message, rails);
        System.out.println("Encrypted: " + cipher);
        String plain = decrypt(cipher, rails);
        System.out.println("Decrypted: " + plain);
    }
}
