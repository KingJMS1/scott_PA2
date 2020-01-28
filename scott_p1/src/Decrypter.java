
public class Decrypter {
	
	// Correct length: return
	// Incorrect length: continue adding zeroes to the left side of the string
	public static String stuff_w_zeros(String input)	{
		if (input.length() < 4)	{
			return stuff_w_zeros("0" + input);
		}
		else if (input.length() == 4)	{
			return input;
		}
		else	{
			return "";
		}
	}
	
	// Opposite of scheme described in Encrypter
	public static int decrypt(int input)	{
		String inp = Integer.toString(input);
		inp = stuff_w_zeros(inp);
		char pos[] = inp.toCharArray();
		char tmp = pos[0];
		pos[0] = pos[2];
		pos[2] = tmp;
		tmp = pos[1];
		pos[1] = pos[3];
		pos[3] = tmp;
		
		String out = "";
		
		for (int i = 0; i < pos.length; i++)	{
			int newVal = Integer.valueOf(String.valueOf(pos[i]));
			newVal += 3;
			newVal %= 10;
			out += Integer.toString(newVal);
		}
		
		return Integer.parseInt(out);
	}
}
