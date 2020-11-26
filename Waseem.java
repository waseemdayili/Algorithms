import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.nio.charset.StandardCharsets;
import java.util.*;

public class Waseem {

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String plaintext="",salt="";
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter plaintext to be hashed: ");
        plaintext = sc.nextLine();

        System.out.println("Enter the salt: ");
        salt = sc.nextLine();

        MessageDigest digest = MessageDigest.getInstance("SHA-256");

        digest.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] plaintextBytes=plaintext.getBytes(StandardCharsets.UTF_8);
		byte[] hashed = digest.digest(plaintextBytes);
        

        System.out.println("The SHA-256 value is " + bytesToHex(hashed));
    }

	 public static String bytesToHex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            sb.append(String.format("%02X ", b));
        }
        return sb.toString();
    }
}