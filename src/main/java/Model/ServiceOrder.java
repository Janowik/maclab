package Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "service_order")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ServiceOrder {

    @Id
    @Column(name = "id")
    private long id;

    @Column(name = "date_of_notification")
    private LocalDate dateOfNotification;

    @Column(name = "device_description")
    private String deviceDescription;

    @Column(name = "serial_imei_number")
    private String serialImeiNumber;

    @Column(name = "problem_description")
    private String problemDescription;

    @Column(name = "repair_description")
    private String repairDescription;

    @ManyToOne
    @JoinColumn
    private Customer customer;
}
