package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import jp.co.sss.crud.util.ConstantMsg;

public class MenuNoReader {

	public static int InputMenuNo() throws IOException, IllegalArgumentException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Integer inputNumber = 0;
		
		String inputString = br.readLine();

		//入力値が適正な値か判定する
		if (isValid(inputString)) {
			inputNumber = Integer.parseInt(inputString);
		} else {
			//入力値が不正な場合は例外(IllegalArgumentException)を送出する
			throw new IllegalArgumentException("1以上7以下の整数を入力してください");
		}
		return inputNumber;
	}

	public static boolean isValid(String inputString) {
		return inputString.matches("^[1-7１-７]{1}$");//1-7までの整数
	}

	public static void Close() {
		System.out.println(ConstantMsg.MSG_SYS_EXIT);
		
	}
}

