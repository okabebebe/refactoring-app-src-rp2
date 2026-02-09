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
	
	
	public static final String MSG_MENU			   = "=== 社員管理システム ===\n"
														+"1.全件表示\n"
														+"2.社員名検索\n"
														+"3.部署ID検索\n"
														+"4.新規登録\n"
														+"5.更新\n"
														+"6.削除\n"
														+"7.終了";	
	
	public static final String MSG_INP_MENU		   = "メニュー番号を入力してください：";

	public static final String MSG_INP_NAME        ="社員名を入力してください:";
	
	public static final String LBL_EMP_NAME		   = "社員名:";

	public static final String LBL_BIRTHDAY		   = "生年月日(西暦年/月/日):";

	public static final String LBL_DEPT_ID		   = "部署ID(1:営業部、2:経理部、3:総務部):";
	
	public static final String LBL_GENDER		   = "性別(0:回答しない, 1:男性, 2:女性, 9:その他)";
	
	public static final String MSG_INP_DEPT_Id	   = "部署ID(1:営業部、2:経理部、3:総務部)を入力してください:";
	
	public static final String MSG_INP_EMP_ID	   = "更新する社員の社員IDを入力してください：";
	
	public static final String MSG_UPD_EMP_DATA	   = "社員情報を更新しました";
	
	public static final String MSG_DEL_EMP_ID	   = "削除する社員の社員IDを入力してください：";
	
	public static final String MSG_SYS_EXIT		   = "システムを終了します。";
		
	/** DBを全件検索した際、該当レコードがなかった場合のメッセージ*/
	public static final String MSG_NONE_EMP		   = "該当者はいませんでした";
	
	public static final String EMP_LIST_HEADER	   = "社員ID\t社員名\t性別\t生年月日\t部署名";
	
	public static final String LBL_GENDER_NON_ANS  = "回答なし";
	
	public static final String LBL_GENDER_MAN	   = "男性";
	
	public static final String LBL_GENDER_WOMAN	   = "女性";
	
	public static final String LBL_GENDER_OTHER	   = "その他";
	
	public static final String LBL_DPT_SALES	   = "営業部";
	
	public static final String LBL_DPT_ACCOUNTING  = "経理部";
	
	public static final String LBL_DPT_GENERAL	   = "総務部";
	
	public static final String MSG_INSERT_EMP_DATA = "社員情報を登録しました";
	
	public static final String MSG_DEL_EMP_DATA	   = "社員情報を削除しました";	
	
	
	public static final String MSG_ERROR ="システムエラーが発生しました";	

}
