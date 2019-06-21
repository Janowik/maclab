package com.janowik.maclab.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "service_order")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Order {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "date_of_report")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfReport;

    @Column(name = "date_of_notification")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateOfNotification;

    @Column(name = "device_description")
    private String deviceDescription;

    @Column(name = "serial_imei_number")
    private String serialImeiNumber;

    @Column(name = "problem_description")
    private String problemDescription;

    @Column(name = "repair_description")
    private String repairDescription;

    @Column(name = "comments")
    private String comments;

    @Column(name = "name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "email")
    private String email;

}
