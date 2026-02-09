package jp.co.sss.crud.service;

import java.io.IOException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeEmpIdReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeDeleteService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IllegalArgumentException, IOException {
		
		EmployeeDAO employeeDao = new EmployeeDAO();
		
		System.out.print(ConstantMsg.MSG_DEL_EMP_ID);
		
		EmployeeEmpIdReader empIdReader= new EmployeeEmpIdReader();
		Integer inputEmpNumber = empIdReader.input();
		
		employeeDao.delete(inputEmpNumber);

	}

}
