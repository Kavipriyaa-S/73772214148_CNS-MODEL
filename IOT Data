import java.security.MessageDigest;
import java.util.Scanner;

public class IoTDataIntegritySystem {

    public static String computeSHA1Hash(String message) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] hashBytes = md.digest(message.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("===== IoT Sensor Data Integrity System =====");
        System.out.println("Enter the temperature sensor data:");

        String inputData = scanner.nextLine();

        String hash = computeSHA1Hash(inputData);

        System.out.println("\nSHA-1 hash of the sensor data:");
        System.out.println(hash);

        System.out.println("\nSimulating server-side verification...");
        String receivedHash = hash;  
        String receivedData = inputData; 

        System.out.println("Verifying integrity of received message...");
        String receivedDataHash = computeSHA1Hash(receivedData);

        if (receivedDataHash.equals(receivedHash)) {
            System.out.println("Data integrity verified. Message is authentic and untampered.");
        } else {
            System.out.println("Data integrity compromised. The message has been tampered.");
        }
    }
}
