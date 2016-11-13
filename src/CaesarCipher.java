import javax.print.attribute.IntegerSyntax;
import javax.swing.*;

/**
 * Created by Aakash on 11/12/2016.
 */
public class CaesarCipher implements Methods{
    private final String alphabet = "abcdefghijklmnopqrstuvwxyz";
    private int decryptKey;
    private int key;
    public void encrypt(String text){
        text = text.toLowerCase();
        this.key=getKey();
        String encryptedText = "";
        for(int i=0;i<text.length();i++) {
            int position=alphabet.indexOf(text.charAt(i));
            int shiftValue=(key+position)%26;
            encryptedText=encryptedText + alphabet.charAt(shiftValue);
        }
        System.out.println(encryptedText);
    }
    public void decrypt(String text){
        text = text.toLowerCase();
        this.decryptKey=getKey();
        String decryptedText="";
        for (int i=0;i<text.length();i++)
        {
            int charPosition = alphabet.indexOf(text.charAt(i));
            int keyVal=(charPosition-key)%26;
            if (keyVal<0)
            {
                keyVal=alphabet.length()+keyVal;
            }
            char replaceVal=alphabet.charAt(keyVal);
            decryptedText+=replaceVal;
        }
        System.out.println(decryptedText);

    }
    private int getKey(){
        JPanel panel = new JPanel();
        JLabel label = new JLabel("Enter the key(number)");
        JPasswordField pass = new JPasswordField(10);
        panel.add(label);
        panel.add(pass);
        int option = JOptionPane.showConfirmDialog(null, pass, "Enter the key", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if(option == JOptionPane.OK_OPTION) // pressing OK button
        {
            char[] password = pass.getPassword();
            //System.out.println("key is: " + Integer.parseInt(new String(password)));
            return Integer.parseInt(new String(password));
        }
        else
            return 0;
    }
    }

