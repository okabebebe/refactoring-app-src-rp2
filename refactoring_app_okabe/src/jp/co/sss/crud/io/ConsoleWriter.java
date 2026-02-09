package jp.co.sss.crud.io;

import java.util.List;

import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.util.ConstantMsg;

public class ConsoleWriter {
	
	public static void showMenu() {
		System.out.println(ConstantMsg.MSG_MENU);	
		System.out.print(ConstantMsg.MSG_INP_MENU);		
	}

	public static void showEmployees(List<Employee> employees) {
		
		for (Employee emp : employees) {
			System.out.println(emp);
		}
	}
}
		