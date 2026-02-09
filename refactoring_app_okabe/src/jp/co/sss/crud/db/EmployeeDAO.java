package jp.co.sss.crud.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import jp.co.sss.crud.dto.Department;
import jp.co.sss.crud.dto.Employee;
import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.util.ConstantMsg;
import jp.co.sss.crud.util.ConstantSQL;

public class EmployeeDAO implements IEmployeeDAO {

	@Override
	public List<Employee> findAll() throws SystemErrorException {		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Employee> employees = new ArrayList<>();
		
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_ALL_SELECT);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Employee emp = new Employee();
				Department dept = new Department();
				
				emp.setEmpId(resultSet.getInt("emp_id"));
				emp.setEmpName(resultSet.getString("emp_name"));
				emp.setGender(Integer.parseInt(resultSet.getString("gender")));
				emp.setBirthday(resultSet.getString("birthday"));
				dept.setDeptName(resultSet.getString("dept_name"));
				emp.setDepartment(dept);
				
				employees.add(emp);		
			}	
		} catch (ClassNotFoundException|SQLException e) {
			throw new SystemErrorException(ConstantMsg.MSG_ERROR,e);
		}finally {
			//クローズ処理
			try {
				DBManager.close(resultSet);
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
			
				throw new SystemErrorException(ConstantMsg.MSG_ERROR,e);
			}

		}
		//検索結果が入ったリストを戻り値にする
		return employees;
	}
	
	
	@Override
	public List<Employee> findByEmployeeName(String searchName) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Employee> employees = new ArrayList<>();
		
		try {
			// DBに接続
			connection = DBManager.getConnection();
			
			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_EMP_NAME);

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(sql.toString());
			
			// 検索条件となる値をバインド
			preparedStatement.setString(1, "%" + searchName + "%");

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Employee emp = new Employee();
				Department dept = new Department();
				
				emp.setEmpId(resultSet.getInt("emp_id"));
				emp.setEmpName(resultSet.getString("emp_name"));
				emp.setGender(Integer.parseInt(resultSet.getString("gender")));
				emp.setBirthday(resultSet.getString("birthday"));
				dept.setDeptName(resultSet.getString("dept_name"));
				emp.setDepartment(dept);
				
				employees.add(emp);		
			}	
		} catch (ClassNotFoundException|SQLException e) {			
			throw new SystemErrorException(ConstantMsg.MSG_ERROR,e);			
		}finally {
			//クローズ処理
			try {
				DBManager.close(resultSet);
				DBManager.close(preparedStatement);
				DBManager.close(connection);
			} catch (SQLException e) {
			
				throw new SystemErrorException(ConstantMsg.MSG_ERROR,e);
			}
		}
		//検索結果が入ったリストを戻り値にする
		return employees;
	}
	

	@Override
	public List<Employee> findByDeptId(int deptId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		
		List<Employee> employees = new ArrayList<>();
		
		try {
			// DBに接続
			connection = DBManager.getConnection();
			
			// SQL文を準備
			StringBuffer sql = new StringBuffer(ConstantSQL.SQL_SELECT_BASIC);
			sql.append(ConstantSQL.SQL_SELECT_BY_DEPT_ID);

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(sql.toString());
			
			// 検索条件となる値をバインド
			preparedStatement.setInt(1, deptId);

			// SQL文を実行
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				
				Employee emp = new Employee();
				Department dept = new Department();
				
				emp.setEmpId(resultSet.getInt("emp_id"));
				emp.setEmpName(resultSet.getString("emp_name"));
				emp.setGender(Integer.parseInt(resultSet.getString("gender")));
				emp.setBirthday(resultSet.getString("birthday"));
				dept.setDeptName(resultSet.getString("dept_name"));
				emp.setDepartment(dept);
				
				employees.add(emp);		
			}	
		} catch (ClassNotFoundException|SQLException e) {			
			throw new SystemErrorException(ConstantMsg.MSG_ERROR,e);			
		}finally {
			//クローズ処理
			try {
				
				DBManager.close(resultSet);
				DBManager.close(preparedStatement);
				DBManager.close(connection);
				
			} catch (SQLException e) {
				
				throw new SystemErrorException(ConstantMsg.MSG_ERROR,e);
			}
		}
		//検索結果が入ったリストを戻り値にする
		return employees;
	}
	

	@Override
	public void insert(Employee employee) throws SystemErrorException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			// DBに接続
			connection = DBManager.getConnection();

			// ステートメントを作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_INSERT);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");			
			preparedStatement.setObject(3, sdf.parse(employee.getBirthday()),Types.DATE);
			preparedStatement.setInt(4,employee.getDepartment().getDeptId());

			// SQL文を実行
			preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException|SQLException e) {			
			throw new SystemErrorException(ConstantMsg.MSG_ERROR,e);			
		} finally {			
			
			try {				
				DBManager.close(preparedStatement);
				DBManager.close(connection);				
			} catch (SQLException e) {				
				throw new SystemErrorException(ConstantMsg.MSG_ERROR,e);
			}
		}
	}
	

	@Override
	public Integer update(Employee employee) throws SystemErrorException, ParseException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_UPDATE);

			// 入力値をバインド
			preparedStatement.setString(1, employee.getEmpName());
			preparedStatement.setInt(2, employee.getGender());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");			
			preparedStatement.setObject(3, sdf.parse(employee.getBirthday()), Types.DATE);
			preparedStatement.setInt(4,employee.getDepartment().getDeptId());

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException|SQLException e) {			
			throw new SystemErrorException(ConstantMsg.MSG_ERROR,e);			
		} finally {			
			
			try {				
				DBManager.close(preparedStatement);
				DBManager.close(connection);				
			} catch (SQLException e) {				
				throw new SystemErrorException(ConstantMsg.MSG_ERROR,e);
			}
		}
		return employee.getEmpId();
	}
	

	@Override
	public Integer delete(Integer empId) throws SystemErrorException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			// データベースに接続
			connection = DBManager.getConnection();

			// ステートメントの作成
			preparedStatement = connection.prepareStatement(ConstantSQL.SQL_DELETE);

			// 入力値をバインド
			preparedStatement.setInt(1, empId);

			// SQL文の実行(失敗時は戻り値0)
			preparedStatement.executeUpdate();

		} catch (ClassNotFoundException|SQLException e) {			
			throw new SystemErrorException(ConstantMsg.MSG_ERROR,e);			
		} finally {			
			
			try {				
				DBManager.close(preparedStatement);
				DBManager.close(connection);				
			} catch (SQLException e) {				
				throw new SystemErrorException(ConstantMsg.MSG_ERROR,e);
			}
		}
		return empId;
	}	
}
