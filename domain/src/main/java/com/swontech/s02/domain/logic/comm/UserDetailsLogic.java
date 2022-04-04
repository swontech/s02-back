package com.swontech.s02.domain.logic.comm;

import com.swontech.s02.domain.store.s021.S021200010Store;
import com.swontech.s02.domain.vo.s021.S021200010Vo;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsLogic implements UserDetailsService {
    private final S021200010Store s021200010Store;
    public UserDetailsLogic(S021200010Store s021200010Store) {
        this.s021200010Store = s021200010Store;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return createUserDetails(s021200010Store.selectMember(username));
    }

    private UserDetails createUserDetails(S021200010Vo.Member member) {
        return new User(member.getUsername(), member.getPassword(), member.getAuthorities());
    }
}
