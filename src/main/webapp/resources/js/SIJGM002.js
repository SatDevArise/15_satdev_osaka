/**
 * SIJGM002 社員情報新規登録・編集画面用JavaScript
 *
 * @author AtsushiNishizawa
 * @since 2017/07/17
 */


///**
// * 必須チェック処理
// */
//function inpCheck_Hissu() {
//	var flg = 0;
//	var form = window.document.forms.SIJGM002;
//	var syain_na = form.syain_na.value;
//	var birth_dt = form.birth_dt.value;
//	var moyori_eki_1 = form.moyori_eki_1.value;
//	var moyori_eki_2 = form.moyori_eki_2.value;
//	var moyori_eki_3 = form.moyori_eki_3.value;
//	var syain_renrakusaki = form.syain_renrakusaki.value;
//	var syain_id = form.syain_id.value;
//
//	if (syain_na.trim() == "") {
//		document.getElementById("error_hyoji").innerHTML = "社員名を入力してください";
//		document.getElementById("error_hyoji").style.color = "red";
//		return false;
//	} else if (birth_dt.trim() == "") {
//		document.getElementById("error_hyoji").innerHTML = "生年月日を入力してください";
//		document.getElementById("error_hyoji").style.color = "red";
//		return false;
//	} else if (moyori_eki_1.trim() == "") {
//		document.getElementById("error_hyoji").innerHTML = "最寄り駅１を入力してください";
//		document.getElementById("error_hyoji").style.color = "red";
//		return false;
//	} else if (moyori_eki_1.trim() != "" && moyori_eki_2.trim() == "") {
//		document.getElementById("error_hyoji").innerHTML = "最寄り駅２を入力してください";
//		document.getElementById("error_hyoji").style.color = "red";
//		return false;
//	} else if (moyori_eki_1.trim() != "" && moyori_eki_2.trim() != "" && moyori_eki_3 == "") {
//		document.getElementById("error_hyoji").innerHTML = "最寄り駅３を入力してください";
//		document.getElementById("error_hyoji").style.color = "red";
//		return false;
//	} else if (syain_renrakusaki.trim() == "") {
//		document.getElementById("error_hyoji").innerHTML = "連絡先を入力してください";
//		document.getElementById("error_hyoji").style.color = "red";
//		return false;
//
//	}
//	return true;
//};

// /**
// * 項目活性状態制御
// */
// // パラメータの取得
// var param = [];
// var doc = document.window;
// var params = location.search.substring(1).split('&');
// for (var i = 0; i < param.length; i++) {
// params[i] = param[i].split('=');
//
// }
//
// // パラメータの使用
// var target = 'pattern';
// var value;
// var doc = window.document;
// for (var i = 0; i < params.length; i++) {
// if (params[i][0] == target) {
// value = params[i][1];
// break;
// }
// }
//
// switch (value) {
// case 'SIJGM001':
// $('btn btn-success').prop('disabled', false);
// // doc.getElementById("btn btn-success").disabled = true;
// // doc.getElementById("btn btn-success").disabled = true;
// break;
// default:
// $('btn btn-default').prop('disabled', true);
// }

// /**
// * 必須チェック処理
// */
// function requiredCheck() {
// var a = document.fa.NamA.value;
// var b = a.length;
// var txt = document.fa.NamA.value;
// var result = txt.match(/[^0-9]/g);
//
// if (document.fa.NamA.value == "") {
// alert("検索キーが入力されていません。");
// return false;
// } else if (b > 16) {
// alert(b + "桁入力されています。入力できる文字数は16桁です。");
// return false;
// } else if (b < 16) {
// alert(b + "桁入力されています。検索には16桁入力して下さい。");
// return false;
// } else {
// // ＊＊＊
// // OK場合はtrueを返す
// return true;
// }
//
// }

/**
 * 削除確認処理
 */

function confirmDelete() {
	if (window.confirm('本当に削除しますか？')) {

		window.alert('削除しました。');
		return true;
	} else {
		window.alert('キャンセルしました。');
		return true;
	}
};

///**
// * 更新確認処理
// */
//
//function confirmUpload() {
//	inpCheck()
//	updateCheck()
//};

/**
 * 更新確認ダイアログ
 */
function updateCheck() {
	if (window.confirm('本当に更新しますか？')) {
		window.alert('更新しました。');
		return true;
	} else {
		window.alert('キャンセルしました。');
		return false;
	}
}



