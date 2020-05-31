package com.zimahaba.timereq.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "period")
public class Period extends PersistentEntity {

    @Column(name = "tm_start_time", nullable = false)
    private LocalTime startTime;

    @Column(name = "tm_end_time")
    private LocalTime endTime;

    @Column(name = "dt_date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "id_request", nullable = false)
    @JsonIgnore
    private Request request;
}
