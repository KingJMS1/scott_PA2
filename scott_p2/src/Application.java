
public class Application {
	public static void main(String args[])	{
		BMICalculator calc = new BMICalculator();
		
		boolean success = calc.readUserData();
		if (!success)	{
			return;
		}
		calc.displayBmi();
	}
}
