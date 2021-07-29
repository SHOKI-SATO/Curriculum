package com.example.security.springsecurity.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//問４－１ コントローラーを意味するアノテーションを記述
@Controller
//Spring MVCのコントローラーに該当するクラス（画面遷移用のコントローラー）に付与。
public class AuthController {

	@Autowired
//	特定のアノテーションを付与したクラスのインスタンスを使用できるようにする、記述するだけで他クラスを呼び出せるようになる

	private AccountRepository repository;

	public List<Account> get() {
		return (List<Account>) repository.findAll();
	}

	@RequestMapping("/")
//	@Controller / @RestController を付与したクラスがマッピングするURLの接頭辞を設定
//	MVCのControllerの処理対象となるURLを@RequestMappingアノテーションのvalueオプションで指定
//	リクエスト URL に対して、どのメソッドが処理を実行するか定義
	public String index() {
		return "redirect:/top";
	}

	@GetMapping("/login")
//	最初のログインページ
//	@RequestMappingのGETリクエスト用のアノテーション
	public String login() {
		return "login";
//		loginというURLを返す
	}

	@PostMapping("/login")
//	HTTPリクエストのPOSTメソッドを受け付けるためのメソッドに付与
//	@RequestMappingのPOSTリクエスト用のアノテーション
	public String loginPost() {
		return "redirect:/login-error";
//		login-errorというページを返す（下のGetMapping）

	}

	@GetMapping("/login-error")
//	@RequestMappingのGETリクエスト用のアノテーション
	public String loginError(Model model) {
		model.addAttribute("loginError", true);
		return "login";
//		　上の処理を実行した上でloginというURLを返す

	}

	@RequestMapping("/top")
//	@Controller / @RestController を付与したクラスがマッピングするURLの接頭辞を設定
//	MVCのControllerの処理対象となるURLを@RequestMappingアノテーションのvalueオプションで指定
//	リクエスト URL に対して、どのメソッドが処理を実行するか定義
	public String top() {
		return "/top";
	}

}
