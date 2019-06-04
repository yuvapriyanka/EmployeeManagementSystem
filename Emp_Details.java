import java.util.ArrayList;
import java.util.Scanner;

public class Emp_Details {
	static ArrayList<String> details = new ArrayList<String>();
	public static boolean validphone(String phone) {
		boolean bool = true;
		if(phone.length()>10 || phone.length()<10) {
			bool = false;
		}
		if(phone.substring(0,1).matches("[^6-9]")) {
			bool = false;
		}
		return bool;
	}
	public static ArrayList add_emp_details(Scanner scan,ArrayList details,int n) {
		for(int i=0;i<n;i++) {
			System.out.println("\nEnter the "+(i+1) +"th employee detail\n");
			String temp = "";
			System.out.println("Enter the employee name");
			String name = scan.next();
			System.out.println("Enter the employee id");
			String id = scan.next();
			System.out.println("Enter the employee age");
			int age = scan.nextInt();
			if(!(age>17 && age<61)) {
				System.out.println("Wrong Age");
				continue;
				
			}
			System.out.println("Enter the employee dob");
			String dob = scan.next();
			System.out.println("Enter the employee phone number");
			String phone = scan.next();
			boolean bool = Emp_Details.validphone(phone);
			if(!bool) {
				System.out.println("It is not valid mobile number");
				continue;
			}
			temp+= name+" "+id+" "+age+" "+dob+" "+phone;
			details.add(temp);
		}
		return details;
	}
	public static void display(ArrayList details) {
		for(int i=0;i<details.size();i++) {
			System.out.println("Employee +(i+1)+");
			String temp = (String)details.get(i);
			String arr[] = temp.split(" ");
			System.out.println("Employee Name :"+arr[0]);
			System.out.println("Employee Id :"+arr[1]);
			System.out.println("Employee Age :"+arr[2]);
			System.out.println("Employee dob :"+arr[3]);
			System.out.println("Employee Phone Number :"+arr[4]);
			System.out.println();
		}
		show();
	}
	public static void show() {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the choice:1.Add employee details\n2.Display employee\n3.exit");
		int choice=scan.nextInt();		
		switch(choice) {
			case 1:
				System.out.println("Enter the number of employee details to be add");
				int no_of_employeeDetails=scan.nextInt();
				details = Emp_Details.add_emp_details(scan,details,no_of_employeeDetails);
				//System.out.println(details.toString());
				show();
				break;
			case 2:
				Emp_Details.display(details);
				break;
			case 3:
				System.out.println("Excecution of program has been end");
				System.exit(0);
		}
	}
	public static void main(String[] args) {
		Emp_Details.show();
		
	}

}
