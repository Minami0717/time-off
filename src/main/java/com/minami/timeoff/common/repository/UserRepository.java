package com.minami.timeoff.common.repository;

import com.minami.timeoff.common.config.security.model.ProviderType;
import com.minami.timeoff.common.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByProviderTypeAndUid(ProviderType providerType, String uid);
}
