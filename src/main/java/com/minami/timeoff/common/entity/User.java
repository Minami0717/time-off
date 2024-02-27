package com.minami.timeoff.common.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.minami.timeoff.common.config.jpa.BaseEntity;
import com.minami.timeoff.common.config.security.model.ProviderType;
import com.minami.timeoff.common.config.security.model.RoleType;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.DynamicInsert;


@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "unique_tuser_provider_uid", columnNames = {"provider_type", "uid"})})
@Data
@SuperBuilder
@NoArgsConstructor
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@DynamicInsert
public class User extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, columnDefinition = "BIGINT UNSIGNED")
    private Long iuser;

    @Column(name="provider_type", nullable = false, length = 20)
    @Enumerated(EnumType.STRING)
    @NotNull
    @Size(min = 10, max = 20)
    private ProviderType providerType;

    @Column(nullable = false, length = 80)
    @Size(min = 3, max = 80)
    private String uid;

    @JsonIgnore
    private String upw;

    @Column(nullable = false, length = 20)
    @Size(min = 2, max = 20)
    private String unm;

    @JsonIgnore
    @Column(name="role_type", length=20)
    @Enumerated(EnumType.STRING)
    @NotNull
    private RoleType roleType;

    @Size(min = 10, max = 60)
    @Column(length=60)
    private String email;

    private String cmt;
    private String pic;
}
