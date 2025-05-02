import java.security.*;
import java.util.Scanner;

public class LegalDocumentSignature {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("Enter the legal document content:");
        String document = scanner.nextLine();
        Signature signer = Signature.getInstance("SHA256withDSA");
        signer.initSign(privateKey);
        signer.update(document.getBytes("UTF-8"));
        byte[] signature = signer.sign();
        System.out.println("Document signed and submitted.");
        System.out.println("Verifying submitted document...");
        Signature verifier = Signature.getInstance("SHA256withDSA");
        verifier.initVerify(publicKey);
        verifier.update(document.getBytes("UTF-8"));
        boolean verified = verifier.verify(signature);
        if (verified) {
            System.out.println("Signature verified. Document is original and authentic.");
        } else {
            System.out.println("Signature verification failed. Document may be altered.");
        }
    }
}
