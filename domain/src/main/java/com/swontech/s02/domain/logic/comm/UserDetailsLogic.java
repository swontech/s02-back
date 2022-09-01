package com.swontech.s02.domain.logic.comm;

import com.swontech.s02.domain.store.s021.S021200010Store;
import com.swontech.s02.domain.vo.s021.S021200010Vo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

@Slf4j
public class UserDetailsLogic implements UserDetailsService {
    private final S021200010Store s021200010Store;
    public UserDetailsLogic(S021200010Store s021200010Store) {
        this.s021200010Store = s021200010Store;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info("loadUserByUsername 실행");
        return createUserDetails(s021200010Store.selectMember(username));
    }

    private UserDetails createUserDetails(S021200010Vo.Member member) {
        log.info("username:" + member.getUsername());
        log.info("password:" + member.getPassword());
        log.info("authrities:" + member.getAuthorities());

        return new User(member.getUsername(), member.getPassword(), member.getAuthorities());
    }
}
