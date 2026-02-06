package jp.co.sss.crud.util;

/**
 * 設定値をまとめたクラス
 *
 * @author okabe
 *
 */

public class ConstantValue {
	
	/** インスタンス化を禁止 */
	private ConstantValue(){
	}
	
	
	/** メニュー一覧表示にてシステムを終了させる選択肢の番号 */
	public static final int CD_EXIT			  = 7;
	
	public static final int CD_GENDER_NON	  = 0;
	
	public static final int CD_GENDER_MAN	  = 1;
	
	public static final int CD_GENDER_WOMAN	  = 2;
	
	public static final int CD_GENDER_OTHER	  = 9;
	
	public static final int CD_DPT_SALES	  = 1;
	
	public static final int CD_DPT_ACCOUNTING = 2;
	
	public static final int CD_DPT_GENERAL	  = 3;
}
