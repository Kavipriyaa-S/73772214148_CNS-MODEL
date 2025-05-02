import java.util.Scanner;

public class VigenereCipher {
    static String format(String text) {
        return text.toUpperCase().replaceAll("[^A-Z]", "");
    }

    static String generateKey(String text, String key) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < text.length(); i++)
            sb.append(key.charAt(i % key.length()));
        return sb.toString();
    }

    static String encrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int c = (text.charAt(i) + key.charAt(i) - 2 * 'A') % 26 + 'A';
            result.append((char) c);
        }
        return result.toString();
    }

    static String decrypt(String text, String key) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            int c = (text.charAt(i) - key.charAt(i) + 26) % 26 + 'A';
            result.append((char) c);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter message: ");
        String message = format(sc.nextLine());
        System.out.print("Enter keyword: ");
        String keyword = format(sc.nextLine());
        String key = generateKey(message, keyword);
        String cipher = encrypt(message, key);
        System.out.println("Encrypted: " + cipher);
        String plain = decrypt(cipher, key);
        System.out.println("Decrypted: " + plain);
    }
}
