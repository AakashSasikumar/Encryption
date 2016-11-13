import javax.crypto.spec.SecretKeySpec;
import javax.swing.*;
import java.security.*;
import javax.crypto.*;
import sun.misc.*;

/**
 * Created by Aakash on 11/13/2016.
 */
public class AES implements Methods{
    private Key getKey() {
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter the key(16 letters only)");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        int option = JOptionPane.showConfirmDialog(null, pass, "Enter key(16 letters/digits only)", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (option == JOptionPane.OK_OPTION) // pressing OK button
        {
            char[] password = pass.getPassword();
            String keyVal = new String(password);
            return new SecretKeySpec(keyVal.getBytes(), "AES");

        }
        return null;
    }


    public void encrypt(String text) throws Exception {
        Key key = getKey();
        Cipher cph = Cipher.getInstance("AES");
        cph.init(Cipher.ENCRYPT_MODE, key);
        byte[] encryptedBytes = cph.doFinal(text.getBytes());
        String encryptedText = new BASE64Encoder().encode(encryptedBytes);
        System.out.println(encryptedText);


    }


    public void decrypt(String text) throws Exception {
        Key key = getKey();
        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] decodedVal = new BASE64Decoder().decodeBuffer(text);
        byte[] decryptedBytes = cipher.doFinal(decodedVal);
        String decryptedText = new String(decryptedBytes);
        System.out.println(decryptedText);
    }
}
