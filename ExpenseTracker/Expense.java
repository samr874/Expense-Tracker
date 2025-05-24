import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Expense {
	
	private long expense;
	private String category;
	public Expense() {
		
	}
	
	
	
	public long getExpense() {
		return expense;
	}



	public void setExpense(long expense) {
		this.expense = expense;
	}



	public String getCategory() {
		return category;
	}



	public void setCategory(String category) {
		this.category = category;
	}



	//Add the data in the file
	public void addExpense()
	{// ... (imports and dummy Transaction class if used standalone) ...

try (BufferedWriter writer = new BufferedWriter(new FileWriter("D:\\Alephys - Assignment\\ExpenseIncome.txt", true))) {
    // This 'toCsvString()' method (from your Transaction class)
    // creates the "table structure" (a single row of data separated by commas)
    String saveExpenseLine = this.toString();

    writer.write(saveExpenseLine); // Writes the structured text line to your .txt file
    writer.newLine();             // Adds a new line for the next record
    System.out.println("Transaction written successfully in table format to .txt file: " + saveExpenseLine);
} catch (IOException e) {
    System.err.println("Error writing to file: " + e.getMessage());
    e.printStackTrace();
}
		
		
	}



	@Override
	public String toString() {
		return "Expense [expense=" + expense + ", category=" + category + "]";
	}
	
	
	

}
