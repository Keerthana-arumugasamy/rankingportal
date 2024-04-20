package com.konasl.livescore.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(
        name = "level"
)
public class Level extends BaseEntity {

    @Column(nullable = false)
    private Long level;

    @Column(nullable = false)
    private String course;

    @Column(nullable = false)
    private String status;

    @Column(nullable = false)
    private Long student_id;


}
