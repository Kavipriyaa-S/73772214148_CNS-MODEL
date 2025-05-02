import java.security.*;
import java.util.Scanner;

public class ConsentFormSignature {
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        KeyPairGenerator keyGen = KeyPairGenerator.getInstance("DSA");
        keyGen.initialize(2048);
        KeyPair keyPair = keyGen.generateKeyPair();
        PrivateKey privateKey = keyPair.getPrivate();
        PublicKey publicKey = keyPair.getPublic();
        System.out.println("Enter the consent form content:");
        String formContent = scanner.nextLine();
        Signature signer = Signature.getInstance("SHA256withDSA");
        signer.initSign(privateKey);
        signer.update(formContent.getBytes("UTF-8"));
        byte[] signature = signer.sign();
        System.out.println("Consent form signed.");
        System.out.println("Verifying the signed consent form...");
        Signature verifier = Signature.getInstance("SHA256withDSA");
        verifier.initVerify(publicKey);
        verifier.update(formContent.getBytes("UTF-8"));
        boolean valid = verifier.verify(signature);
        if (valid) {
            System.out.println("Signature verified. Consent form is authentic.");
        } else {
            System.out.println("Signature verification failed. Consent form may be forged.");
        }
    }
}
