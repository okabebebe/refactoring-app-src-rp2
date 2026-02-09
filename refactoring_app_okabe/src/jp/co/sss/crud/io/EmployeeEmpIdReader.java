package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeEmpIdReader {
	
	public Integer input() throws IOException, IllegalArgumentException {
BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//部署IDをコンソール上で入力
		String inputString = br.readLine();
		Integer inputNumber = 0;
		
//		入力値のチェックを行う
		if (isValid(inputString)) {
			inputNumber = Integer.parseInt(inputString);			
		} else {
			throw new IllegalArgumentException("1以上9999以下の整数を入力してください");
		}		
		return inputNumber;
	}

	public boolean isValid(String inputString) {
		return inputString.matches("^[1-9１-９]{1}[0-9 ０-９]{0,3}$");//1-9999の整数かどうかを判定
	}

}
