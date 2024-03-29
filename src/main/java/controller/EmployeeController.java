package controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import dao.EmployeeDao;
import dto.Employee;

public class EmployeeController 
{
	public static void main(String[] args) 
	{
		try
		{
			Employee employee=new Employee();
			EmployeeDao dao=new EmployeeDao();
			BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter Your Choice");
			System.out.println("1.Save The Employee");
			System.out.println("2,Update The Employee");
			System.out.println("3,Delete The Employee");
			System.out.println("4.Fetch The Employee");
			System.out.println("5.Fetch All Records");
			int choice=Integer.parseInt(bufferedReader.readLine());
			switch (choice) 
			{
			case 1:
				{
					System.out.println("Enter Employee Name");
					String name=bufferedReader.readLine();
					System.out.println("Enter Employee Id");
					int id=Integer.parseInt(bufferedReader.readLine());
					System.out.println("Enter Employee Address");
					String address=bufferedReader.readLine();
					System.out.println("Enter Employee Email Id");
					String emailId=bufferedReader.readLine();
					System.out.println("Enter Employee phone No");
					String phoneNo=bufferedReader.readLine();
					System.out.println("Enter Salary");
					String salary=bufferedReader.readLine();
					employee.setEmpId(id);
					employee.setEmpName(name);
					employee.setEmpAddress(address);
					employee.setEmpEmailId(emailId);
					employee.setEmpPhoneNo(phoneNo);
					employee.setEmpSalary(salary);
					dao.saveEmployee(employee);
				}
				
				break;
			case 2:
				{
					System.out.println("Enter Employee Id");
					int id=Integer.parseInt(bufferedReader.readLine());
					System.out.println("Enter Employee Name");
					String name=bufferedReader.readLine();
					System.out.println("Enter Employee Address");
					String address=bufferedReader.readLine();
					System.out.println("Enter Employee Email Id");
					String emailId=bufferedReader.readLine();
					System.out.println("Enter Employee phone No");
					String phoneNo=bufferedReader.readLine();
					System.out.println("Enter Salary");
					String salary=bufferedReader.readLine();					
					employee.setEmpName(name);
					employee.setEmpAddress(address);
					employee.setEmpEmailId(emailId);
					employee.setEmpPhoneNo(phoneNo);
					employee.setEmpSalary(salary);
					dao.updateEmployee(id, employee);
				}
				break;
			case 3:
				{
					System.out.println("Enter Employee Id to be deleted");
					int id=Integer.parseInt(bufferedReader.readLine());
					dao.deleteEmployee(id);
				}
				break;
			case 4:
				{
					System.out.println("Enter Employee Id to be display");
					int id=Integer.parseInt(bufferedReader.readLine());
					dao.displayEmployee(id);
				}
				break;
			case 5:
				{
					dao.displayAll();
				}
				break;

			default:
				System.out.println("Invalid Choice");
				break;
			}
		}
		catch (Exception e) {
			// TODO: handle exception
		}
	}
}
