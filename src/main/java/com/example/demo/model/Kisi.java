package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "kisi", uniqueConstraints = @UniqueConstraint(name = "username_uc"
        , columnNames = "kullaniciAdi"))
public class Kisi {
    private Long id;
    private Date dogum_tarihi;
    private String isim;
    private String soyisim;
    private Set<Etkinlik> etkinlikSet;

    @Column(unique = true)
    private String kullaniciAdi;

    private String password;
    private Set<Agac> satin_alinan_agacSet;

    @Id
    @Column(name = "id", columnDefinition = "serial")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDogum_tarihi() {
        return dogum_tarihi;
    }

    public void setDogum_tarihi(Date dogum_tarihi) {
        this.dogum_tarihi = dogum_tarihi;
    }

    public String getIsim() {
        return isim;
    }

    public void setIsim(String isim) {
        this.isim = isim;
    }

    public String getSoyisim() {
        return soyisim;
    }

    public void setSoyisim(String soyisim) {
        this.soyisim = soyisim;
    }

    public String getKullaniciAdi() {
        return kullaniciAdi;
    }

    public void setKullaniciAdi(String kullaniciAdi) {
        this.kullaniciAdi = kullaniciAdi;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @OneToMany(mappedBy = "satin_alan_kisi", cascade = CascadeType.ALL)
    public Set<Agac> getSatin_alinan_agacSet() {
        return satin_alinan_agacSet;
    }

    public void setSatin_alinan_agacSet(Set<Agac> satin_alinan_agacSet) {
        this.satin_alinan_agacSet = satin_alinan_agacSet;
    }

    @ManyToMany(mappedBy = "kisiSet")
    public Set<Etkinlik> getEtkinlikSet() {
        return etkinlikSet;
    }

    public void setEtkinlikSet(Set<Etkinlik> etkinlikSet) {
        this.etkinlikSet = etkinlikSet;
    }
}

