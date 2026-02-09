package jp.co.sss.crud.service;

import java.io.IOException;
import java.util.List;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeFindByDeptIdService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IOException {
		EmployeeDAO employeeDao = new EmployeeDAO();
		
		System.out.print(ConstantMsg.MSG_INP_DEPT_Id);
		EmployeeDeptIdReader dptIdReader= new EmployeeDeptIdReader();		
		Integer inputdptNumber = dptIdReader.input();
		
		List<Employee> employees = employeeDao.findByDeptId(inputdptNumber);
		ConsoleWriter.showEmployees(employees);

	}

}
