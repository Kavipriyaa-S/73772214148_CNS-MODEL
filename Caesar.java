import java.util.Scanner;

public class CaesarBruteForce {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the ciphertext: ");
        String cipher = sc.nextLine().toUpperCase();
        for (int shift = 1; shift < 26; shift++) {
            StringBuilder result = new StringBuilder();
            for (char c : cipher.toCharArray()) {
                if (c >= 'A' && c <= 'Z') {
                    char ch = (char) ((c - 'A' - shift + 26) % 26 + 'A');
                    result.append(ch);
                } else {
                    result.append(c);
                }
            }
            System.out.println("Shift " + shift + ": " + result);
        }
    }
}
