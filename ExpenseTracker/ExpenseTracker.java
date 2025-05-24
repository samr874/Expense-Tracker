import java.util.Scanner;

public class ExpenseTracker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean wantToContinue = true;
		
		
		while(wantToContinue)
		{
			System.out.println("Welcome!! keep track of all your expenses");
			
			System.out.println("Enter your choice");
			System.out.println("For income type income");
			System.out.println("For expense type expense");
			System.out.println("For summary type summary");
			System.out.println("For exit type exit");
			
			
			String choice = sc.next();
			choice = choice.toLowerCase();
			long incomeAmount,expenseAmount;
			String incomeCategory, expenseCategory;
			
			
			
			switch(choice)
			{
			case "income": Income income = new Income();
			               System.out.println("Enter your income");
			               incomeAmount = sc.nextInt();
			               income.setIncome(incomeAmount);
			               System.out.println("Enter subcategory for the income Salary/Bussiness");
			               incomeCategory = sc.next();
			               income.setCategory(incomeCategory);
			               income.saveIncome();
			               break;
			           
			               
			case "expense": Expense expense = new Expense();
			                System.out.println("Emter your expense");
			                expenseAmount = sc.nextInt();
			                expense.setExpense(expenseAmount);
			                System.out.println("Enter subcategory of expense Food/Rent/Travel");
			                expenseCategory = sc.next();
			                
			                expense.setCategory(expenseCategory);
			                expense.setExpense(expenseAmount);
			                expense.addExpense();
			                
			                break;
			 
			case "summary":  MonthlySummary monthlySummary = new MonthlySummary();
			                 monthlySummary.processFile("D:\\Alephys - Assignment\\ExpenseIncome.txt");
			                 monthlySummary.displaySummary();
			                 break;
			
			
			
			case "exit":       System.out.println("Closing operations");
                               wantToContinue=false;
				                break;
			
			
			
			
			                
			                
				
			default:  System.out.println("Please enter the correct output");
			  
			}
			
			
		}

	}

}
