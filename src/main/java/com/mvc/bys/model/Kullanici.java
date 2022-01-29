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
@Table(name = "kullanici")
public class Kullanici {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "kullanici_id")
    private int kullaniciId;

    @Column(name = "k_kullaniciadi")
    private String kullaniciAdi;

    @Column(name = "k_parola")
    private String kullaniciParola;

    @Column(name = "k_adi")
    private String adi;

    @Column(name = "k_soyadi")
    private String soyadi;

    @Column(name = "k_eposta")
    private String kullaniciEposta;

    @Column(name = "k_telefon")
    private String kullaniciTelefon;

    @Column(name = "k_durum")
    private String kullaniciDurum;

    @Column(name = "rol_id")
    private int rolId;

}
