package jp.co.sss.crud.service;

import java.io.IOException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByEmpNameService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException,IOException {
		EmployeeDAO employeeDao = new EmployeeDAO();
		
		System.out.print(ConstantMsg.MSG_INP_NAME );
		
		EmployeeNameReader nameReader= new EmployeeNameReader();		
		String inputName = nameReader.input();
		
		List<Employee> employees = employeeDao.findByEmployeeName(inputName);
		ConsoleWriter.showEmployees(employees);
	}

}
