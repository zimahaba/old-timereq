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
@Table(name = "situation")
public class Situation extends PersistentEntity {

    @Column(name = "nm_name", nullable = false, length = 20)
    private String name;

    @Column(name = "cd_code", nullable = false, length = 1)
    private Integer code;
}
