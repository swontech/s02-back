package com.swontech.s02.config;

/**
 * Spring Security 설정을 위한 환경설정 클래스 파일
 * <p>
 *     Spring Security적용을 위한 설정이 포함되어 있습니다.
 * </p>
 *
 * @version : 1.0
 * @author  : MSH
 * @since   : 2022.03.23
 * @see     : none
 * ================================================
 * @lastmodify  : 2022.03.23 MSH
 */
import com.swontech.s02.client.service.comm.UserDetailsService;
import com.swontech.s02.domain.common.security.JwtAuthenticationProvider;
import com.swontech.s02.domain.common.security.JwtTokenProvider;
import com.swontech.s02.domain.common.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, jsr250Enabled = true, prePostEnabled = true)
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtTokenProvider jwtTokenProvider;
    @Autowired
    private JwtAuthenticationProvider jwtAuthenticationProvider;
    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .httpBasic().disable()
                .csrf().disable()
                .cors().disable()
                .formLogin().disable()


                /**
                 * 토큰 기반의 인증 정책을 사용할 것이므로 STATELESS정책으로 세션을 생성한다.
                 */
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)

                /**
                 * 권한 인증이 필요한 request를 지정한다.
                 * A: System Admin
                 * R: 단체 대표
                 * S: 단체 운영자
                 * M: 단체일반사용자
                 */
                .and()
                .authorizeRequests()
                // 허용 url
//                .antMatchers("/rest/v1/s021200010/**", "/rest/v1/s021100020/**", "/rest/v1/s022300050/**").permitAll()
//                .antMatchers("/rest/v1/s021200020/log-in").permitAll()
//                .antMatchers("/api/v1/users/userTest").hasRole("USER")
//                .antMatchers("/api/v1/users/adminTest").hasRole("ADMIN")
//                .anyRequest().authenticated()
                .anyRequest().permitAll()


                /**
                 * UsernamePasswordAuthenticationFilter전에 JwtAuthenticationFilter를 작동시켜 인증을 진행한다.
                 */
                .and()
                    .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class)
                ;
    }

    /**
     * AuthenticationManagerBuilder에 커스텀한 JwtAuthenticationProvider와 UserDetailsService
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(this.jwtAuthenticationProvider);
        auth.userDetailsService(this.userDetailsService);
    }

    /**
     * BCryptPasswordEncoder를 빈으로 등록한다.
     * @return PasswordEncoder
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}