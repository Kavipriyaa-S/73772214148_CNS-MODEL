import java.util.*;

public class PlayfairCipher {

    static char[][] matrix = new char[5][5];
    static String key = "SECURITY";

    public static void createMatrix() {
        Set<Character> usedChars = new HashSet<>();
        StringBuilder sb = new StringBuilder(key.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I"));
        String alphabet = "ABCDEFGHIKLMNOPQRSTUVWXYZ";

        for (char c : sb.toString().toCharArray()) usedChars.add(c);
        sb = new StringBuilder();

        for (char c : alphabet.toCharArray()) if (!usedChars.contains(c)) sb.append(c);
        sb.insert(0, sb.toString());

        int index = 0;
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) matrix[i][j] = sb.charAt(index++);
    }

    public static String prepareText(String text) {
        text = text.toUpperCase().replaceAll("[^A-Z]", "").replace("J", "I");
        StringBuilder sb = new StringBuilder(text);

        for (int i = 0; i < sb.length() - 1; i++) if (sb.charAt(i) == sb.charAt(i + 1)) sb.insert(i + 1, 'X');
        if (sb.length() % 2 != 0) sb.append('X');
        return sb.toString();
    }

    public static String[] splitPairs(String text) {
        String[] pairs = new String[text.length() / 2];
        for (int i = 0; i < text.length(); i += 2) pairs[i / 2] = text.substring(i, i + 2);
        return pairs;
    }

    public static int[] findPosition(char c) {
        for (int i = 0; i < 5; i++) for (int j = 0; j < 5; j++) if (matrix[i][j] == c) return new int[]{i, j};
        return new int[]{-1, -1};
    }

    public static String process(String text, boolean encrypt) {
        StringBuilder result = new StringBuilder();
        String[] pairs = splitPairs(prepareText(text));

        for (String pair : pairs) {
            int[] pos1 = findPosition(pair.charAt(0)), pos2 = findPosition(pair.charAt(1));

            if (pos1[0] == pos2[0]) {
                result.append(matrix[pos1[0]][(pos1[1] + (encrypt ? 1 : 4)) % 5]);
                result.append(matrix[pos2[0]][(pos2[1] + (encrypt ? 1 : 4)) % 5]);
            } else if (pos1[1] == pos2[1]) {
                result.append(matrix[(pos1[0] + (encrypt ? 1 : 4)) % 5][pos1[1]]);
                result.append(matrix[(pos2[0] + (encrypt ? 1 : 4)) % 5][pos2[1]]);
            } else {
                result.append(matrix[pos1[0]][pos2[1]]);
                result.append(matrix[pos2[0]][pos1[1]]);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the message: ");
        String message = scanner.nextLine();
        
        createMatrix();
        String encrypted = process(message, true);
        System.out.println("Encrypted Message: " + encrypted);
        String decrypted = process(encrypted, false);
        System.out.println("Decrypted Message: " + decrypted);
    }
}
