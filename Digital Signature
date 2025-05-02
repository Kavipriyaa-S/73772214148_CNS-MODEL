import java.security.*;
import java.util.Scanner;

public class DigitalSignature{
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("Enter the document to be signed:");
        String input = scanner.nextLine();
        Signature signer = Signature.getInstance("SHA256withDSA");
        signer.initSign(privateKey);
        signer.update(input.getBytes("UTF-8"));
        byte[] signature = signer.sign();
        System.out.println("Document signed successfully.");
        System.out.println("Verifying signature...");
        Signature verifier = Signature.getInstance("SHA256withDSA");
        verifier.initVerify(publicKey);
        verifier.update(input.getBytes("UTF-8"));
        boolean isVerified = verifier.verify(signature);
        if (isVerified) {
            System.out.println("Signature is valid. Document is authentic.");
        } else {
            System.out.println("Signature is invalid. Document may have been tampered with.");
        }
    }
}
