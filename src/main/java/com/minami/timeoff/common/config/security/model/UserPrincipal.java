package com.minami.timeoff.common.config.security.model;

import com.minami.timeoff.common.entity.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import java.util.Collection;
import java.util.List;
import java.util.Map;

@Data
@Builder
public class UserPrincipal implements UserDetails, OAuth2User {
    private LoginInfoVo loginInfoVo;
    private String uid;
    private String upw;
    private String unm;
    private Map<String, Object> attributes;

    public Long getIuser() {
        return loginInfoVo.getIuser();
    }
    public List<String> getRoles() { return loginInfoVo.getRoles(); }

    @Override
    public String getName() {
        return uid;
    }

    @Override
    public Map<String, Object> getAttributes() {
        return attributes;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.loginInfoVo.getRoles().stream().map(SimpleGrantedAuthority::new).toList();
        //new SimpleGrantedAuthority("");
        //return this.loginInfoVo.getRoles().stream().map(item -> new SimpleGrantedAuthority(item)).toList();
    }

    @Override
    public String getPassword() {
        return upw;
    }

    @Override
    public String getUsername() {
        return unm;
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

    public static UserPrincipal create(User user) {
        LoginInfoVo loginInfoVo = new LoginInfoVo(user.getIuser());
        loginInfoVo.addRole(user.getRoleType().getCode());
        return UserPrincipal.builder()
                .loginInfoVo(loginInfoVo)
                .uid(user.getUid())
                .unm(user.getUnm())
                .build();
    }

    public static UserPrincipal create(User user, Map<String, Object> attributes) {
        UserPrincipal userPrincipal = create(user);
        userPrincipal.setAttributes(attributes);

        return userPrincipal;
    }
}
