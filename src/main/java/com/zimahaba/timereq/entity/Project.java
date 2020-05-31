package com.zimahaba.timereq.entity;

import lombok.*;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "project")
public class Project extends PersistentEntity {

    @Column(name = "nm_name", nullable = false, length = 20)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_company", nullable = false)
    private Company company;
}
