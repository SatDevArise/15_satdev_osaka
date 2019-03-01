package jp.arise.sij.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * SIJGM001 社員情報一覧表示画面用サービス間Dtoクラス
 * Controller以降の処理での値が格納されるクラス
 * @author AtsushiNishizawa
 * @since 2017/07/17
 * @version ver.1.00 新規作成 2017/11/26 KenshiKouno
 */
public class SIJGM001Dto implements Serializable{

	/** 社員ID */
	private String syainId;
	/** 現場ID **/
	private String genbaId;
	/** 社員名 **/
	private String syainNa;
	/** 社員グループコード **/
	private String syainGroupCd;
	/** 入社日 **/
	private String nyusyaDt;
	/** 現場参画日 **/
	private String genbaSankakuDt;
	/** 役職コード */
	private String yakusyokuCd;
	/** フェーズ区分 */
	private String phaseCd;
	/** 最寄駅1 **/
	private String moyoriEki_1;
	/** 最寄駅2 **/
	private String moyoriEki_2;
	/** 最寄駅3 **/
	private String moyoriEki_3;
	/** 使用路線 */
	private String siyoRosenNa;
	/** 所属チーム */
	private String syozokuTeam;
	/** 生年月日 */
	private String birthDt;
	/** 経過年数 */
	private String keikaYm;
	/** 単価 */
	private BigDecimal tankaVal;
	/** 前職 **/
	private String zensyokuNa;
	/** 住所 **/
	private String syainAddress;
	/** 出身地 **/
	private String syussinNa;
	/** 連絡先 **/
	private String syainRenrakusaki;
	/** 現場名 */
	private String genbaNa;
	/** 有効フラグ **/
	private String yukoFg;
	/** 削除フラグ **/
	private String sakujoFg;
	/** ユーザー **/
	private String user;
	/** 社歴**/
	private String history;

	/**
	 * 社員IDを取得します．
	 * @return syainId
	 */
	public String getSyainId() {
		return syainId;
	}

	/**
	 * 現場IDを取得します．
	 * @return genbaId
	 */
	public String getGenbaId() {
		return genbaId;
	}

	/**
	 * 社員名を取得します．
	 * @return syainNa
	 */
	public String getSyainNa() {
		return syainNa;
	}

	/**
	 * 社員グループコードを取得します．
	 * @return syainGroupCd
	 */
	public String getSyainGroupCd() {
		return syainGroupCd;
	}

	/**
	 * 入社日を取得します．
	 * @return nyusyaDt
	 */
	public String getNyusyaDt() {
		return nyusyaDt;
	}

	/**
	 * 現場参画日を取得します．
	 * @return genbaSankakuDt
	 */
	public String getGenbaSankakuDt() {
		return genbaSankakuDt;
	}

	/**
	 * 役職コードを取得します．
	 * @return yakusyokuCd
	 */
	public String getYakusyokuCd() {
		return yakusyokuCd;
	}

	/**
	 * フェーズ区分を取得します．
	 * @return phaseCd
	 */
	public String getPhaseCd() {
		return phaseCd;
	}

	/**
	 * 最寄駅1を取得します．
	 * @return moyoriEki_1
	 */
	public String getMoyoriEki_1() {
		return moyoriEki_1;
	}

	/**
	 * 最寄駅2を取得します．
	 * @return moyoriEki_2
	 */
	public String getMoyoriEki_2() {
		return moyoriEki_2;
	}

	/**
	 * 最寄駅3を取得します．
	 * @return moyoriEki_3
	 */
	public String getMoyoriEki_3() {
		return moyoriEki_3;
	}

	/**
	 * 使用路線名を取得します．
	 * @return siyoRosenNa
	 */
	public String getSiyoRosenNa() {
		return siyoRosenNa;
	}

	/**
	 * 所属チームを取得します．
	 * @return syozokuTeam
	 */
	public String getSyozokuTeam() {
		return syozokuTeam;
	}

	/**
	 * 生年月日を取得します．
	 * @return birthDt
	 */
	public String getBirthDt() {
		return birthDt;
	}

	/**
	 * 経過年数を取得します．
	 * @return keikaYm
	 */
	public String getKeikaYm() {
		return keikaYm;
	}

	/**
	 * 単価を取得します．
	 * @return tankaVal
	 */
	public BigDecimal getTankaVal() {
		return tankaVal;
	}

	/**
	 * 前職を取得します．
	 * @return zensyokuNa
	 */
	public String getZensyokuNa() {
		return zensyokuNa;
	}

	/**
	 * 住所を取得します．
	 * @return syainAddress
	 */
	public String getSyainAddress() {
		return syainAddress;
	}

	/**
	 * 出身地を取得します．
	 * @return syussinNa
	 */
	public String getSyussinNa() {
		return syussinNa;
	}

	/**
	 * 連絡先を取得します．
	 * @return syainRenrakusaki
	 */
	public String getSyainRenrakusaki() {
		return syainRenrakusaki;
	}

	/**
	 * 現場名を取得します．
	 * @return genbaNa
	 */
	public String getGenbaNa() {
		return genbaNa;
	}

	/**
	 * 有効フラグを取得します．
	 * @return yukoFg
	 */
	public String getYukoFg() {
		return yukoFg;
	}

	/**
	 * 削除フラグを取得します．
	 * @return sakujoFg
	 */
	public String getSakujoFg() {
		return sakujoFg;
	}

	/**
	 * 社員IDを設定します．
	 * @param syainId
	 */
	public void setSyainId(String syainId) {
		this.syainId = syainId;
	}

	/**
	 * 現場IDを設定します．
	 * @param genbaId
	 */
	public void setGenbaId(String genbaId) {
		this.genbaId = genbaId;
	}

	/**
	 * 社員名を設定します．
	 * @param syainNa
	 */
	public void setSyainNa(String syainNa) {
		this.syainNa = syainNa;
	}

	/**
	 * 社員グループコードを設定します．
	 * @param syainGroupCd
	 */
	public void setSyainGroupCd(String syainGroupCd) {
		this.syainGroupCd = syainGroupCd;
	}

	/**
	 * 入社日を設定します．
	 * @param nyusyaDt
	 */
	public void setNyusyaDt(String nyusyaDt) {
		this.nyusyaDt = nyusyaDt;
	}

	/**
	 * 現場参画日を設定します．
	 * @param genbaSankakuDt
	 */
	public void setGenbaSankakuDt(String genbaSankakuDt) {
		this.genbaSankakuDt = genbaSankakuDt;
	}

	/**
	 * 役職コードを設定します．
	 * @param yakusyokuCd セットする yakusyokuCd
	 */
	public void setYakusyokuCd(String yakusyokuCd) {
		this.yakusyokuCd = yakusyokuCd;
	}

	/**
	 * フェーズ区分を設定します．
	 * @param phaseCd
	 */
	public void setPhaseCd(String phaseCd) {
		this.phaseCd = phaseCd;
	}

	/**
	 * 最寄駅1を設定します．
	 * @param moyoriEki_1
	 */
	public void setMoyoriEki_1(String moyoriEki_1) {
		this.moyoriEki_1 = moyoriEki_1;
	}

	/**
	 * 最寄駅2を設定します．
	 * @param moyoriEki_2
	 */
	public void setMoyoriEki_2(String moyoriEki_2) {
		this.moyoriEki_2 = moyoriEki_2;
	}

	/**
	 * 最寄駅3を設定します．
	 * @param moyoriEki_3
	 */
	public void setMoyoriEki_3(String moyoriEki_3) {
		this.moyoriEki_3 = moyoriEki_3;
	}

	/**
	 * 使用路線を設定します．
	 * @param siyoRosenNa
	 */
	public void setSiyoRosenNa(String siyoRosenNa) {
		this.siyoRosenNa = siyoRosenNa;
	}

	/**
	 * 所属チームを設定します．
	 * @param syozokuTeam セットする syozokuTeam
	 */
	public void setSyozokuTeam(String syozokuTeam) {
		this.syozokuTeam = syozokuTeam;
	}

	/**
	 * 生年月日を設定します．
	 * @param birthDt
	 */
	public void setBirthDt(String birthDt) {
		this.birthDt = birthDt;
	}

	/**
	 * 経過年数を設定します．
	 * @param keikaYm
	 */
	public void setKeikaYm(String keikaYm) {
		this.keikaYm = keikaYm;
	}

	/**
	 * 単価を設定します．
	 * @param tankaVal
	 */
	public void setTankaVal(BigDecimal tankaVal) {
		this.tankaVal = tankaVal;
	}

	/**
	 * 前職を設定します．
	 * @param zensyokuNa
	 */
	public void setZensyokuNa(String zensyokuNa) {
		this.zensyokuNa = zensyokuNa;
	}

	/**
	 * 住所を設定します．
	 * @param syainAddress
	 */
	public void setSyainAddress(String syainAddress) {
		this.syainAddress = syainAddress;
	}

	/**
	 * 出身地を設定します．
	 * @param syussinNa
	 */
	public void setSyussinNa(String syussinNa) {
		this.syussinNa = syussinNa;
	}

	/**
	 * 連絡先を設定します．
	 * @param syainRenrakusaki
	 */
	public void setSyainRenrakusaki(String syainRenrakusaki) {
		this.syainRenrakusaki = syainRenrakusaki;
	}

	/**
	 * 現場名を設定します．
	 * @param genbaNa
	 */
	public void setGenbaNa(String genbaNa) {
		this.genbaNa = genbaNa;
	}

	/**
	 * 有効フラグを設定します．
	 * @param yukoFg
	 */
	public void setYukoFg(String yukoFg) {
		this.yukoFg = yukoFg;
	}

	/**
	 * 削除フラグを設定します．
	 * @param sakujoFg
	 */
	public void setSakujoFg(String sakujoFg) {
		this.sakujoFg = sakujoFg;
	}

	/**
	 * ユーザーを取得します
	 * @return
	 */
	public String getUser() {
		return user;
	}

	/**
	 * ユーザーを設定します
	 * @param user
	 */
	public void setUser(String user) {
		this.user = user;
	}

	/**
	 * 社歴を取得します
	 * @return
	 */
	public String getHistory() {
		return history;
	}

	/**
	 * 社歴を設定します
	 * @param history
	 */
	public void setHistory(String history) {
		this.history = history;
	}
}
