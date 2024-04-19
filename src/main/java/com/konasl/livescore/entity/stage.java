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
        name = "stage"
)
public class stage extends BaseEntity {

    @Column(nullable = false)
    private Long week;

    @Column(nullable = false)
    private Long stage;

    @Column(nullable = false)
    private String status;

    private Long student_id;
}
