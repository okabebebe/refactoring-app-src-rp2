package jp.co.sss.crud.main;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import jp.co.sss.crud.exception.SystemErrorException;
import jp.co.sss.crud.io.ConsoleWriter;
import jp.co.sss.crud.io.MenuNoReader;
import jp.co.sss.crud.service.IEmployeeService;
import jp.co.sss.crud.util.ConstantValue;

/**
 * 社員情報管理システム開始クラス 社員情報管理システムはこのクラスから始まる。<br/>
 * メニュー画面を表示する。
 *
 * @author System Shared
 *
 */
public class MainSystem {
	
	
	/**
	 * 社員管理システムを起動
	 *
	 * @throws IOException 
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 * @throws ParseException 
	 */
	
	public static void main(String[] args) throws IOException, ClassNotFoundException, SQLException, ParseException{
	
	int menuNo = 0;
	IEmployeeService employeeService;
	
	do {
		try {
			// メニューの表示
			ConsoleWriter.showMenu();
			
			// メニュー番号の入力
			menuNo = MenuNoReader.InputMenuNo();
			
			// 機能の呼出
			switch (menuNo) {
			
			// 全件表示機能
			case 1:
				employeeService = IEmployeeService.getInstanceByMenuNo(menuNo);
				employeeService.execute();
				break;

			// 社員名検索
			case 2:
				employeeService = IEmployeeService.getInstanceByMenuNo(menuNo);
				employeeService.execute();
				break;

			// 部署ID検索
			case 3:				
				employeeService = IEmployeeService.getInstanceByMenuNo(menuNo);
				employeeService.execute();
				break;

			// 登録機能
			case 4:
				employeeService = IEmployeeService.getInstanceByMenuNo(menuNo);
				employeeService.execute();
				break;

			// 更新機能
			case 5:
				employeeService = IEmployeeService.getInstanceByMenuNo(menuNo);
				employeeService.execute();
				break;

			// 削除機能
			case 6:
				employeeService = IEmployeeService.getInstanceByMenuNo(menuNo);
				employeeService.execute();
				break;
			}
		} catch (SystemErrorException e) {
			e.printStackTrace();
			break;
		}
		
		//システム終了
	} while (menuNo != ConstantValue.CD_EXIT);
	MenuNoReader.Close();
	}
}
	
