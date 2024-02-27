package com.minami.timeoff.common.repository;

import com.minami.timeoff.common.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
