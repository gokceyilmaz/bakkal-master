package com.mvc.bys.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "stok")
public class Stok {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "stok_id")
    private int stokId;

    @Column(name = "s_adedi")
    private int stokAdedi;

    @Column(name = "s_giris_tarihi")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sGirisTarihi;

    @Column(name = "s_bitis_tarihi")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate sBitisTarihi;



}
