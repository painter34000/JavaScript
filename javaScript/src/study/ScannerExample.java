package study;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Employee {
	private String firstName;
	private int salary;

	public Employee(String firstName, int salary) {
		super();
		this.firstName = firstName;
		this.salary = salary;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {

		return "Employee [firstName=" + firstName + ", salary=" + salary + "]";
	}

}

public class ScannerExample {
	static List<Employee> list = new ArrayList<>(); // List 는 Employee의 타입을 받아온다

	public static Connection getConnection() {

		Connection conn = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static void inputEmp(Employee emp) { // 메소드
		Connection con = getConnection();
		String sql = "insert into emps values (?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setString(1, emp.getFirstName());
			pstmt.setInt(2, emp.getSalary());
			int r = pstmt.executeUpdate();
			System.out.println(r + "건 입력됨.");

		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

//		list.add(emp);

	}

	public static List<Employee> getEmpList() {
		Connection con = getConnection();
		String sql = "select first_name, salary from emps";
		List<Employee> list = new ArrayList<>();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new Employee(rs.getString("first_name"), rs.getInt("salary")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void delEmplist(String d) {
		Connection conn = getConnection();
		String sql = "delete from emps where first_name = ?";
		
		try {
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, d);
			
			ResultSet r = pstmt.executeQuery();
			System.out.println(r + "건이 삭제됨");

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
//		Employee emp = new Employee("Hong", 1000);
////	    List<Employee> list = new ArrayList<>(); // List 는 Employee의 타입을 받아온다
//		list.add(emp); // List 는 복수(다수)의 타입을 받기위해 쓴다
//		list.add(new Employee("Hwang", 2000));

		Scanner scn = new Scanner(System.in); // Scanner 입력값을 받음
		int menu = 0;
		while (true) {
			System.out.println("1.입력 , 2.출력, 3.삭제 , 4.종료");
			menu = scn.nextInt();
			scn.nextLine();

			if (menu == 1) {
				System.out.println("이름입력");
				String name = scn.nextLine();
				System.out.println("연봉입력");
				int salary = scn.nextInt();
				Employee emps = new Employee(name, salary);
				inputEmp(emps); // 한건 입력 처리
//				list.add(new Employee(name, salary));

			} else if (menu == 2) {
				List<Employee> returnList = getEmpList();
				for (Employee emps : returnList)
					System.out.println(emps.toString());

			} else if (menu == 3) {
				System.out.println("지울 사람 입력:");
				String dd = scn.nextLine();
				delEmplist(dd);

			} else if (menu == 4) {
				break;
			}
		}
		scn.close(); // return 해준다는 의미

//		List<String> strList = new ArrayList<>();  //List안에 String 타입을 받을꺼다~
//		strList.add("Hellow");
//		strList.add(new String ("Nice"));
//		
//		List<Int> intList = new ArrayList<>(); // List안에 Int 타입을 받을꺼다!
//		intList.add("2000");
//		intList.add(new int ("4000"));
//		// <> 제네릭은 다양한 타입을 다 받을 수 있다. 하지만 쓸때는  하나의 타입을 정해서 선언해준 후 사용한다.
//		
//		Map<String, Integer> map = new HashMap<String, Integer>();
//		map.put("Hello", 10);
//		map.put("Hello", 20);
//		//<> 제네릭에 다양한 타입을 받기 위해 Map 을 사용할수 있다
////		System.out.println("이름은 : "+emp.getFirstName()+"연봉은 : "+emp.getSalary());
////		
////		emp.setFirstName("Hwang");
////		emp.setSalary(2000);
////		System.out.println("이름은 : "+emp.getFirstName()+"연봉은 : "+emp.getSalary());
////		
////		
	}

}
