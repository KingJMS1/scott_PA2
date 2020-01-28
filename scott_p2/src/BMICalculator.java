import java.util.Scanner;

public class BMICalculator {
	
	private double height;
	private double weight;
	private boolean metricUnits;
	private String category;
	private double bmi = -1.0;
	
	// Reads data from the user, returns false if we need to exit
	public boolean readUserData()	{
		Scanner scan = new Scanner(System.in);
		
		this.readUnitType(scan);
		
		if (!this.readMeasurementData(scan))	{
			scan.close();
			return false;
		}
		scan.close();
		return true;
		
	}
	
	// Read in strings until either "metric" or "imperial" are entered
	// Or until we run out of stack frames I guess
	private void readUnitType(Scanner scan)	{
		System.out.println("Please enter either \"Metric\" or \"Imperial\" (without the quotes).");
		String unit = scan.next();
		if (unit.equalsIgnoreCase("Metric"))	{
			this.metricUnits = true;
		}
		else if (unit.equalsIgnoreCase("Imperial"))	{
			this.metricUnits = false;
		}
		else	{
			readUnitType(scan);
		}
		
	}
	
	// Read height and weight, returns false if we are supposed to exit
	private boolean readMeasurementData(Scanner scan)	{
		if (this.metricUnits)	{
			return this.readMetricData(scan);
		}
		else	{
			return this.readImperialData(scan);
		}
		
	}
	
	// Read in metric height and weight
	private boolean readMetricData(Scanner scan)	{
		System.out.println("Please enter your weight in kg: ");
		double weight = scan.nextDouble();
		
		if (weight < 0)	{
			return false;
		}
		
		System.out.println("Please enter your height in meters: ");
		double height = scan.nextDouble();
		
		if (height < 0)	{
			return false;
		}
		
		this.setHeight(height);
		this.setWeight(weight);
		return true;
	}
	
	// Read in imperial height and weight
	private boolean readImperialData(Scanner scan)	{
		System.out.println("Please enter your weight in lbs: ");
		double weight = scan.nextDouble();
		
		if (weight < 0)	{
			return false;
		}
		
		System.out.println("Please enter your height in inches: ");
		double height = scan.nextDouble();
		
		if (height < 0)	{
			return false;
		}
		
		this.setHeight(height);
		this.setWeight(weight);
		return true;
	}
	
	// Use metric/imperial formula to calculate bmi
	public void calculateBmi()	{
		if (this.metricUnits)	{
			this.bmi = this.weight / (this.height * this.height);
		}
		else	{
			this.bmi = (this.weight * 703.00) / (this.height * this.height);
		}
		
		this.calculateBmiCategory();
	}
	
	// Should only be called from calculateBmi
	// Get bmi category from the NHLBI list
	private void calculateBmiCategory()	{
		if (this.bmi < 18.5)	{
			this.category = "Underweight";
		}
		else if (this.bmi < 24.9)	{
			this.category = "Normal weight";
		}
		else if (this.bmi < 29.9)	{
			this.category = "Overweight";
		}
		else	{
			this.category = "Obese";
		}
	}
	
	// Print bmi and category, make sure bmi is calculated
	public void displayBmi()	{
		if (this.bmi < 0)	{
			this.calculateBmi();
		}
		System.out.println("BMI: " + Double.toString(this.bmi));
		System.out.println("Category: " + this.category);
	}
	
	public double getWeight()	{
		return this.weight;
	}
	
	private void setWeight(double weight)	{
		this.weight = weight;
	}
	
	public double getHeight()	{
		return this.height;
	}
	
	private void setHeight(double height)	{
		this.height = height;
	}
	
	public double getBmi()	{
		if (this.bmi < 0)	{
			this.calculateBmi();
		}
		return this.bmi;
	}
	
	public String getBmiCategory()	{
		if (this.bmi < 0)	{
			this.calculateBmi();
		}
		return this.category;
	}
	
	
}
