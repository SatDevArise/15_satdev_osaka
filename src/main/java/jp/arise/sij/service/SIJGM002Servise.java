package jp.arise.sij.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import jp.arise.sij.dao.SIJGM002Dao;
import jp.arise.sij.dto.SIJGM002Dto;
import jp.arise.sij.message.SIJMessage;
import jp.arise.utl.LoginInfo;
import jp.arise.utl.UTLContent;

/**
 * SIJGM002 社員情報新規登録・編集画面用サービス
 *
 * @author AtsushiNishizawa
 * @since 2017/07/17
 */
@Service
public class SIJGM002Servise {

	@Autowired
	private SIJGM002Dao sijGm002Dao;

	@Autowired
	private LoginInfo loginInfo;

	/**
	 * 社員ID採番処理
	 */
	public String getSyainId() {
		// 採番ID取得
		String syainId = sijGm002Dao.getSyainId();

		// 社員IDが取得できなかったら
		String result = "0001";
		if (syainId == "0001" || syainId == null || syainId.isEmpty()) {
			return result;
		}
		// DBで取得した値の不要な空白除去
		syainId = syainId.replaceAll(" ", "");

		// 最新の社員IDを１インクリメントする
		syainId = String.valueOf(Integer.parseInt(syainId) + 1);

		if (syainId.length() == 1) {
			return "000" + syainId;
		} else if (syainId.length() == 2) {
			return "00" + syainId;
		} else if (syainId.length() == 3) {
			return "000" + syainId;
		}

		return syainId;
	}

	/**
	 * 現場ID採番処理
	 * @return genba_id
	 */
	public String getGenbaId() {
		// 採番ID取得
		String genbaId = sijGm002Dao.getGenbaId();

		// 現場IDが取得できなかったら
		String result = "0001";
		if (genbaId == null || genbaId.isEmpty()) {
			return result;
		}
		//DBで取得した値の不要な空白除去
		genbaId = genbaId.replaceAll(" ","");

		// 最新の現場IDを１インクリメントする
		genbaId = String.valueOf(Integer.parseInt(genbaId) + 1);

		if (genbaId.length() == 1) {
			return "000" + genbaId;
		} else if (genbaId.length() == 2) {
			return "00" + genbaId;
		} else if (genbaId.length() == 3) {
			return "000" + genbaId;
		}
		return genbaId;
	}

	/**
	 * 社員情報取得処理
	 * @param dto
	 * @return dto
	 */
	public SIJGM002Dto getSyain_info(String syain_id) {
		List<SIJGM002Dto> resultList = sijGm002Dao.getSyain_info(syain_id);
		SIJGM002Dto sijGm002Dto = new SIJGM002Dto();
		for(SIJGM002Dto result:resultList) {
			sijGm002Dto = result;
		}
		return sijGm002Dto;
	}

//	// 社員情報新規情報登録処理
	public SIJGM002Dto insertSyainInfo(SIJGM002Dto dto){

		sijGm002Dao.insertSyainInfo(dto);

		sijGm002Dao.insertSeq(dto);

		return dto;
	}

		/**
		 * 社員情報更新処理
		 */
		public SIJGM002Dto updateSyainInfo(SIJGM002Dto dto) {

			sijGm002Dao.upSyainInfo(dto);

		return dto;
		}

		/**
		 * 社員情報削除処理
		 *
		 * @param SIJGM002Dto
		 * @return SIJGM002Dto
		 *
		 */
		public SIJGM002Dto delSyainInfo(SIJGM002Dto dto){
			sijGm002Dao.delSyainInfo(dto);

//			//セッション情報設定処理
//			SIJGM002Dto sijGm002Dto = new SIJGM002Dto();
//			sijGm002Dto.setSyain_id(dto.getSyain_id());
//			sijGm002Dto.setSyain_na(dto.getSyain_na());

			return dto;
		}



		/**
		 * 入力チェック
		 * @param SIJGM002Dto
		 * @return -
		 * @author SyoriMori
		 */
		public SIJGM002Dto inputCheck(SIJGM002Dto dto) {
		List<String> resultMessage = new ArrayList<String>();

		// 氏名：必須入力チェック
		if (StringUtils.isEmpty(dto.getSyain_na())) {
			 resultMessage.add(SIJMessage.SIJE002.getMessage());
		} else {
			// 氏名：全角文字チェック
			if (patternCheck(dto.getSyain_na())) {
				resultMessage.add(SIJMessage.SIJE013.getMessage());
			}
			// 氏名：桁数チェック
			System.out.println(dto.getSyain_na());
			if (!digitCheck(dto.getSyain_na(), UTLContent.TWENTY)) {
				resultMessage.add(SIJMessage.SIJE014.getMessage());
			}
		}

		// 生年月日：必須入力チェック
		if (StringUtils.isEmpty(dto.getBirth_dt())) {
			   resultMessage.add(SIJMessage.SIJE003.getMessage());
		} else {
			// 生年月日：半角文字チェック
			if (!patternCheck(dto.getBirth_dt())) {
				resultMessage.add(SIJMessage.SIJE004.getMessage());
			}
			// 生年月日：桁数チェック
			if (!digitCheck(dto.getBirth_dt(), UTLContent.INT_EIGHT)) {
				resultMessage.add(SIJMessage.SIJE005.getMessage());
			}
		}
		// 最寄り駅1：必須入力チェック
		if (StringUtils.isEmpty(dto.getMoyori_eki_1())) {
			 resultMessage.add(SIJMessage.SIJE006.getMessage());
		} else {
			// 最寄り駅1：全角文字チェック
			if (patternCheck(dto.getMoyori_eki_1())) {
				resultMessage.add(SIJMessage.SIJE015.getMessage());
			}
			// 最寄り駅1：桁数チェック
			if (!digitCheck(dto.getMoyori_eki_1(), UTLContent.INT_TEN)) {
				resultMessage.add(SIJMessage.SIJE016.getMessage());
			}
		}

		// 最寄り駅2：必須入力チェック
		if ((StringUtils.isEmpty(dto.getMoyori_eki_1()) && !StringUtils.isEmpty(dto.getMoyori_eki_2())) ||
				(StringUtils.isEmpty(dto.getMoyori_eki_1()) && !StringUtils.isEmpty(dto.getMoyori_eki_2()) && StringUtils.isEmpty(dto.getMoyori_eki_3()))) {
			 resultMessage.add(SIJMessage.SIJE007.getMessage());
		} else {
			// 最寄り駅2：全角文字チェック
			if (patternCheck(dto.getMoyori_eki_2())) {
				resultMessage.add(SIJMessage.SIJE017.getMessage());
			}
			// 最寄り駅2：桁数チェック
			if (!digitCheck(dto.getMoyori_eki_2(), UTLContent.INT_EIGHT)) {
				resultMessage.add(SIJMessage.SIJE018.getMessage());
			}
		}

		// 最寄り駅3：必須入力チェック
		if (StringUtils.isEmpty(dto.getMoyori_eki_1()) && StringUtils.isEmpty(dto.getMoyori_eki_2()) && StringUtils.isEmpty(dto.getMoyori_eki_3())) {
			 resultMessage.add(SIJMessage.SIJE007.getMessage());
		} else {
			// 最寄り駅2：全角文字チェック
			if (patternCheck(dto.getMoyori_eki_3())) {
				resultMessage.add(SIJMessage.SIJE017.getMessage());
			}
			// 最寄り駅2：桁数チェック
			if (!digitCheck(dto.getMoyori_eki_3(), UTLContent.INT_EIGHT)) {
				resultMessage.add(SIJMessage.SIJE018.getMessage());
			}
		}

			// 役職コード：半角文字チェック
			if (!patternCheck(dto.getYakusyoku_cd())) {
				resultMessage.add(SIJMessage.SIJE022.getMessage());
			}


		// 連絡先：必須入力チェック
		if (StringUtils.isEmpty(dto.getSyain_renrakusaki())) {
			 resultMessage.add(SIJMessage.SIJE008.getMessage());
		} else {
			// 連絡先：半角文字チェック
			if (!patternCheck(dto.getSyain_renrakusaki())) {
				resultMessage.add(SIJMessage.SIJE009.getMessage());
			}
			// 連絡先：桁数チェック
			if (!digitCheck(dto.getSyain_renrakusaki(), UTLContent.INT_EIGHT)) {
				resultMessage.add(SIJMessage.SIJE0010.getMessage());
			}
		}



//		// 重複チェック
//		if(!StringUtils.isEmpty(dto.getSyain_id()) && StringUtils.quote(getSyainId()) {
//			resultMessage.add(SIJMessage.SIJE0099.getMessage());
//			dto.setError_hyoji(resultMessage);
//			return dto;
//
//		}
			dto.setError_hyoji(resultMessage);

			return dto;
		}




	/**
	 * 半角文字チェック
	 *
	 * @param String
	 * @return true:OK false:NG
	 * @suthor Masashi.Yamamoto
	 */
	private boolean patternCheck(String str) {
		if (!str.matches("^[0-9A-Za-z]+$")) {
			return false;
		}
		return true;
	}



	/**
	 * 桁数チェック
	 *
	 * @param String,int
	 * @return true:OK false:NG
	 * @author MasashiYamamoto
	 */
	private boolean digitCheck(String str, int digit) {
		System.out.println(digit);
		System.out.println(str.length());
		if (!(digit >= str.length())) {
			return false;
		}
		return true;
	}

	/*
	 *  画面IDを更新する処理
	 */
	public void upSession(String gamenId) {
		loginInfo.updateAttributeGamenId(gamenId);
	}
}

