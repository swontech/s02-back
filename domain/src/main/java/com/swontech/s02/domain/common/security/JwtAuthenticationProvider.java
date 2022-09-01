package com.swontech.s02.domain.common.security;
/**
 * AuthenticationProvider를 상속받은 커스텀 AuthenticationProvider 클래스 파일
 * <p>
 *      사용자가 입력한 인증정보가 DB에 저장된 사용자 정보와 일치하는지를 검증하는 역할을 한다.
 * </p>
 * @version : 1.0
 * @author  : MSH
 * @since   : 2022.03.23
 *
 * {@link com.swontech.s02.domain.logic.s021.S021200010Logic#signIn(S021200010Dto.SignIn)} 에서 사용
 * ================================================
 * @lastmodify  : 2022.03.23 MSH
 *
 */

import com.swontech.s02.domain.dto.s021.S021200010Dto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {
    private final UserDetailsService userDetailsService;
    private final PasswordEncoder passwordEncoder;
    public JwtAuthenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
        this.userDetailsService = userDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    /**
     *  사용자가 입력한 패스워드와 DB에 저장된 패스워드를 검증하여 인증정보를 반환하는 메소드
     * <p>
     *     사용자가 화면에서 입력한 로그인 정보를 바탕으로
     *     S021200010Logic.signIn메소드에서 UsernamePasswordAuthenticationToken로 생성된 Authentication객체를 parameter로 받아
     *     패스워드 일치여부를 검증한 뒤, 완성된 UsernamePasswordAuthenticationToken을 리턴한다.
     * </p>
     * @param   {Authentication}타입의 사용자가 화면에서 입력한 이메일과 패스워드정보.
     * @return  {Authentication}타입의 사용자가 화면에서 입력한 이메일과 패스워드에 DB에서 조회한 사용자의 권한을 담아 리턴한다.
     * @throws  AuthenticationException
     * {@link com.swontech.s02.domain.logic.s021.S021200010Logic#logIn(S021200010Dto.LogIn)}
     *          에서 호출
     */
    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        log.info("JwtAuthenticationProvider 실행");

        /**
         * 화면에서 사용자가 입력한 이메일 및 비밀번호 정보.
         */
        String email = authentication.getName();
        String password = (String)authentication.getCredentials();

        /**
         * 커스텀 UserDetailsService에서 사용자가 화면에서 입력한 로그인정보 받은 입력값을 바탕으로 DB를 조회하여 UserDetails를 생성한다.
         */
        UserDetails member = this.userDetailsService.loadUserByUsername(email);

        /**
         * 입력한 패스워드가 올바른지 검증하며 일치하지 않을 경우 BadCredentialsException을 발생시킨다.
         */
        if(!passwordEncoder.matches(password, member.getPassword())) {
            log.info("비밀번호가 일치하지 않습니다.");
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        return new UsernamePasswordAuthenticationToken(email, password, member.getAuthorities());
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
