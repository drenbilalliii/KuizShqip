package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @author Dren Bilalli on 1/9/2021
 */

@Entity
@Table(name = "Kuizi")
public class KuiziEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KuiziID")
    private int kuiziId;
    @Basic
    @Column(name = "emri_kuizit")
    private String emriKuizit;
    @Basic
    @Column(name = "datakuizit")
    private Date dataKuizit;
    @Basic
    @Column(name = "kategoria")
    private String kategoria;
    @Basic
    @Column(name = "Administratori")
    private String administatori;



    public KuiziEntity() {
    }

    public static void main(String[] args) {


    }


    public int getKuiziId() {
        return kuiziId;
    }

    public void setKuiziId(int kuiziId) {
        this.kuiziId = kuiziId;
    }


    public String getEmriKuizit() {
        return emriKuizit;
    }

    public void setEmriKuizit(String emriKuizit) {
        this.emriKuizit = emriKuizit;
    }


    public Date getDataKuizit() {
        return dataKuizit;
    }

    public void setDataKuizit(Date dataKuizit) {
        this.dataKuizit = dataKuizit;
    }


    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
    }


    public String getAdministatori() {
        return administatori;
    }

    public void setAdministatori(String administatori) {
        this.administatori = administatori;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KuiziEntity that = (KuiziEntity) o;
        return kuiziId == that.kuiziId &&
                Objects.equals(emriKuizit, that.emriKuizit) &&
                Objects.equals(dataKuizit, that.dataKuizit) &&
                Objects.equals(kategoria, that.kategoria);
    }



    @Override
    public String toString() {
        return emriKuizit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(kuiziId, emriKuizit, dataKuizit, kategoria);
    }
}
