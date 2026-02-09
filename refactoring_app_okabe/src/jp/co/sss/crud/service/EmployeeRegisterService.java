package jp.co.sss.crud.service;

import java.io.IOException;
import java.text.ParseException;

import jp.co.sss.crud.db.EmployeeDAO;
import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.EmployeeBirthdayReader;
import jp.co.sss.crud.io.EmployeeDeptIdReader;
import jp.co.sss.crud.io.EmployeeGenderReader;
import jp.co.sss.crud.io.EmployeeNameReader;
import jp.co.sss.crud.util.ConstantMsg;

public class EmployeeRegisterService implements IEmployeeService {

	@Override
	public void execute() throws SystemErrorException, IOException,ParseException {
		
		Employee employee = new Employee ();
		Department department = new Department();
		EmployeeDAO employeeDao = new EmployeeDAO();
		
		System.out.print(ConstantMsg.LBL_EMP_NAME);
		EmployeeNameReader nameReader= new EmployeeNameReader();		
		employee.setEmpName(nameReader.input());
		
		System.out.print(ConstantMsg.LBL_GENDER);
		EmployeeGenderReader genderReader= new EmployeeGenderReader();		
		employee.setGender(genderReader.input());
		
		System.out.print(ConstantMsg.LBL_BIRTHDAY);
		EmployeeBirthdayReader birthdayReader= new EmployeeBirthdayReader();		
		employee.setBirthday(birthdayReader.input());
		
		System.out.print(ConstantMsg.LBL_DEPT_ID);
		EmployeeDeptIdReader dptIdReader= new EmployeeDeptIdReader();		
		department.setDeptId(dptIdReader.input());
		employee.setDepartment(department);
		
		employeeDao.insert(employee);		
		}
		
}
