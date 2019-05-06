package jp.arise.sij.message;

/**
 * SIJ用メッセージ
 * SIJで共通利用されるメッセージ
 * @author AtsushiNishizawa
 * @since 2017/07/17
 */
public enum SIJMessage {

	/**
	 * メッセージID:SIJE001
	 */
	SIJE001("社員IDが未入力です。社員IDを数字4桁で入力してください"),

	/**
	 * * メッセージID:SIJE011
	 */
	SIJE011("社員IDは半角で入力してください。"),

	/**
	 * * メッセージID:SIJE012
	 */
	SIJE012("社員IDは4桁で入力してください。"),

	/**
	 * メッセージID:SIJE002
	 */
	SIJE002("氏名が未入力です。全角で入力してください"),

	/**
	 * * メッセージID:SIJE013
	 */
	SIJE013("氏名は全角で入力してください。"),

	/**
	 * * メッセージID:SIJE012
	 */
	SIJE014("氏名は20桁以内で入力してください。"),

	/**
	 * メッセージID:SIJE003
	 */
	SIJE003("生年月日が未入力です。"),


	/**
	 * メッセージID:SIJE004
	 */
	SIJE004("生年月日は半角，yyyyMMdd形式で入力してください。"),

	/**
	 * メッセージID:SIJE005
	 */
	SIJE005("生年月日は8桁で入力してください。"),

	/**
	 * メッセージID:SIJE006
	 */
	SIJE006("最寄り駅１が未入力です。"),

	/**
	 * * メッセージID:SIJE015
	 */
	SIJE015("最寄り駅１は全角で入力してください。"),

	/**
	 * * メッセージID:SIJE016
	 */
	SIJE016("最寄り駅１は10桁以内で入力してください。"),

	/**
	 * メッセージID:SIJE007
	 */
	SIJE007("最寄り駅2が未入力です。"),

	/**
	 * * メッセージID:SIJE017
	 */
	SIJE017("最寄り駅2は全角で入力してください。"),

	/**
	 * * メッセージID:SIJE018
	 */
	SIJE018("最寄り駅2は10桁以内で入力してください。"),

	/**
	 * メッセージID:SIJE019
	 */
	SIJE0019("最寄り駅3が未入力です。"),

	/**
	 * * メッセージID:SIJE020
	 */
	SIJE020("最寄り駅3は全角で入力してください。"),

	/**
	 * * メッセージID:SIJE021
	 */
	SIJE021("最寄り駅3は10桁以内で入力してください。"),

	/**
	 * メッセージID:SIJE008
	 */
	SIJE008("連絡先が未入力です。"),


	/**
	 * * メッセージID:SIJE008
	 */
	SIJE009("連絡先は半角で入力してください。"),

	/**
	 * * メッセージID:SIJE008
	 */
	SIJE0010("連絡先の桁数が間違えています。"),

	/**
	 * 役職コード：SIJE022
	 */
	SIJE022("役職コードを選択してください。"),


	/**
	 * * メッセージID:SIJE099
	 */
	SIJE0099("既に登録済みです。");




	/**
	 * メッセージ
	 */
	private String message;

	/**
	 * コンストラクタ
	 */
	SIJMessage(String message) {
		this.message = message;
	}

	/**
	 * messageを取得
	 * @return message
	 */
	public String getMessage() {
		return this.message;
	}

}
