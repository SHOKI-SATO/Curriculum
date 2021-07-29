package com.example.security.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.example.security.springsecurity.account.AccountService;

@EnableWebSecurity
//@Configurationクラスに追加して、 WebSecurityConfigurerAdapter基本クラスを拡張し、
//個々のメソッドをオーバーライドすることで、 WebSecurityConfigurer以上の可能性でSpring Security構成を定義
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountService userService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
        .antMatchers("/login", "/login-error").permitAll()
//       　最初のログインページ、入力後のエラーページなので誰でもアクセス可
        .antMatchers("/**").hasRole("USER")
//       　ログイン後のページなのでユーザーのみアクセスを許可
        .and()
        .formLogin()
        .loginPage("/login").failureUrl("/login-error");
    }


    //変更点 ロード時に、「admin」ユーザを登録する。
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
        .userDetailsService(userService)
        .passwordEncoder(passwordEncoder());

        if (userService.findAllList().isEmpty()) {
            userService.registerAdmin("admin", "secret", "admin@localhost");
            userService.registerManager("manager", "secret", "manager@localhost");
            userService.registerUser("user", "secret", "user@localhost");
        }
    }
    //変更点 PasswordEncoder(BCryptPasswordEncoder)メソッド
    @Bean
//    DIコンテナに管理させたい「Bean」を生成するメソッドに付与
    public PasswordEncoder passwordEncoder() {
        //
        return new BCryptPasswordEncoder();
    }

}