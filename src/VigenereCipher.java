public class VigenereCipher extends Encryption
{
    public String encrypt(String text, String key)
    {
    	key = key.toUpperCase();
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if (c== ' ')
            	res = res+' ';
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c + key.charAt(j) - 2 * 'A') % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }
 
    public String decrypt(String text, String key)
    {
    	key = key.toUpperCase();
        String res = "";
        text = text.toUpperCase();
        for (int i = 0, j = 0; i < text.length(); i++)
        {
            char c = text.charAt(i);
            if(c == ' ')
            	res = res + ' ';
            if (c < 'A' || c > 'Z')
                continue;
            res += (char) ((c - key.charAt(j) + 26) % 26 + 'A');
            j = ++j % key.length();
        }
        return res;
    }

	@Override
	public String encrypt(String plain, int key) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrypt(String cipher, int key) {
		// TODO Auto-generated method stub
		return null;
	}
}
 
