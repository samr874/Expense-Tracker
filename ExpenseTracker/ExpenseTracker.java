import java.util.Scanner;

public class ExpenseTracker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		while(true)
		{
			System.out.println("Welcome!! keep track of all your expenses");
			
			System.out.println("Enter your choice");
			System.out.println("1. Enter the income");
			System.out.println("2. Enter the expense");
			System.out.println("3. Print monthly summary");
			System.out.println("4. Upload the file");
			System.out.println("5. Exit");
			
			
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
			 
			case "summary": ; break;
			
			
			case "file": ; break;
			
			
			
			                
			                
				
			default:  System.out.println("Please enter the correct output");
			  
			}
			
			
		}

	}

}
