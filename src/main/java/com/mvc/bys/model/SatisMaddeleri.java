package com.mvc.bys.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "satis_maddeleri")
public class SatisMaddeleri {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "sm_id")
    private int satisMaddeleriId;

    @Column(name = "si_miktar")
    private double satisMiktar;

    @Column(name = "si_fiyat")
    private double satisFiyat;

    @Column(name = "si_iskonto")
    private double satisIskonto;

    @Column(name = "satis_id")
    private int satisiId;

    @Column(name = "urun_id")
    private int UrunId;

}
