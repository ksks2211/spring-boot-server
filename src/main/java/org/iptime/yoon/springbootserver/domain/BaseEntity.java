package org.iptime.yoon.springbootserver.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

/**
 * @author rival
 * @since 2022-03-03
 */
@MappedSuperclass
@EntityListeners(value={AuditingEntityListener.class})
@Data
@ToString
@EqualsAndHashCode
public abstract class BaseEntity {
    @CreatedDate  // Entity 생성시간 , JPA에서 처리
    @Column(name="created_at",updatable=false)
    private LocalDateTime createdAt;

    @LastModifiedDate  // Entity 변경시간
    @Column(name="modified_at")
    private LocalDateTime modifiedAt;
}
