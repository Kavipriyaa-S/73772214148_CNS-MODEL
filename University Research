import java.security.MessageDigest;
import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class ResearchPaperPlagiarismChecker {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        Set<String> storedHashes = new HashSet<>();
        storedHashes.add("5c97a12eae8f6747c5d1c9d2a9f89e31421bdc45");
        storedHashes.add("a59c6a70dfb7eec6f8dbb1a8720c5d1be57c9968");
        storedHashes.add("d46a0bc859cc1eb9b3215f3154e7e1a1398fdf91");

        System.out.println("Enter the full text of the research paper:");
        String input = scanner.nextLine();

        MessageDigest md = MessageDigest.getInstance("SHA-1");
        byte[] hashBytes = md.digest(input.getBytes("UTF-8"));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) sb.append(String.format("%02x", b));
        String currentHash = sb.toString();

        System.out.println("\nSHA-1 hash of the research paper:");
        System.out.println(currentHash);

        System.out.println("\nChecking for duplication...");
        if (storedHashes.contains(currentHash)) {
            System.out.println("Result: Duplicate detected. This research paper matches a previously submitted work.");
        } else {
            System.out.println("Result: No match found. The research paper is considered original.");
            storedHashes.add(currentHash);
        }
    }
}

