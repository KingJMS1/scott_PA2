
public class Encrypter {
	
	// Fill w/ zeroes until we have 4 chars, use strings to add 7 and modulo
	// by 10 for all chars, swap pos 1,3; pos 2,4.
	
	public static int encrypt(int input)	{
		String data = Integer.toString(input);
		data = Decrypter.stuff_w_zeros(data);
		String out = "";
		
		for (int i = 0; i < data.length(); i++)	{
			char c = data.charAt(i);
			out += Integer.toString(((Integer.parseInt(String.valueOf(c)) + 7) % 10));
		}
		
		char pos[] = out.toCharArray();
		char tmp = pos[0];
		pos[0] = pos[2];
		pos[2] = tmp;
		tmp = pos[1];
		pos[1] = pos[3];
		pos[3] = tmp;
		return Integer.parseInt(String.copyValueOf(pos));
	}
	
}
