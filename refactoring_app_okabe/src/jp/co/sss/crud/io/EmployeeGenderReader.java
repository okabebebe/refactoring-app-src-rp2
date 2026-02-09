package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeGenderReader {
	
	public Integer input() throws IOException, IllegalArgumentException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Integer genderInteger=0;
		
		String inputString=br.readLine();
		
		if (isValid(inputString)) {
				genderInteger=Integer.parseInt(inputString);
		} else {
			throw new IllegalArgumentException("0,1,2,9の整数を入力してください");
		}
		
		return genderInteger;
	}

	/**
	 * @param inputString コンソール入力された文字列
	 * @return 文字列が適正な値であった場合true、そうでない場合はfalseを返す
	 */
	public boolean isValid(String inputString) {
		//0,1,2,9の整数かどうかを判定
		return (inputString.matches("^[0129０１２９]{1}$"));
	}
	
}
