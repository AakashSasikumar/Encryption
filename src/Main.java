import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Aakash on 11/12/2016.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        //----------Caesar Cipher------------------
        CaesarCipher cc = new CaesarCipher();
        cc.encrypt("jourav sohar");//returns mrxudycvrkdu with key 3
        cc.decrypt("mrxudycvrkdu");//spaces dont seem to work. they get replaced with 'z'. idk why, maybe we can set a flag to see if
                                   //the original string contains space, and then we can replace all 'z's with space at the end
                                   // but it might not work all the time. lets see...

        //---------Monoalphabetic Substitution Cipher-------------
        MonoAlpha ma = new MonoAlpha();
        ma.encrypt("Aakash");//returns QQAQLI
        ma.decrypt("QQAQLI");//it only works with lower case, its gonna be a pain in the ass to make it work for uppercase too...


        //----------Built In AES Encryption-----------------
        AES aes = new AES();
        aes.encrypt("Aakash");//encrypted to yGjSnvnCPywe+gqmC/hFRw== with key asdfasdfasdfasdf
        aes.decrypt("yGjSnvnCPywe+gqmC/hFRw==");//back to aakash with asdfasdfasdfasdf

    }

}
