package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class EmployeeDeptIdReader {
	
	public Integer input() throws IOException, IllegalArgumentException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//部署IDをコンソール上で入力
		String inputString = br.readLine();
		Integer inputNumber = 0;
		
		if (isValid(inputString)) {
			inputNumber=Integer.parseInt(inputString);
		} else {
			throw new IllegalArgumentException("1以上3以下の整数を入力してください");
		}
		return inputNumber;
	}
	

	public boolean isValid(String inputString) {
		return inputString.matches("^[1-3１-３]{1}$");//1-3までの整数
	}

}
