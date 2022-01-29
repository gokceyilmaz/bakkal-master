package com.mvc.bys.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "satis")
public class Satis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "satis_id")
    private int satisId;

    @Column(name = "s_tarih")
    private LocalDate satisTarih;

    @Column(name = "s_durum")
    private String satisDurum;

    @Column(name = "kullanici_id")
    private int kullaniciId;

}
