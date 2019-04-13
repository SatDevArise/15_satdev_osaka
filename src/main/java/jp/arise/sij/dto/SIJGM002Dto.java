package jp.arise.sij.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * SIJGM002 社員情報新規登録・編集画面用サービス間Dtoクラス
 * Controller以降の処理での値が格納されるクラス
 * @author AtsushiNishizawa
 * @since 2017/07/17
 * @update 山本
 */
public class SIJGM002Dto implements Serializable{

	// ユーザー
	private String user;
	// 社員ID
	private String syain_id;
	// 現場id
	private String genba_id;
	// 社員名
	private String syain_na;
	// 生年月日
	private String birth_dt;
	// 住所
	private String syain_address;
	// 最寄り駅1
	private String moyori_eki_1;
	// 最寄り駅2
	private String moyori_eki_2;
	// 最寄り駅3
	private String moyori_eki_3;
	// 連絡先
	private String syain_renrakusaki;
	// 前職
	private String zensyoku_na;
	// 出身地
	private String syussin_na;
	// 役職
	private String yakusyoku_cd;
	// 入社日
	private String nyusya_dt;
	//チーム名
	private String syozoku_team;
	// フェーズ
	private String phase_cd;
	// 単価
	private Integer tanka_vl;
	//現場名
	private String genba_na;
	// 参画日
	private String genba_sankaku_dt;
	// 検索キー
	private String kensakuKeyList;
	// ページ
	private String page;
	// エラー表示
	private List<String> error_hyoji;
	// 日付
	private Date date;

	/**
	 * ユーザーを取得
	 * @return user
	 */
	public String getUser() {
		return user;
	}

	/**
	 * ユーザーを設定
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * 社員IDを取得
	 * @return syain_id
	 */
	public String getSyain_id() {
		return syain_id;
	}

	/**
	 * 社員IDを設定
	 * @param syain_id
	 */
	public void setSyain_id(String syain_id) {
		this.syain_id = syain_id;
	}

		/**
	 * 社員名を取得
	 * @return syain_na
	 */
	public String getSyain_na() {
		return syain_na;
	}

	/**
	 * 社員名を設定
	 * @param syain_na
	 */
	public void setSyain_na(String syain_na) {
		this.syain_na = syain_na;
	}

		/**
	 * 生年月日を取得
	 * @return birth_dt
	 */
	public String getBirth_dt() {
		return birth_dt;
	}

	/**
	 * 生年月日を設定
	 * @param birth_dt
	 */
	public void setBirth_dt(String birth_dt) {
		this.birth_dt = birth_dt;
	}

	/**
	 * 最寄り駅1を取得
	 * @return moyori_eki_1
	 */
	public String getMoyori_eki_1() {
		return moyori_eki_1;
	}

	/**
	 * 最寄り駅1を設定
	 * @param moyori_eki_1
	 */
	public void setMoyori_eki_1(String moyori_eki_1) {
		this.moyori_eki_1 = moyori_eki_1;
	}

	/**
	 * 最寄り駅2を取得
	 * @return moyori_eki_2
	 */
	public String getMoyori_eki_2() {
		return moyori_eki_2;
	}

	/**
	 * 最寄り駅2を設定
	 * @param moyori_2_station
	 */
	public void setMoyori_eki_2(String moyori_eki_2) {
		this.moyori_eki_2 = moyori_eki_2;
	}

	/**
	 * 最寄り駅3を取得
	 * @return moyori_eki_3
	 */
	public String getMoyori_eki_3() {
		return moyori_eki_3;
	}

	/**
	 * 最寄り駅3を設定
	 * @param moyori_eki_3
	 */
	public void setMoyori_eki_3(String moyori_eki_3) {
		this.moyori_eki_3 = moyori_eki_3;
	}

	/**
	 * 連絡先を取得
	 * @return syain_renrakusaki
	 */
	public String getSyain_renrakusaki() {
		return syain_renrakusaki;
	}

	/**
	 * 連絡先を設定
	 * @param syain_renrakusaki
	 */
	public void setSyain_renrakusaki(String syain_renrakusaki) {
		this.syain_renrakusaki = syain_renrakusaki;
	}

	/**
	 * 前職を取得
	 * @return zensyoku_na
	 */
	public String getzensyoku_na() {
		return zensyoku_na;
	}

	/**
	 * 前職を設定
	 * @param zensyoku_na
	 */
	public void setZensyoku_na(String zensyoku_na) {
		this.zensyoku_na = zensyoku_na;
	}

	/**
	 * 出身地を取得
	 * @return syussin_na
	 */
	public String getSyussin_na() {
		return syussin_na;
	}

	/**
	 * 出身地を設定
	 * @param syussin_na
	 */
	public void setSyussin_na(String syussin_na) {
		this.syussin_na = syussin_na;
	}

	/**
	 * 役職を取得
	 * @return yakusyoku_cd
	 */
	public String getYakusyoku_cd() {
		return yakusyoku_cd;
	}

	/**
	 * 役職を設定
	 * @param yakusyoku_cd
	 */
	public void setYakusyoku_cd(String yakusyoku_cd) {
		this.yakusyoku_cd = yakusyoku_cd;
	}

	/**
	 * 入社日を取得
	 * @return position
	 */
	public String getNyusya_dt() {
		return nyusya_dt;
	}

	/**
	 * 入社日を設定
	 * @param nyusya_dt
	 */
	public void setNyusya_dt(String nyusya_dt) {
		this.nyusya_dt = nyusya_dt;
	}

	/**
	 * チーム名を取得
	 * @return syozoku_team
	 */
	public String getSyozoku_team() {
		return syozoku_team;
	}

	/**
	 * チーム名を設定
	 * @param syozoku_team
	 */
	public void setSyozoku_team(String syozoku_team) {
		this.syozoku_team = syozoku_team;
	}

	/**
	 * フェーズを取得
	 * @return phase_cd
	 */
	public String getPhase_cd() {
		return phase_cd;
	}

	/**
	 * フェーズを設定
	 * @param phase_cd
	 */
	public void setPhase_cd(String phase_cd) {
		this.phase_cd = phase_cd;
	}

	/**
	 * 単価を取得
	 * @return tanka_vl
	 */
	public Integer getTanka_vl() {
		return tanka_vl;
	}

	/**
	 * 単価を設定
	 * @param tanka_vl
	 */
	public void setTanka_vl(Integer tanka_vl) {
		this.tanka_vl = tanka_vl;
	}

	/**
	 * 現場名を取得
	 * @return genba_na
	 */
	public String getGenba_na() {
		return genba_na;
	}

	/**
	 * 現場名を設定
	 * @param genba_na
	 */
	public void setGenba_na(String genba_na) {
		this.genba_na = genba_na;
	}

	/**
	 * 参画日を取得
	 * @return genba_sankaku_dt
	 */
	public String getGenba_sankaku_dt() {
		return genba_sankaku_dt;
	}

	/**
	 * 参画日を設定
	 * @param genba_sankaku_dt
	 */

	public void setGenba_sankaku_dt(String genba_sankaku_dt) {

		this.genba_sankaku_dt = genba_sankaku_dt;
	}

	/**
	 * 検索キーを取得
	 * @return kensakuKeyList
	 */
	public String getKensakuKeyList() {
		return kensakuKeyList;
	}

	/**
	 * 検索キーを設定
	 * @param kensakuKeyList
	 */
	public void setKensakuKeyList(String kensakuKeyList) {
		this.kensakuKeyList = kensakuKeyList;
	}

	/**
	 * ページを取得
	 * @return page
	 */
	public String getPage() {
		return page;
	}

	/**
	 * ページを設定
	 * @param page
	 */
	public void setPage(String page) {
		this.page = page;
	}

	/**
	 * エラー表示を取得
	 *@param error_hyoji
	 */

	public List<String> getError_hyoji() {
		return error_hyoji;
	}

	/**
	 * エラー表示を設定
	 * @param error_hyoji
	 */
	public void setError_hyoji(List<String> error_hyoji) {
		this.error_hyoji = error_hyoji;
	}

	/**
	 * 現場IDを取得
	 * @return genba_id
	 */
	public String getGenba_id() {
		return genba_id;
	}

	/**
	 *  現場IDを設定
	 * @param genba_id
	 */
	public void setGenba_id(String genba_id) {
		this.genba_id = genba_id;
	}

	/**
	 * 日付を取得
	 * @return date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * 日付を設定
	 * @param date
	 */
	public void setDate(Date date) {
		this.date = date;
	}

	/**
	 * 住所を取得
	 * @return
	 */
	public String getSyain_address() {
		return syain_address;
	}

	/**
	 * 住所を設定
	 * @param syain_address
	 */
	public void setSyain_address(String syain_address) {
		this.syain_address = syain_address;
	}
}
