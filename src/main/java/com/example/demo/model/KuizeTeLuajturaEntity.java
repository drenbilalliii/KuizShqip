package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Dren Bilalli on 1/19/2021
 */

@Entity
@Table(name = "Kuizeteluajtura", schema = "dbo", catalog = "kuizDatabase")
public class KuizeteluajturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KuizeteluajturaID")
    private int kuizeteluajturaId;
    @Basic
    @Column(name = "Lojetari")
    private String lojetari;
    @Basic
    @Column(name = "Piket")
    private Integer piket;
    @JoinColumn(name = "KuiziID", referencedColumnName = "KuiziID")
    @ManyToOne(optional = true)
    private KuiziEntity kuiziEntity;

    public KuizeteluajturaEntity() {
    }

    public static void main(String[] args) {


    }


    public int getKuizeteluajturaId() {
        return kuizeteluajturaId;
    }

    public void setKuizeteluajturaId(int kuizeteluajturaId) {
        this.kuizeteluajturaId = kuizeteluajturaId;
    }


    public String getLojetari() {
        return lojetari;
    }

    public void setLojetari(String lojetari) {
        this.lojetari = lojetari;
    }


    public Integer getPiket() {
        return piket;
    }

    public void setPiket(Integer piket) {
        this.piket = piket;
    }


    public KuiziEntity getKuiziEntity() {
        return kuiziEntity;
    }

    public void setKuiziEntity(KuiziEntity kuiziEntity) {
        this.kuiziEntity = kuiziEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KuizeteluajturaEntity that = (KuizeteluajturaEntity) o;
        return kuizeteluajturaId == that.kuizeteluajturaId &&
                Objects.equals(lojetari, that.lojetari) &&
                Objects.equals(piket, that.piket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kuizeteluajturaId, lojetari, piket);
    }
}
