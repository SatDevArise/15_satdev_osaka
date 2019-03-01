package jp.arise.sij.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.arise.code.YakusyokuCd;
import jp.arise.sij.dto.SIJGM001Dto;
import jp.arise.sij.form.SIJGM001Form;
import jp.arise.sij.modelandview.SIJGM001MAV;
import jp.arise.sij.modelandview.SIJGM002MAV;
import jp.arise.sij.service.SIJGM001Servise;
import jp.arise.utl.LoginInfo;
import jp.arise.utl.LoginInfoDto;

/**
 * SIJGM001 社員情報一覧表示画面用コントローラー
 *
 * @author AtsushiNishizawa
 * @since 2017/07/17
 * @version ver.1.00 新規作成 2017/11/26 KenshiKouno
 */
@Controller
public class SIJGM001Controller {

	@Autowired
	public LoginInfo loginInfo;

	@Autowired
	private SIJGM001Servise sijGm001Service;

	@ModelAttribute
	public SIJGM001Form setSIJGM001Form() {
		SIJGM001Form sijGm001Form = new SIJGM001Form();
		return sijGm001Form;
	}

	/**
	 * 初期処理（遷移元：メニュー画面）
	 *
	 * @param model
	 * @return SIJGM001.jsp
	 * @throws @author
	 *             AtsushiNishizawa
	 * @since 2017/07/17
	 */
	@RequestMapping(value = "/initSijGm001", method = RequestMethod.POST)
	public String initSijGm001(Model model) {

		// セッション情報取得
		LoginInfoDto loginInfoDto = new LoginInfoDto();
		loginInfoDto = loginInfo.getAttribute();
		System.out.println(loginInfoDto.getUser_id());

		// 社員情報一覧の取得
		SIJGM001Dto sijgm001Dto = new SIJGM001Dto();
		List<SIJGM001Dto> syainList = sijGm001Service.getSyainListInfo(sijgm001Dto);

		// fromの設定
		List<SIJGM001Form> sijGmForm = setSijgm001FormList(syainList);
		model.addAttribute("SIJGM001Form", sijGmForm);

		return "SIJGM001";
	}

	/**
	 * 初期処理（遷移元：社員情報新規登録・編集画面）
	 *
	 * @param model
	 * @return SIJGM001.jsp
	 * @throws @author
	 *             AtsushiNishizawa
	 * @since 2017/07/17
	 */
	@RequestMapping(value = "/initSijGm001", params = "backSijGm001", method = RequestMethod.POST)
	public String initSijGm001(SIJGM002MAV sijGm002MAV, Model model) {
		// 社員情報一覧の取得
		SIJGM001Dto sijgm001Dto = new SIJGM001Dto();
		List<SIJGM001Dto> syainList = sijGm001Service.getSyainListInfo(sijgm001Dto);

		// fromの設定
		List<SIJGM001Form> sijGmForm = setSijgm001FormList(syainList);
		model.addAttribute("SIJGM001Form", sijGmForm);
		return "SIJGM001";
	}

	/**
	 * 社員情報新規登録・編集画面遷移処理
	 *
	 * @param SIJGM001Form
	 * @return SIJGM002.jsp
	 * @throws @author
	 *             AtsushiNishizawa
	 * @since 2017/07/17
	 */
	@RequestMapping(value = "/initSijGm001", params = "goToSijGm002", method = RequestMethod.POST)
	public ModelAndView goToSijGm002(SIJGM001Form sijGm001Form, Model model) {
		 SIJGM001Dto sijGm001Dto = new SIJGM001Dto();
		 sijGm001Dto.setSyainId(sijGm001Form.getSyainId());

		SIJGM001MAV sijGm001MAV = new SIJGM001MAV();
		BeanUtils.copyProperties(sijGm001Form, sijGm001MAV);
		   sijGm001MAV.setSyainId(sijGm001Form.getSyainId());

		return new ModelAndView("forward:/initSijGm002","SIJGM001MAV",sijGm001MAV);
	}

	/**
	 * 戻る処理（遷移先：メニュー画面）
	 *
	 * @param SIJGM001Form
	 * @return COMGM002Controller.java
	 * @throws @author
	 *             AtsushiNishizawa
	 * @since 2017/07/17
	 */
	@RequestMapping(value = "/initSijGm001", params = "backComGm002", method = RequestMethod.POST)
	public ModelAndView backComGm002(SIJGM001Form sijGm001Form, Model model) {
		// SIJGM001Dto sijGm001Dto = new SIJGM001Dto();
		// sijGm001Dto.setUser_id(sijGm001Form.getUser_id());
		// sijGm001Service.inputCheck(sijGm001Dto);

		SIJGM001MAV sijGm001MAV = new SIJGM001MAV();
		// sijGm001MAV.setUser(sijGm001Form.getUser());

		return new ModelAndView("forward:/initComGm002", "SIJGM001MAV", sijGm001MAV);
	}

	/**
	 * 社員情報リストを設定します。
	 *
	 * @param syainList
	 * @return sijgm001FormList
	 * @throws @author
	 *             KenshiKouno
	 * @since 2017/11/26
	 */
	private List<SIJGM001Form> setSijgm001FormList(List<SIJGM001Dto> syainList) {

 		List<SIJGM001Form> sijgm001FormList = new ArrayList<SIJGM001Form>();

		if (syainList != null) {
			for (int i = 0; i < syainList.size(); i++) {
				SIJGM001Form sijGm001Form = new SIJGM001Form();

				sijGm001Form.setSyainId(syainList.get(i).getSyainId());
				sijGm001Form.setSyainNa(syainList.get(i).getSyainNa());
				// 役職コードは必須にする予定だが、現在必須項目ではないため未入力の場合の対策をする
				if (syainList.get(i).getYakusyokuCd() != null && !"  ".equals(syainList.get(i).getYakusyokuCd())) {
					YakusyokuCd yakusyokuCd = YakusyokuCd.decode(syainList.get(i).getYakusyokuCd());
					sijGm001Form.setYakusyokuNa(yakusyokuCd.getName());
				}
				sijGm001Form.setBirthDt(syainList.get(i).getBirthDt());
				sijGm001Form.setSyozokuTeam(syainList.get(i).getSyozokuTeam());
				sijGm001Form.setGenbaNa(syainList.get(i).getGenbaNa());
//				sijGm001Form.setKeikaYm(syainList.get(i).getKeikaYm());
				sijGm001Form.setPhaseCd(syainList.get(i).getPhaseCd());
				sijGm001Form.setSiyoRosenNa(syainList.get(i).getSiyoRosenNa());
//				sijGm001Form.setHistory(syainList.get(i).getHistory());
				sijGm001Form.setTankaVal(syainList.get(i).getTankaVal());
				sijgm001FormList.add(sijGm001Form);

				// 経過年数を入れる
				if(syainList.get(i).getKeikaYm() != null && !syainList.get(i).getKeikaYm().isEmpty()) {
					String yearDiff = calcDuration(syainList.get(i).getNyusyaDt());
					sijGm001Form.setKeikaYm(yearDiff);
				}

				// 社歴を入れる
				if(syainList.get(i).getHistory() != null && !syainList.get(i).getHistory().isEmpty()) {
					String yearDiff = calcDuration(syainList.get(i).getHistory());
					sijGm001Form.setHistory(yearDiff);
				}


				System.out.println("---------------------------------------------");
				System.out.println("社員ID：" + syainList.get(i).getSyainId());
				System.out.println("社員名：" + syainList.get(i).getSyainNa());
				System.out.println("役職CD：" + syainList.get(i).getYakusyokuCd());
				System.out.println("生年月日：" + syainList.get(i).getBirthDt());
				System.out.println("所属チーム：" + syainList.get(i).getSyozokuTeam());
				System.out.println("現場名：" + syainList.get(i).getGenbaNa());
				System.out.println("経過年数：" + syainList.get(i).getKeikaYm());
				System.out.println("フェーズ区分：" + syainList.get(i).getPhaseCd());
				System.out.println("使用路線：" + syainList.get(i).getSiyoRosenNa());
				System.out.println("社歴：" + syainList.get(i).getHistory());
				System.out.println("単価：" + syainList.get(i).getTankaVal());
				System.out.println("---------------------------------------------");
			}
		}

		return sijgm001FormList;
	}

	/**
	 * 年数を算出するメソッド
	 */
		private String calcDuration(String str) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date dateFrom = null;
			try {
				dateFrom = sdf.parse(str);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			Date currentDate = new Date();

			// 日付をlong値に変換します
			long dateTimeTo = currentDate.getTime();
			long dateTimeFrom = dateFrom.getTime();

			// 差分の日数を算出します
			long dayDiff = (dateTimeTo -dateTimeFrom) / (1000 * 60 * 60 * 24);
			System.out.println("日数：" + dayDiff);
			long yearDiff = dayDiff / 365;
			System.out.println("年数：" + yearDiff);

			return String.valueOf(yearDiff);
		}

}