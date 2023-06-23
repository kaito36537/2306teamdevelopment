package com.example.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.example.demo.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{
	private UserService userService;
	
	@Autowired
	public WebSecurityConfig (UserService userService) {
		this.userService = userService;
	}

	
	
	// URLパス毎に制御
    @Override
    public void configure(HttpSecurity http) throws Exception{
        http
        //「login.html」はログイン不要でアクセス可能に設定
        .antMatchers("/login").permitAll()
        //上記以外は直リンク禁止
        .anyRequest().authenticated()
    .and()
    .formLogin()
        //ログイン処理のパス
        .loginProcessingUrl("/login")
        //ログインページ
        .loginPage("/login")
        //ログインエラー時の遷移先 ※パラメーターに「error」を付与
        .failureUrl("/login?error")
        //ログイン成功時の遷移先
        .defaultSuccessUrl("/hello", true)
        //ログイン時のキー：名前
        .usernameParameter("username")
        //ログイン時のパスワード
        .passwordParameter("password")
    .and()
    .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutUrl("/logout") //ログアウトのURL
        .invalidateHttpSession(true)
        //ログアウト時の遷移先 POSTでアクセス
        .logoutSuccessUrl("/afterLogout.html");
    }
	
	// ユーザ情報の取得
	 @Override
	    public void configure(AuthenticationManagerBuilder auth) throws Exception{
	        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
	    }
	 
	 // パスワードハッシュ化する
	    public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder BCryptPasswordEncoder  = new BCryptPasswordEncoder();
	            return BCryptPasswordEncoder ;
	    }
}
