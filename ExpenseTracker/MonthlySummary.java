import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MonthlySummary {
	 private long totalIncome;
	    private long totalExpense;

	    public MonthlySummary() {
	        this.totalIncome = 0;
	        this.totalExpense = 0;
	    }

	    public void processFile(String fileName) {
	       

	        File dataFile = new File(fileName);

	        if (!dataFile.exists()) {
	            System.err.println("Error: Data file '" + fileName + "' not found at " + dataFile.getAbsolutePath() + ".");
	            System.err.println("Please ensure the file exists and is in the correct location.");
	            return;
	        }

	        try (BufferedReader reader = new BufferedReader(new FileReader(dataFile))) {
	            String line;

	            while ((line = reader.readLine()) != null) {
	                String trimmedLine = line.trim();

	                if (trimmedLine.isEmpty()) {
	                    continue; // Skip empty lines
	                }

	                // Check transaction type and parse the amount
	                if (trimmedLine.startsWith("Expense [expense=")) {
	                    int amountStart = trimmedLine.indexOf("expense=") + "expense=".length();
	                    int amountEnd = trimmedLine.indexOf(",", amountStart);
	                    if (amountEnd == -1) { // Amount might be the last field before ']'
	                         amountEnd = trimmedLine.indexOf("]", amountStart);
	                    }

	                    if (amountStart != -1 && amountEnd != -1 && amountStart < amountEnd) {
	                        try {
	                            double amount = Double.parseDouble(trimmedLine.substring(amountStart, amountEnd));
	                            this.totalExpense += amount;
	                            	                        } catch (NumberFormatException e) {
	                            System.err.println("Skipping line (invalid expense amount format): " + trimmedLine);
	                        }
	                    } else {
	                        System.err.println("Skipping line (malformed expense entry): " + trimmedLine);
	                    }
	                }
	                else if (trimmedLine.startsWith("Income [income=")) {
	                    int amountStart = trimmedLine.indexOf("income=") + "income=".length();
	                    int amountEnd = trimmedLine.indexOf(",", amountStart);
	                    if (amountEnd == -1) { // Amount might be the last field before ']'
	                         amountEnd = trimmedLine.indexOf("]", amountStart);
	                    }

	                    if (amountStart != -1 && amountEnd != -1 && amountStart < amountEnd) {
	                        try {
	                            double amount = Double.parseDouble(trimmedLine.substring(amountStart, amountEnd));
	                            this.totalIncome += amount;
	                           
	                        } catch (NumberFormatException e) {
	                            System.err.println("Skipping line (invalid income amount format): " + trimmedLine);
	                        }
	                    } else {
	                        System.err.println("Skipping line (malformed income entry): " + trimmedLine);
	                    }
	                } else {
	                    System.err.println("Skipping unknown line format: " + trimmedLine);
	                }
	            }
	           
	        } catch (IOException e) {
	            System.err.println("An I/O error occurred while reading the file: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }

	  //Prints the monthly summary
	    public void displaySummary() {
	        System.out.println("\n--- Monthly summary ---");
	        System.out.println("Total Income: "+ this.totalIncome);
	        System.out.println("Total Expense: "+ this.totalExpense);
	        System.out.println("Net Balance: "+(this.totalIncome - this.totalExpense));
	        System.out.println("--------------------------------");
	    }

	    // Optional: Getters to access the calculated totals from outside the class
	    public double getTotalIncome() {
	        return totalIncome;
	    }

	    public double getTotalExpense() {
	        return totalExpense;
	    }

}
