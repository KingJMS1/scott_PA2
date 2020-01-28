import java.util.Scanner;

public class Application {
	public static void main(String args[])	{
			
			Scanner stdin = new Scanner(System.in);
			System.out.println("Please enter a 4 digit integer: ");
			int touse = stdin.nextInt();
			int enc = Encrypter.encrypt(touse);
			int dec = Decrypter.decrypt(touse);
			System.out.printf("Encrypted Integer: %04d\n", enc);
			System.out.printf("Decrypted Integer: %04d\n", dec);
			stdin.close();
			
		}
}
