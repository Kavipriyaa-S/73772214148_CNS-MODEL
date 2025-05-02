import java.util.*;

public class HillCipher {

    static int[][] keyMatrix = {{3, 3}, {2, 5}};
    static int[][] inverseKeyMatrix = {{7, 23}, {18, 17}};

    public static String preprocessText(String text) {
        StringBuilder sb = new StringBuilder(text.toUpperCase().replaceAll("[^A-Z]", ""));
        if (sb.length() % 2 != 0) sb.append('X');
        return sb.toString();
    }

    public static int[] convertToNumbers(String text) {
        int[] numbers = new int[text.length()];
        for (int i = 0; i < text.length(); i++) {
            numbers[i] = text.charAt(i) - 'A';
        }
        return numbers;
    }

    public static String convertToText(int[] numbers) {
        StringBuilder sb = new StringBuilder();
        for (int num : numbers) {
            sb.append((char) (num + 'A'));
        }
        return sb.toString();
    }

    public static int[] encrypt(int[] message) {
        int[] encrypted = new int[message.length];
        for (int i = 0; i < message.length; i += 2) {
            encrypted[i] = (keyMatrix[0][0] * message[i] + keyMatrix[0][1] * message[i + 1]) % 26;
            encrypted[i + 1] = (keyMatrix[1][0] * message[i] + keyMatrix[1][1] * message[i + 1]) % 26;
        }
        return encrypted;
    }

    public static int[] decrypt(int[] ciphertext) {
        int[] decrypted = new int[ciphertext.length];
        for (int i = 0; i < ciphertext.length; i += 2) {
            decrypted[i] = (inverseKeyMatrix[0][0] * ciphertext[i] + inverseKeyMatrix[0][1] * ciphertext[i + 1]) % 26;
            decrypted[i + 1] = (inverseKeyMatrix[1][0] * ciphertext[i] + inverseKeyMatrix[1][1] * ciphertext[i + 1]) % 26;
        }
        return decrypted;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter plaintext message: ");
        String plaintext = scanner.nextLine();

        String preparedText = preprocessText(plaintext);
        int[] message = convertToNumbers(preparedText);
        int[] ciphertext = encrypt(message);
        String encryptedText = convertToText(ciphertext);
        System.out.println("Encrypted Message: " + encryptedText);

        int[] decryptedMessage = decrypt(ciphertext);
        String decryptedText = convertToText(decryptedMessage);
        System.out.println("Decrypted Message: " + decryptedText);
    }
}
