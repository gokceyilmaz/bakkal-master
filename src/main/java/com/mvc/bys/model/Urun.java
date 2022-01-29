package com.mvc.bys.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name = "urun")
public class Urun {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull
    @Column(name = "urun_id")
    private int urunId;

    @Column(name = "u_adi")
    private String urunAdi;

    @Column(name = "u_barkodu")
    private String urunBarkodu;

    @Column(name = "u_uretim_tarihi")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date urunUretimTarihi;

    @Column(name = "u_tuketim_tarihi")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date urunTuketimTarihi;

    @Column(name = "u_fiyat")
    private String urunFiyat;

    @Column(name = "u_agirlik")
    private String urunAgirlik;

    @Column(name = "u_rengi")
    private String urunRengi;

    @Column(name = "marka_id")
    private int markaId;

    @Column(name = "kategori_id")
    private int kategoriId;

    @Column(name = "stok_id")
    private int stokId;




}
