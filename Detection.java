import java.util.Scanner;

public class ARPSpoofingDetection {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ARP packet source IP:");
        String sourceIP = scanner.nextLine();
        System.out.println("Enter ARP packet target IP:");
        String targetIP = scanner.nextLine();
        System.out.println("Enter MAC address of source:");
        String sourceMAC = scanner.nextLine();
        System.out.println("Enter MAC address of target:");
        String targetMAC = scanner.nextLine();
        
        if (sourceIP.equals(targetIP) && !sourceMAC.equals(targetMAC)) {
            System.out.println("Suspicious ARP broadcast detected. Potential ARP spoofing attack.");
        } else {
            System.out.println("ARP packet is normal.");
        }
    }
}
