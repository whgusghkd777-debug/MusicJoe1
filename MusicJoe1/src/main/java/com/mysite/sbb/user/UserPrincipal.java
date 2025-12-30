package com.mysite.sbb.user;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;
import java.util.List; // 이 줄이 누락되면 안 됩니다!

public class UserPrincipal implements UserDetails {
    private final SiteUser user;

    public UserPrincipal(SiteUser user) {
        this.user = user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // user.getRole().name() 을 사용하면 더 안전합니다.
        return Collections.singletonList(new SimpleGrantedAuthority(user.getRole().name()));
    }

    @Override public String getPassword() { return user.getPassword(); }
    @Override public String getUsername() { return user.getUsername(); }
    @Override public boolean isAccountNonExpired() { return true; }
    @Override public boolean isAccountNonLocked() { return true; }
    @Override public boolean isCredentialsNonExpired() { return true; }
    @Override public boolean isEnabled() { return true; }

    public SiteUser getUser() { return user; }
}