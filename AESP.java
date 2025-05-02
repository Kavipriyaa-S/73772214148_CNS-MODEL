import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Scanner;
import java.util.Base64;

public class AESPinEncryption {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter 4-digit PIN: ");
        String pin = sc.nextLine();
        System.out.print("Enter 16-char secret key: ");
        String key = sc.nextLine();
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(), "AES");
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encrypted = cipher.doFinal(pin.getBytes());
        String encryptedPin = Base64.getEncoder().encodeToString(encrypted);
        System.out.println("Encrypted PIN: " + encryptedPin);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decrypted = cipher.doFinal(Base64.getDecoder().decode(encryptedPin));
        String decryptedPin = new String(decrypted);
        System.out.println("Decrypted PIN: " + decryptedPin);
    }
}
