package ma.emsiedu.employeemanager.models;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;


@Entity
@Data
@AllArgsConstructor @NoArgsConstructor @ToString
public class Employee implements Serializable {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false, updatable = false)
    private Long id;
    private String name;
    private String email;
    private String jobTitle;
    private String phoneNumber;
    private String imageUrl;
    @Column(nullable = false, updatable = false)
    private String employeeCode;

}
