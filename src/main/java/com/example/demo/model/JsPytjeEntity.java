package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Dren Bilalli on 1/12/2021
 */

@Entity
@Table(name = "js_pytje")
public class JsPytjeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PyetjaID")
    private int pyetjaId;
    @Basic
    @Column(name = "kodi")
    private String kodi;
    @Basic
    @Column(name = "metoda")
    private String metoda;
    @Basic
    @Column(name = "piketpytjes")
    private Integer piketPytjes;
    @Basic
    @Column(name="Pergjigjja")
    private String pergjigja;
    @JoinColumn(name = "KuiziID", referencedColumnName = "KuiziID")
    @ManyToOne(optional = false)
    private KuiziEntity kuiziEntity;

    public JsPytjeEntity() {
    }

    public static void main(String[] args) {


    }


    public int getPyetjaId() {
        return pyetjaId;
    }

    public void setPyetjaId(int pyetjaId) {
        this.pyetjaId = pyetjaId;
    }


    public String getKodi() {
        return kodi;
    }

    public void setKodi(String kodi) {
        this.kodi = kodi;
    }


    public String getMetoda() {
        return metoda;
    }

    public void setMetoda(String metoda) {
        this.metoda = metoda;
    }


    public Integer getPiketPytjes() {
        return piketPytjes;
    }

    public void setPiketPytjes(Integer piketPytjes) {
        this.piketPytjes = piketPytjes;
    }

    public KuiziEntity getKuiziEntity() {
        return kuiziEntity;
    }

    public String getPergjigja() {
        return pergjigja;
    }

    public void setPergjigja(String pergjigja) {
        this.pergjigja = pergjigja;
    }

    public void setKuiziEntity(KuiziEntity kuiziEntity) {
        this.kuiziEntity = kuiziEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        JsPytjeEntity that = (JsPytjeEntity) o;
        return pyetjaId == that.pyetjaId &&
                Objects.equals(kodi, that.kodi) &&
                Objects.equals(metoda, that.metoda) &&
                Objects.equals(piketPytjes, that.piketPytjes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pyetjaId, kodi, metoda, piketPytjes);
    }
}
