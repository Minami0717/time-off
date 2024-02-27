package com.minami.timeoff.common.config.security;

import com.minami.timeoff.common.config.security.model.UserPrincipal;
import com.minami.timeoff.common.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class AuthenticationFacade {

    private Authentication getAuth() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    //로그인이 되어 있는지 확인
    public boolean isAuthenticated() { return getAuth() != null; }

    public User getLoginUser() {
        Authentication auth = getAuth();
        if(auth == null) { return null; }
        UserPrincipal userDetails = (UserPrincipal) getAuth().getPrincipal();
        return User.builder().iuser(userDetails.getIuser()).build();
    }

    public Long getLoginUserPk() {
        User user = getLoginUser();
        if(user == null) { return null; }
        return user.getIuser();
    }
}
