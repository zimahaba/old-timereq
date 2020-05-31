package com.zimahaba.timereq.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Builder
@Entity
@Table(name = "request")
public class Request extends PersistentEntity {

    @Column(name = "nr_number", nullable = false, length = 10)
    private String number;

    @Column(name = "ds_description", nullable = false, length = 2000)
    private String description;

    @Column(name = "ds_observation", length = 2000)
    private String observation;

    @Column(name = "dt_start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "dt_end_date")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "id_project", nullable = false)
    private Project project;

    @ManyToOne
    @JoinColumn(name = "id_situation", nullable = false)
    private Situation situation;

    @OneToMany(mappedBy = "request", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Period> periods;

    public void addPeriod(Period period) {
        if (periods == null) {
            periods = new ArrayList<>();
        }
        period.setRequest(this);
        periods.add(period);
    }
}
