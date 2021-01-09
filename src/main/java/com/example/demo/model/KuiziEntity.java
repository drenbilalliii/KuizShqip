package com.example.demo.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;

/**
 * @author Dren Bilalli on 1/9/2021
 */

@Entity
@Table(name = "Kuizi", schema = "dbo", catalog = "kuizDatabase")
public class KuiziEntity {

    private int kuiziId;
    private String emriKuizit;
    private Date dataKuizit;
    private String kategoria;

    public KuiziEntity() {
    }

    public static void main(String[] args) {


    }

    @Id
    @Column(name = "KuiziID")
    public int getKuiziId() {
        return kuiziId;
    }

    public void setKuiziId(int kuiziId) {
        this.kuiziId = kuiziId;
    }

    @Basic
    @Column(name = "EmriKuizit")
    public String getEmriKuizit() {
        return emriKuizit;
    }

    public void setEmriKuizit(String emriKuizit) {
        this.emriKuizit = emriKuizit;
    }

    @Basic
    @Column(name = "DataKuizit")
    public Date getDataKuizit() {
        return dataKuizit;
    }

    public void setDataKuizit(Date dataKuizit) {
        this.dataKuizit = dataKuizit;
    }

    @Basic
    @Column(name = "Kategoria")
    public String getKategoria() {
        return kategoria;
    }

    public void setKategoria(String kategoria) {
        this.kategoria = kategoria;
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
    public int hashCode() {
        return Objects.hash(kuiziId, emriKuizit, dataKuizit, kategoria);
    }
}
