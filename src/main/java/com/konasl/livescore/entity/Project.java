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
        name = "project",
        uniqueConstraints = {
                @UniqueConstraint(columnNames = "project_id", name = "uc_project_id")
        }
)
public class Project extends BaseEntity {

    @Column(nullable = false)
    private String module_name;

    @Column(nullable = false)
    private String module_description;

    @Column(nullable = false)
    private String domain;

    @Column(nullable = false)
    private Long project_id;

}
