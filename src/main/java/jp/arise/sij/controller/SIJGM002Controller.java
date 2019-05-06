package jp.arise.sij.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jp.arise.com.modelandview.COMGM002MAV;
import jp.arise.sij.dto.SIJGM002Dto;
import jp.arise.sij.form.SIJGM002Form;
import jp.arise.sij.message.SIJMessage;
import jp.arise.sij.modelandview.SIJGM002MAV;
import jp.arise.sij.service.SIJGM002Servise;
import jp.arise.utl.LoginInfo;
import jp.arise.utl.LoginInfoDto;
import jp.arise.utl.UTLContent;

/**
 * SIJGM002 社員情報新規登録・編集画面用コントローラー
 * @author AtsushiNishizawa
 * @since 2017/07/17
 */
@Controller
public class SIJGM002Controller {

	@Autowired
	public LoginInfo loginInfo;


	public SIJGM002MAV sijGm002MAV = new SIJGM002MAV();


	@Autowired
	private SIJGM002Servise sijGm002Service;

    @ModelAttribute
    public SIJGM002Form setSijGm002Form() {
    	SIJGM002Form sijGm002Form = new SIJGM002Form();
        return sijGm002Form;
    }

	/**
	 * 初期処理（遷移元：メニュー画面）
	 * @param model
	 * @return SIJGM002.jsp
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/17
	 */
	@RequestMapping(value = "/initSijGm002",params = "goSijGm002", method = RequestMethod.POST)
	public String initSijGm002(COMGM002MAV comGm002MAV,Model model) {
//    	//画面ID更新処理
		sijGm002Service.upSession(UTLContent.GMID_COMGM002);

		//ログイン情報取得
		LoginInfoDto loginInfoDto = new LoginInfoDto();
		loginInfoDto = loginInfo.getAttribute();
		System.out.println(loginInfoDto.getUser_na());

		//社員ID情報取得
		SIJGM002Dto sijgm002Dto = new SIJGM002Dto();
		BeanUtils.copyProperties(sijgm002Dto, sijGm002Service);

		//Formを生成
		SIJGM002Form sijGm002Form = new SIJGM002Form();

		// Serviceクラスの社員ID採番処理を呼び出す
		String syainId = sijGm002Service.getSyainId();

		// Serviceクラスの現場ID採番処理を呼び出す
		String genbaId = sijGm002Service.getGenbaId();

		//Formに社員ID・現場IDをセット
		sijGm002Form.setSyain_id(syainId);
		sijGm002Form.setGenba_id(genbaId);

		//Formにユーザを設定
		sijGm002Form.setUser((String) loginInfoDto.getUser_na());
		model.addAttribute("SIJGM002Form",sijGm002Form);
		return "SIJGM002";
	}

	/**
	 * 初期処理（遷移元：社員情報一覧表示画面<）
	 * @param model
	 * @return SIJGM002.jsp
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/17
	 */
	@RequestMapping(value = "/SIJGM002",method = RequestMethod.GET)
	public String initSijGm002(@RequestParam("syainId") String syainId,Model model) {
		// 画面ID更新処理
		sijGm002Service.upSession(UTLContent.GMID_SIJGM001);

		// GETパラメータから社員情報を取得
		SIJGM002Dto sijGm002Dto = sijGm002Service.getSyain_info(syainId);

		// FormにSIJGM001MAVの情報を設定
		SIJGM002Form sijgm002Form = setSijGm002Form(sijGm002Dto);

		model.addAttribute("SIJGM002Form",sijgm002Form);
		return "SIJGM002";
	}

	/**
	 * 初期処理(新規作成・更新後)
	 * @param model
	 * @return SIJGM002.jsp
	 * @throws
	 * @author MasashiYamamoto
	 * @since 2018/08/23
	 */
	@RequestMapping(value = "/reInitSijGm002", method = RequestMethod.POST)
	public String reinitSijGm002(Model model) {
			//社員ID情報取得
				SIJGM002Dto sijgm002Dto = new SIJGM002Dto();
				BeanUtils.copyProperties(sijgm002Dto, sijGm002Service);

				//ログイン情報取得
				LoginInfoDto loginInfoDto = new LoginInfoDto();
				loginInfoDto = loginInfo.getAttribute();
				System.out.println(loginInfoDto.getUser_id());

				//Formを生成
				SIJGM002Form sijGm002Form = new SIJGM002Form();

				// Serviceクラスの社員ID採番処理を呼び出す
				String syainId = sijGm002Service.getSyainId();

				// Serviceクラスの現場ID採番処理を呼び出す
				String genbaId = sijGm002Service.getGenbaId();

				//Formに社員ID・現場IDをセット
				sijGm002Form.setSyain_id(syainId);
//				sijGm002Form.setGenba_id(genbaId);

				//Formにユーザを設定
				sijGm002Form.setUser((String) loginInfoDto.getUser_id());
				model.addAttribute("SIJGM002Form",sijGm002Form);

		return "SIJGM002";
	}

	/**
	 * エラー画面表示
	 * @param model
	 * @return SIJGM002.jsp
	 * @throws
	 * @author SyoriMori
	 * @since 2018/03/11
	 *
	 */
	@RequestMapping(value = "/sijMessage", method = RequestMethod.POST)
	public String sijMessage(Model model) {
    	SIJGM002Form sijGm002Form = new SIJGM002Form();
		BeanUtils.copyProperties(sijGm002MAV, sijGm002Form);
		model.addAttribute("SIJGM002Form",sijGm002Form);

		return "SIJGM002";
	}

	/**
	 * 新規登録処理
	 * @param SIJGM002Form
	 * @return SIJGM002.jsp
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/177
	 */
	@RequestMapping(value = "/initSijGm002",params = "entrySijGm002", method = RequestMethod.POST)
	public ModelAndView entrySijGm002(SIJGM002Form sijGm002Form,Model model) {
		//フォームの値をDtoへコピー
		SIJGM002Dto sijGm002Dto = new SIJGM002Dto();
		BeanUtils.copyProperties(sijGm002Form,sijGm002Dto);

		//入力チェック処理
		sijGm002Service.inputCheck(sijGm002Dto);
		if(!sijGm002Dto.getError_hyoji().isEmpty()) {
			BeanUtils.copyProperties(sijGm002Dto,sijGm002MAV);
			return new ModelAndView("forward:/sijMessage","initSijGm002",sijGm002MAV);
		}
		sijGm002Service.insertSyainInfo(sijGm002Dto);
		BeanUtils.copyProperties(sijGm002Dto,sijGm002MAV);
		return new ModelAndView("forward:/reInitSijGm002","COMGM001MAV",sijGm002MAV);
//		return "SIJGM002";
	}

	/**
	 * 更新処理
	 * @param SIJGM002Form
	 * @return SIJGM002.jsp
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/177
	 */

	@RequestMapping(value = "/initSijGm002",params = "updateSijGm002", method = RequestMethod.POST)
	public ModelAndView updateSijGm002(SIJGM002Form sijGm002Form,Model model) {
		//フォームの値をDtoへコピー
		SIJGM002Dto sijGm002Dto = setSijGm002dto(sijGm002Form);

		//入力チェック処理
		sijGm002Service.inputCheck(sijGm002Dto);
		if(!sijGm002Dto.getError_hyoji().isEmpty()) {
			BeanUtils.copyProperties(sijGm002Dto,sijGm002MAV);
			return new ModelAndView("forward:/sijMessage","initSijGm002",sijGm002MAV);
		}
		//更新処理
//		sijGm002Dto = sijGm002Service.updateSyainInfo(sijGm002Dto);
		sijGm002Service.updateSyainInfo(sijGm002Dto);
		if(!sijGm002Dto.getError_hyoji().isEmpty()) {
			List<String> resultMessage = new ArrayList<String>();
			resultMessage.add(SIJMessage.SIJE001.getMessage());
			resultMessage.add(SIJMessage.SIJE002.getMessage());
			resultMessage.add(SIJMessage.SIJE003.getMessage());
			resultMessage.add(SIJMessage.SIJE004.getMessage());
			resultMessage.add(SIJMessage.SIJE005.getMessage());
			resultMessage.add(SIJMessage.SIJE006.getMessage());
			resultMessage.add(SIJMessage.SIJE007.getMessage());
			resultMessage.add(SIJMessage.SIJE008.getMessage());
			resultMessage.add(SIJMessage.SIJE009.getMessage());
			resultMessage.add(SIJMessage.SIJE0010.getMessage());
			resultMessage.add(SIJMessage.SIJE011.getMessage());
			resultMessage.add(SIJMessage.SIJE012.getMessage());
			resultMessage.add(SIJMessage.SIJE013.getMessage());
			resultMessage.add(SIJMessage.SIJE014.getMessage());
			resultMessage.add(SIJMessage.SIJE015.getMessage());
			resultMessage.add(SIJMessage.SIJE016.getMessage());
			resultMessage.add(SIJMessage.SIJE017.getMessage());
			resultMessage.add(SIJMessage.SIJE018.getMessage());
			resultMessage.add(SIJMessage.SIJE0019.getMessage());
			resultMessage.add(SIJMessage.SIJE020.getMessage());
			resultMessage.add(SIJMessage.SIJE021.getMessage());
			sijGm002Dto.setError_hyoji(resultMessage);
			sijGm002MAV.setError_hyoji(resultMessage);
			BeanUtils.copyProperties(sijGm002Dto,sijGm002MAV);
			return new ModelAndView("forward:/sijMessage","SIJGM002MAV",sijGm002MAV);
		}
		BeanUtils.copyProperties(sijGm002Dto,sijGm002MAV);
		return new ModelAndView("forward:/initSijGm001","SIJGM002MAV",sijGm002MAV);
//		return "SIJGM002";
	}

	/**
	 * 削除処理
	 * @param SIJGM002Form
	 * @return SIJGM002.jsp
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/17
	 */
	@RequestMapping(value = "/initSijGm002",params = "deleteSijGm002", method = RequestMethod.POST)
	public ModelAndView deleteSijGm002(SIJGM002Form sijGm002Form,Model model) {
		//フォームの値をDtoへコピー
		SIJGM002Dto sijGm002Dto = setSijGm002dto(sijGm002Form);

		//削除処理
		sijGm002Service.delSyainInfo(sijGm002Dto);
			return new ModelAndView("forward:/initSijGm001","SIJGM002MAV",sijGm002MAV);
	}

	/**
	 * 戻る処理（遷移先：メニュー画面・社員情報一覧画面）
	 * @param SIJGM002Form
	 * @return COMGM002Controller.java
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/17
	 */
	@RequestMapping(value = "/initSijGm002",params = "backComGm002", method = RequestMethod.POST)
	public ModelAndView back(SIJGM002Form sijGm002Form,Model model){
		// ログイン情報取得
		LoginInfoDto loginInfoDto = new LoginInfoDto();
		loginInfoDto = loginInfo.getAttribute();

		// セッション情報の遷移元画面を取得
		String strGamenId = (String) loginInfoDto.getGamen_id();

		// 戻り先画面格納用変数
		String returnGamen = null;

		if(strGamenId.equals(UTLContent.GMID_SIJGM001)) {
			returnGamen = "forward:/initSijGm001";
		} else if (strGamenId.equals(UTLContent.GMID_COMGM002)) {
			returnGamen ="forward://initComGm002";
		}
		return new ModelAndView(returnGamen);
//		SIJGM002Dto sijGm002Dto = new SIJGM002Dto();
//		BeanUtils.copyProperties(sijGm002Form, sijGm002Dto);
//
//		SIJGM002MAV sijGm002MAV = new SIJGM002MAV();
//		BeanUtils.copyProperties(sijGm002Form, sijGm002MAV);

//		return new ModelAndView("forward:/initComGm002","SIJGM002MAV",sijGm002MAV);
	}

	/**
	 * 戻る処理（遷移先：社員情報一覧表示画面）
	 * @param SIJGM002Form
	 * @return SiJGM001Controller.java
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/177
	 */
	@RequestMapping(value = "/initSijGm002",params = "backSijGm001", method = RequestMethod.POST)
	public ModelAndView backSijGm001(SIJGM002Form sijGm002Form,Model model) {
		SIJGM002Dto sijGm002Dto = new SIJGM002Dto();
		BeanUtils.copyProperties(sijGm002Form, sijGm002Dto);

		SIJGM002MAV sijGm002MAV = new SIJGM002MAV();
		BeanUtils.copyProperties(sijGm002Form, sijGm002MAV);

		return new ModelAndView("forward:/initSijGm001","SIJGM002MAV",sijGm002MAV);
	}



private SIJGM002Dto setSijGm002dto(SIJGM002Form sijgm002Form) {

	// Dtoを生成
	SIJGM002Dto sijGm002Dto = new SIJGM002Dto();

//	// 日付を取得
//	Date date = new Date();
	// ログイン情報を取得
	LoginInfoDto loginInfoDto = new LoginInfoDto();
	String userId = (String)loginInfo.getAttribute().getUser_id();

	// DtoにFormの値を設定する
	BeanUtils.copyProperties(sijgm002Form,sijGm002Dto);

	return sijGm002Dto;
}

private SIJGM002Form setSijGm002Form(SIJGM002Dto sijgm002Dto) {

	// Formを生成
	SIJGM002Form sijGm002Form = new SIJGM002Form();

	// FormにDtoの値を設定する
	BeanUtils.copyProperties(sijgm002Dto, sijGm002Form);

	return sijGm002Form;
}
}

