package com.janowik.maclab.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name = "service_order")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @NotNull
    @Column(name = "date_of_report")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfReport;

    @NotNull
    @Column(name = "date_of_notification")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfNotification;

    @NotNull
    @Column(name = "device_description")
    private String deviceDescription;

    @NotNull
    @Column(name = "serial_imei_number")
    private String serialImeiNumber;

    @NotNull
    @Column(name = "problem_description")
    private String problemDescription;

    @NotNull
    @Column(name = "repair_description")
    private String repairDescription;

    @Column(name = "comments")
    private String comments;

    @NotNull
    @JsonIgnore
    @ManyToOne
    private Person person;
}
