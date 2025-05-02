import java.util.*;

public class PlayfairCipher {

    static char[][] matrix = new char[5][5];

    public static void createMatrix(String key) {
        Set<Character> used = new LinkedHashSet<>();
        key = key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        for (char c : key.toCharArray()) used.add(c);
        for (char c = 'A'; c <= 'Z'; c++) if (c != 'J') used.add(c);
        Iterator<Character> it = used.iterator();
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) matrix[i][j] = it.next();
    }

    public static String prepareText(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder sb = new StringBuilder(text);
        for (int i = 0; i < sb.length() - 1; i += 2)
            if (sb.charAt(i) == sb.charAt(i + 1)) sb.insert(i + 1, 'X');
        if (sb.length() % 2 != 0) sb.append('X');
        return sb.toString();
    }

    public static int[] findPos(char c) {
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) if (matrix[i][j] == c) return new int[]{i, j};
        return null;
    }

    public static String process(String text, boolean encrypt) {
        StringBuilder sb = new StringBuilder();
        text = prepareText(text);
        for (int i = 0; i < text.length(); i += 2) {
            char a = text.charAt(i), b = text.charAt(i + 1);
            int[] pos1 = findPos(a), pos2 = findPos(b);
            if (pos1[0] == pos2[0]) {
                sb.append(matrix[pos1[0]][(pos1[1] + (encrypt ? 1 : 4)) % 5]);
                sb.append(matrix[pos2[0]][(pos2[1] + (encrypt ? 1 : 4)) % 5]);
            } else if (pos1[1] == pos2[1]) {
                sb.append(matrix[(pos1[0] + (encrypt ? 1 : 4)) % 5][pos1[1]]);
                sb.append(matrix[(pos2[0] + (encrypt ? 1 : 4)) % 5][pos2[1]]);
            } else {
                sb.append(matrix[pos1[0]][pos2[1]]);
                sb.append(matrix[pos2[0]][pos1[1]]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter message to encrypt: ");
        String message = scanner.nextLine();
        System.out.print("Enter key: ");
        String key = scanner.nextLine();
        createMatrix(key);
        String encrypted = process(message, true);
        System.out.println("Encrypted Message: " + encrypted);
        String decrypted = process(encrypted, false);
        System.out.println("Decrypted Message: " + decrypted);
    }
}
