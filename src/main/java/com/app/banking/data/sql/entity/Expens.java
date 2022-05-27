package com.app.banking.data.sql.entity;

import com.app.banking.util.CsvWriteable;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "expenses")
public class Expens implements CsvWriteable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = 64)
    private String name;

    @Column(name = "expectedAmount", nullable = false)
    private Float expectedAmount;

    @Override
    public String getCsvLine() {
        return id.toString() + "," + name + "," + expectedAmount.toString() + "\n";
    }
}