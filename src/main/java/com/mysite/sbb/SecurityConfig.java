package com.mysite.sbb;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;

@Configuration //이 파일이 스프링의 환경 설정 파일임을 의미하는 애너테이션이다.
@EnableWebSecurity //모든 요청 URL이 스프링 시큐리티의 제어를 받도록 만드는 애너테이션이다.
//이 애너테이션을 사용하면 스프링 시큐리티를 활성화하는 역할을 한다. 내부적으로 SecurityFilterChain 클래스가 동작하여 모든 요청 URL에 이 클래스가 필터로 적용되어 URL별로 특별한 설정을 할 수 있게 된다.
public class SecurityConfig {
	@Bean //스프링 시큐리티의 세부 설정은 @Bean 애너테이션을 통해 SecurityFilterChain 빈을 생성하여 설정할 수 있다.
	/*
	 * 빈이란?
	 * 빈(bean)은 스프링에 의해 생성 또는 관리되는 객체를 의미한다. 
	 * 우리가 지금껏 만들어 왔던 컨트롤러, 서비스, 리포지터리 등도 모두 빈에 해당한다.
	 * 또한 앞선 예처럼 @Bean 애너테이션을 통해 자바 코드 내에서 별도로 빈을 정의하고 등록할 수도 있다.
	*/
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		
		//다음은 인증되지 않은 모든 페이지의 요청을 허락한다는 의미이다. 따라서 로그인하지 않더라도 모든 페이지에 접근할 수 있도록 한다.
		http.authorizeHttpRequests((authorizeHttpRequests) -> 
		authorizeHttpRequests.requestMatchers(new AntPathRequestMatcher("/**")).permitAll()).csrf((csrf) ->
		csrf.ignoringRequestMatchers(new AntPathRequestMatcher("/h2-console/**"))).headers((headers) -> headers
                .addHeaderWriter(new XFrameOptionsHeaderWriter(
                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)))
		.formLogin((formLogin) -> formLogin
                .loginPage("/user/login")
                .defaultSuccessUrl("/"))
		.logout((logout) -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/user/logout"))
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true));
		return http.build();
	}
	
	@Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Bean
    AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
}
