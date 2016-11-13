import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by Aakash on 11/13/2016.
 */
public interface Methods {
    public void encrypt(String text) throws Exception;
    public void decrypt(String text) throws Exception;
}
