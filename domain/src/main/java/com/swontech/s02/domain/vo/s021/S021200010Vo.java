package com.swontech.s02.domain.vo.s021;

import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

public class S021200010Vo {

    @Getter
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class SelectMemberEmailVo{
        private String email;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Member implements UserDetails {
        private String email;
        private String pwd;
        private String memberTp;

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            // memberTp를 return 타입에 맞게 List<> 반환
            return Arrays.stream(new String[]{this.memberTp})
                    .map(SimpleGrantedAuthority::new)
                    .collect(Collectors.toList());
        }

        @Override
        public String getPassword() {
            return this.pwd;
        }

        @Override
        public String getUsername() {
            return this.email;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }
    }
}
