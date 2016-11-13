/**
 * Created by Aakash on 11/12/2016.
 */
public class MonoAlpha implements Methods{
    private final char p[]  = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
            'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z' };
    private final char ch[] = { 'Q', 'W', 'E', 'R', 'T', 'Y', 'U', 'I', 'O',
            'P', 'A', 'S', 'D', 'F', 'G', 'H', 'J', 'K', 'L', 'Z', 'X', 'C',
            'V', 'B', 'N', 'M' };
    public void encrypt(String text){
        text =text.toLowerCase();
        char encryptedText[]=new char[(text.length())];
        for (int i=0;i<text.length();i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (p[j] == text.charAt(i))
                {
                    encryptedText[i] = ch[j];
                    break;
                }
            }
        }
        System.out.println((new String(encryptedText)));
    }
    public void decrypt(String text){
        char decryptedText[] = new char[(text.length())];
        for (int i = 0; i < text.length(); i++)
        {
            for (int j = 0; j < 26; j++)
            {
                if (ch[j] == text.charAt(i))
                {
                    decryptedText[i] = p[j];
                    break;
                }
            }
        }
        System.out.println((new String(decryptedText)));
    }
}
