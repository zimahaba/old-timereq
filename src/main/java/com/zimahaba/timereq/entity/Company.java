package com.zimahaba.timereq.entity;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "company")
public class Company extends PersistentEntity {

    @Column(name = "nm_name", nullable = false, length = 100)
    private String name;
}
