package jp.co.sss.crud.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class EmployeeBirthdayReader {
	
	public String input() throws IOException, IllegalArgumentException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//誕生日をコンソールで入力
		String inputBirthday = br.readLine();
		
		//正しい日付か判断
		//正しい日付ならif文は実行されない
		if(!isValid(inputBirthday)) {
			throw new IllegalArgumentException("正しい形式(西暦年/月/日)で日付を入力してください");
		}
		return inputBirthday;
	}
	
	public boolean isValid(String inputString) {
		
		//SimpleDateFormatクラスで形式を指定し、setLenient()メソッドで厳密なチェックを設定
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		sdf.setLenient(false);
		
		//正しい日付だとtrueを返し、間違った日付だとfalseを返す
		try {
			//日付の成否をチェック
			//間違った日付だと、ParseExceptionを排出
			sdf.parse(inputString);
			
			return true;
		} catch (ParseException e) {
			return false;
		}
	}

}
