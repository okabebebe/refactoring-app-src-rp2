package jp.co.sss.crud.util;

/**
 * メッセージをまとめたクラス
 *
 * @author okabe
 *
 */
public class ConstantMsg {
	
	/** インスタンス化を禁止 */
	private ConstantMsg(){
	}
	
	/** メニュー一覧表示 */
	public static final String msgMenuDisplay   = "=== 社員管理システム ===\n"
													+"1.全件表示\n"
													+"2.社員名検索\n"
													+"3.部署ID検索\n"
													+"4.新規登録\n"
													+"5.更新\n"
													+"6.削除\n"
													+"7.終了";	
	
	public static final String msgChoiceMenu	= "メニュー番号を入力してください：";

	public static final String msgEmpName		= "社員名:";

	public static final String msgBirthday		= "生年月日(西暦年/月/日):";

	public static final String msgDeptId		= "部署ID(1:営業部、2:経理部、3:総務部):";
	
	public static final String msgGender		= "性別(0:その他, 1:男性, 2:女性, 9:回答なし):";
	
	public static final String msgInputDeptId	= "部署ID(1:営業部、2:経理部、3:総務部)を入力してください:";
	
	public static final String msgInpuEmpId		= "更新する社員の社員IDを入力してください：";
	
	public static final String msgUpdateEmpDate = "社員情報を更新しました";
	
	public static final String msgDeleteEmpId	= "削除する社員の社員IDを入力してください：";
	
	public static final String msgSystemExit	= "システムを終了します。";
}
