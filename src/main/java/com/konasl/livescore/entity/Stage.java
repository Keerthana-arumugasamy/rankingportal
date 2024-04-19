package com.konasl.livescore.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(
        name = "stage"
)
public class Stage extends BaseEntity {

    @Column(nullable = false)
    private Long week;

    @Column(nullable = false)
    private Long stage;

    @Column(nullable = false)
    private String status;

    private Long student_id;
}
