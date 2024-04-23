package com.home.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Timestamp;


@Component
@Entity(name = "animls")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Animal {
    @Id
    @SequenceGenerator(name = "AnimlSqns", sequenceName = "animls_id_seq", allocationSize = 1)
    @GeneratedValue(generator = "AnimlSqns")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "age")
    private Integer age;

    @Column(name = "place")
    private String place;

    @Column(name = "birth")
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp birth;


}
