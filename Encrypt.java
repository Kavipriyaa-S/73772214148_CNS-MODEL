import java.util.Scanner;

public class RSAEncrypt {
    static int gcd(int a, int b) {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    static int modInverse(int e, int phi) {
        for (int d = 1; d < phi; d++) {
            if ((e * d) % phi == 1) return d;
        }
        return -1;
    }

    static int modPow(int base, int exp, int mod) {
        int result = 1;
        base = base % mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int p = 19, q = 41, n = p * q, phi = (p - 1) * (q - 1), e = 7;
        int d = modInverse(e, phi);
        System.out.print("Enter message (as integer < " + n + "): ");
        int m = sc.nextInt();
        int c = modPow(m, e, n);
        System.out.println("Encrypted: " + c);
        int decrypted = modPow(c, d, n);
        System.out.println("Decrypted: " + decrypted);
    }
}
