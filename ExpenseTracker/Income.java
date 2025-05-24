import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Income implements Serializable{
	
	private long income;
	private String category;
	public Income() {
		
	}
	public long getIncome() {
		return income;
	}
	public void setIncome(long income) {
		this.income = income;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	//save it to the file 
	void saveIncome()
	{
		try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Alephys - Assignment\\ExpenseIncome.txt", true))) {
		    // This 'toCsvString()' method (from your Transaction class)
		    // creates the "table structure" (a single row of data separated by commas)
		    String saveExpenseLine = this.toString();

		    writer.write(saveExpenseLine); // Writes the structured text line to your .txt file
		    writer.newLine();             // Adds a new line for the next record
		    System.out.println("Income saved ");
		} catch (IOException e) {
		    System.err.println("Error writing to file: " + e.getMessage());
		    e.printStackTrace();
		}
		
	}
	
	
	
	@Override
	public String toString() {
		return "Income [income=" + income + ", category=" + category + "]";
	}
	
	
	
	

}
