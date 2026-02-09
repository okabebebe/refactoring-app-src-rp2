package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeNameReader {
	
	public String input() throws IOException, IllegalArgumentException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//社員名をコンソール上で入力
		String empName = br.readLine();
		
		if (isValid(empName) == false) {
			throw new IllegalArgumentException("1文字以上30文字以下の文字列を入力してください");
		}
		
		return empName;
	}
	
	/**
	 * @param inputString コンソール入力された文字列
	 * @return 文字列が適正な値であった場合true、そうでない場合はfalseを返す
	 */
	public boolean isValid(String inputString) {
		return (inputString.length() >=1 && inputString.length() <=30) && !inputString.isBlank();
	}

}
