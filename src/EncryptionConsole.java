import java.io.*;
import java.util.Scanner;

public class EncryptionConsole {

	public static void main(String[] args) throws IOException {
		
		System.out.println("Encryption System \nType --help for documentation.");
		while(true){
			
			System.out.print("\n>>>");
			Scanner S = new Scanner(System.in);
			String query = S.nextLine();
			
			//System.out.println("quer" + query);
			if(query.equals("--exit"))
				break;
			if(query.equals("--help"))
			{
				
				System.out.println("This is an Encryption engine designed with java.\n"
						+ "\nFormat: "
						+ "*your text here* -param1 -param2 -param3 -param4"
						+ "\n -enc encrypts the input text"
						+ "\n -dec decrypts the input text"
						+ "\n\nEncryption techniques: "
						+ "\n -cs encrypts/decrypts using Ceasers cipher algorithm"
						+ "\n -vig encrypts/decrypts using Vigenere cipher algorithm"
						+ "\n -mono encrypts/decrypts using Monoalphabetic substitution"
						+ "\n\n For file I/O, \n-file parameter must be mentioned at the end, and file path must be given as input"
						+ "\n\n\nCeasers cipher requires an integer key"
						+ "\nVigenere and Mono ciphers require a string key"
						+ "\n\n--exit for exit"
						+ "\n\n\nDeveloped by Sourav J, Abinanth C, Naveen J and Tessy E."
						+ "\nAmrita Vishwa Vidyapeetham.");
				continue;
				
				
				
				
				
			}
			
			String commands[] = query.split(" -");
			if(commands.length<3)
			{System.out.println("Arguments missing. Please specify parameters. ");continue;}
			String message = commands[0];
			if(commands.length == 3)
			
			{		// ceasers cipher
			
			if(commands[1].equals("enc") && commands[2].equals("cs"))
				{	CCipher text = new CCipher();
					System.out.print("Enter key: ");
					int key = S.nextInt();
					System.out.println(text.encrypt(message, key));
				}
			if(commands[1].equals("dec") && commands[2].equals("cs"))
			{	CCipher text = new CCipher();
				System.out.print("Enter key: ");
				int key = S.nextInt();
				System.out.println(text.decrypt(message, key));
			}
			
			// vigenere cipher
			
			if(commands[1].equals("enc") && commands[2].equals("vig"))
			{	VigenereCipher text = new VigenereCipher();
				System.out.print("Enter key: ");
				String key = S.nextLine();
				System.out.println(text.encrypt(message, key));
			}
			if(commands[1].equals("dec") && commands[2].equals("vig"))
			{	VigenereCipher text = new VigenereCipher();
				System.out.print("Enter key: ");
				String key = S.nextLine();
				System.out.println(text.decrypt(message, key));
			}
			
			//mono sub
			

			if(commands[1].equals("enc") && commands[2].equals("mono"))
			{	MonoalphabeticCipher text = new MonoalphabeticCipher();
				System.out.print("Enter key: ");
				String key = S.nextLine();
				System.out.println(text.encrypt(message, key));
			}

			if(commands[1].equals("dec") && commands[2].equals("mono"))
			{	MonoalphabeticCipher text = new MonoalphabeticCipher();
				System.out.print("Enter key: ");
				String key = S.nextLine();
				System.out.println(text.decrypt(message, key));
			}}
			
		//file io
			//System.out.println("lel: " + commands.length);
			if(commands.length == 4)
			{// ceasers cipher
			
						if(commands[1].equals("enc") && commands[2].equals("cs") && commands[3].equals("file"))
							{	
							//System.out.println("im here");
							CCipher text = new CCipher();
								System.out.print("Enter key: ");
								int key = S.nextInt();
								FileReader in = null;
							    FileWriter out = null;
							    String dir = "/Users/Sourav/Desktop/encrypted_text_" + System.currentTimeMillis()+ "_.txt";

							      try {
							         //in = new FileReader(message);
							    	  
							         out = new FileWriter(dir);
							         try (BufferedReader br = new BufferedReader(new FileReader(message))) {
							        	    String line;
							        	    while ((line = br.readLine()) != null) {
							        	       out.write(text.encrypt(line, key));
							        	    }
							        	}
							      }finally {
							         if (in != null) {
							            in.close();
							         }
							         if (out != null) {
							            out.close();
							         }
							      }
							      Runtime.getRuntime().exec(new String[] {"open", dir});
							}
						if(commands[1].equals("dec") && commands[2].equals("cs") && commands[3].equals("file"))
						{	CCipher text = new CCipher();
						System.out.print("Enter key: ");
						int key = S.nextInt();
						FileReader in = null;
					    FileWriter out = null;
					    String dir = "/Users/Sourav/Desktop/decrypted_text_" + System.currentTimeMillis()+ "_.txt";

					      try {
					         //in = new FileReader(message);
					    	  
					         out = new FileWriter(dir);
					         try (BufferedReader br = new BufferedReader(new FileReader(message))) {
					        	    String line;
					        	    while ((line = br.readLine()) != null) {
					        	       out.write(text.decrypt(line, key));
					        	    }
					        	}
					      }finally {
					         if (in != null) {
					            in.close();
					         }
					         if (out != null) {
					            out.close();
					         }
					      }
					      Runtime.getRuntime().exec(new String[] {"open", dir});
						}
						
						// vigenere cipher
						
						if(commands[1].equals("enc") && commands[2].equals("vig") && commands[3].equals("file"))
						{	VigenereCipher text = new VigenereCipher();
							System.out.print("Enter key: ");
							String key = S.nextLine();
							FileReader in = null;
						    FileWriter out = null;
						    String dir = "/Users/Sourav/Desktop/encrypted_text_" + System.currentTimeMillis()+ "_.txt";

						      try {
						         //in = new FileReader(message);
						    	  
						         out = new FileWriter(dir);
						         try (BufferedReader br = new BufferedReader(new FileReader(message))) {
						        	    String line;
						        	    while ((line = br.readLine()) != null) {
						        	       out.write(text.encrypt(line, key));
						        	    }
						        	}
						      }finally {
						         if (in != null) {
						            in.close();
						         }
						         if (out != null) {
						            out.close();
						         }
						      }
						      Runtime.getRuntime().exec(new String[] {"open", dir});
						}
						if(commands[1].equals("dec") && commands[2].equals("vig") && commands[3].equals("file"))
						{	VigenereCipher text = new VigenereCipher();
							System.out.print("Enter key: ");
							String key = S.nextLine();
							FileReader in = null;
						    FileWriter out = null;
						    String dir = "/Users/Sourav/Desktop/decrypted_text_" + System.currentTimeMillis()+ "_.txt";

						      try {
						         //in = new FileReader(message);
						    	  
						         out = new FileWriter(dir);
						         try (BufferedReader br = new BufferedReader(new FileReader(message))) {
						        	    String line;
						        	    while ((line = br.readLine()) != null) {
						        	       out.write(text.decrypt(line, key));
						        	    }
						        	}
						      }finally {
						         if (in != null) {
						            in.close();
						         }
						         if (out != null) {
						            out.close();
						         }
						      }
						      Runtime.getRuntime().exec(new String[] {"open", dir});
						}
						
						//mono sub
						

						if(commands[1].equals("enc") && commands[2].equals("mono") && commands[3].equals("file"))
						{	MonoalphabeticCipher text = new MonoalphabeticCipher();
							System.out.print("Enter key: ");
							String key = S.nextLine();
							FileReader in = null;
						    FileWriter out = null;
						    String dir = "/Users/Sourav/Desktop/encrypted_text_" + System.currentTimeMillis()+ "_.txt";

						      try {
						         //in = new FileReader(message);
						    	  
						         out = new FileWriter(dir);
						         try (BufferedReader br = new BufferedReader(new FileReader(message))) {
						        	    String line;
						        	    while ((line = br.readLine()) != null) {
						        	       out.write(text.encrypt(line, key));
						        	    }
						        	}
						      }finally {
						         if (in != null) {
						            in.close();
						         }
						         if (out != null) {
						            out.close();
						         }
						      }
						      Runtime.getRuntime().exec(new String[] {"open", dir});
						}

						if(commands[1].equals("dec") && commands[2].equals("mono") && commands[3].equals("file"))
						{	MonoalphabeticCipher text = new MonoalphabeticCipher();
							System.out.print("Enter key: ");
							String key = S.nextLine();
							FileReader in = null;
						    FileWriter out = null;
						    String dir = "/Users/Sourav/Desktop/decrypted_text_" + System.currentTimeMillis()+ "_.txt";

						      try {
						         //in = new FileReader(message);
						    	  
						         out = new FileWriter(dir);
						         try (BufferedReader br = new BufferedReader(new FileReader(message))) {
						        	    String line;
						        	    while ((line = br.readLine()) != null) {
						        	       out.write(text.decrypt(line, key));
						        	    }
						        	}
						      }finally {
						         if (in != null) {
						            in.close();
						         }
						         if (out != null) {
						            out.close();
						         }
						      }
						      Runtime.getRuntime().exec(new String[] {"open", dir});
						}
						
			
			}
			
			
			
			
			
		}

	}

}
