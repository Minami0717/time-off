package com.minami.timeoff.common.entity;

import com.minami.timeoff.common.config.jpa.BaseEntity;
import com.minami.timeoff.common.enums.TrueFalse;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@Entity
@Getter
@SuperBuilder
@NoArgsConstructor
@Where(clause = "deleted = 0")
@SQLDelete(sql = "UPDATE post SET deleted = 1 WHERE post_id = ?")
public class Post extends BaseEntity {
    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Long postId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false, columnDefinition = "text")
    private String content;

    @Column(length = 100)
    private String hashTag;

    @Column(nullable = false, length = 10)
    private String theme;

    @Column(nullable = false, columnDefinition = "int unsigned")
    @ColumnDefault("0")
    private int likeCount;

    @Column(nullable = false, columnDefinition = "int unsigned")
    @ColumnDefault("0")
    private int hits;

    @Column(nullable = false)
    @ColumnDefault("0")
    private TrueFalse deleted;
}
