package jp.arise.gbj.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import jp.arise.gbj.form.GBJGM002Form;
import jp.arise.gbj.modelandview.GBJGM001MAV;
import jp.arise.gbj.service.GBJGM002Servise;
import jp.arise.sij.form.SIJGM002Form;
import jp.arise.utl.LoginInfo;
import jp.arise.utl.LoginInfoDto;
import jp.arise.utl.UTLContent;

/**
 * GBJGM002 現場情報新規登録・編集画面用コントローラー
 * @author AtsushiNishizawa
 * @since 2017/07/17
 */
@Controller
public class GBJGM002Controller {

	@Autowired
	public LoginInfo loginInfo;

	@Autowired
	private GBJGM002Servise gbjGm002Service;

    @ModelAttribute
    public GBJGM002Form setGbjGm002Formm() {
    	GBJGM002Form gbjGm002Form = new GBJGM002Form();
        return gbjGm002Form;
    }

	/**
	 * 初期処理（遷移元：メニュー画面）
	 * @param model
	 * @return GBJGM002.jsp
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/17
	 */
	@RequestMapping(value = "/initGbjGm002",params = "goGbjGm002", method = RequestMethod.POST)
	public String initGbjGm002(Model model) {
    	//セッション情報取得
		LoginInfoDto loginInfoDto = new LoginInfoDto();
		loginInfoDto = loginInfo.getAttribute();
		System.out.println(loginInfoDto.getUser_id());

		GBJGM002Form gbjGm002Form = new GBJGM002Form();
		gbjGm002Form.setUser("");
		model.addAttribute("GBJGM002Form",gbjGm002Form);
		return "GBJGM002";
	}

	/**
	 * 初期処理（遷移元：現場情報一覧表示画面<）
	 * @param model
	 * @return GBJGM002.jsp
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/17
	 */
	@RequestMapping(value = "/initGbjGm002",params = "goToGbjGm002",method = RequestMethod.POST)
	public String initGbjGm002(Model model,GBJGM001MAV gbjGm001MAV) {
		GBJGM002Form gbjGm002Form = new GBJGM002Form();
		gbjGm002Form.setUser(gbjGm001MAV.getUser());
		model.addAttribute("GBJGM002Form",gbjGm002Form);
		return "GBJGM002";
	}

	/**
	 * 新規登録処理
	 * @param GBJGM002Form
	 * @return GBJGM002.jsp
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/177
	 */
	@RequestMapping(value = "/initGbjGm002",params = "entryGbjGm002", method = RequestMethod.POST)
	public String entryGbjGm002(GBJGM002Form gbjGm002Form,Model model) {
		return "GBJGM002";
	}

	/**
	 * 更新処理
	 * @param GBJGM002Form
	 * @return GBJGM002.jsp
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/177
	 */
	@RequestMapping(value = "/initGbjGm002",params = "updateGbjGm002", method = RequestMethod.POST)
	public String updateGbjGm002(GBJGM002Form gbjGm002Form,Model model) {
		return "GBJGM002";
	}

	/**
	 * 削除処理
	 * @param GBJGM002Form
	 * @return GBJGM002.jsp
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/177
	 */
	@RequestMapping(value = "/initGbjGm002",params = "deleteGbjGm002", method = RequestMethod.POST)
	public String deleteGbjGm002(GBJGM002Form gbjGm002Form,Model model) {
		return "GBJGM002";
	}

	/**
	 * 戻る処理（遷移先：メニュー画面）
	 * @param GBJGM002Form
	 * @return COMGM002Controller.java
	 * @throws
	 * @author AtsushiNishizawa
	 * @since 2017/07/177
	 */
	@RequestMapping(value = "/initGbjGm002",params = "backComGm002", method = RequestMethod.POST)
	public ModelAndView back(SIJGM002Form sijGm002Form,Model model){
		// ログイン情報取得
		LoginInfoDto loginInfoDto = new LoginInfoDto();
		loginInfoDto = loginInfo.getAttribute();

		// セッション情報の遷移元画面を取得
		String strGamenId = (String) loginInfoDto.getGamen_id();

		// 戻り先画面格納用変数
		String returnGamen = null;

		if(strGamenId.equals(UTLContent.GMID_GBJGM001)) {
			returnGamen = "forward:/initGbjGm001";
		} else if (strGamenId.equals(UTLContent.GMID_COMGM002)) {
			returnGamen ="forward://initComGm002";
		}
		return new ModelAndView(returnGamen);
	}
	//プルダウンリストを作成
	@RequestMapping(value = "/sample", method = RequestMethod.GET)
	public String firstSamplePage(Model model) {
		Map<String, String> phase = new HashMap<String, String>();
		phase.put("development", "開発");
		phase.put("evaluation", "評価");
		model.addAttribute("phaseList", phase);
		model.addAttribute("messege","フェーズを選択してください");
		return "showMessage";
	}
}


