package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

/**
  *
  * @author Dren Bilalli on 1/8/2021
  *
*/

@Entity
@Table(name = "Kuizi", schema = "dbo", catalog = "kuizDatabase")
public class Kuizi {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KuiziID")
    private int kuiziId;
    @Basic
    @Column(name = "EmriKuizit")
    private String emriKuizit;
    @Basic
    @Column(name = "Pyetja")
    private String pyetja;
    @Basic
    @Column(name = "OpsioniA")
    private String opsioniA;
    @Basic
    @Column(name = "OpsioniB")
    private String opsioniB;
    @Basic
    @Column(name = "OpsioniC")
    private String opsioniC;
    @Basic
    @Column(name = "OpcioniD")
    private String opcioniD;
    @Basic
    @Column(name = "OpsioniSakt")
    private String opsioniSakt;
    @Basic
    @Column(name = "KrijuesiKuizit")
    private String krijuesiKuizit;
    @Basic
    @Column(name = "PiketEKuizit")
    private Integer piketEKuizit;

    public Kuizi(){}

    public static void main(String[]args){


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


    public String getPyetja() {
        return pyetja;
    }

    public void setPyetja(String pyetja) {
        this.pyetja = pyetja;
    }

    public String getOpsioniA() {
        return opsioniA;
    }

    public void setOpsioniA(String opsioniA) {
        this.opsioniA = opsioniA;
    }


    public String getOpsioniB() {
        return opsioniB;
    }

    public void setOpsioniB(String opsioniB) {
        this.opsioniB = opsioniB;
    }


    public String getOpsioniC() {
        return opsioniC;
    }

    public void setOpsioniC(String opsioniC) {
        this.opsioniC = opsioniC;
    }


    public String getOpcioniD() {
        return opcioniD;
    }

    public void setOpcioniD(String opcioniD) {
        this.opcioniD = opcioniD;
    }


    public String getOpsioniSakt() {
        return opsioniSakt;
    }

    public void setOpsioniSakt(String opsioniSakt) {
        this.opsioniSakt = opsioniSakt;
    }


    public String getKrijuesiKuizit() {
        return krijuesiKuizit;
    }

    public void setKrijuesiKuizit(String krijuesiKuizit) {
        this.krijuesiKuizit = krijuesiKuizit;
    }


    public Integer getPiketEKuizit() {
        return piketEKuizit;
    }

    public void setPiketEKuizit(Integer piketEKuizit) {
        this.piketEKuizit = piketEKuizit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Kuizi that = (Kuizi) o;
        return kuiziId == that.kuiziId &&
                Objects.equals(emriKuizit, that.emriKuizit) &&
                Objects.equals(pyetja, that.pyetja) &&
                Objects.equals(opsioniA, that.opsioniA) &&
                Objects.equals(opsioniB, that.opsioniB) &&
                Objects.equals(opsioniC, that.opsioniC) &&
                Objects.equals(opcioniD, that.opcioniD) &&
                Objects.equals(opsioniSakt, that.opsioniSakt) &&
                Objects.equals(krijuesiKuizit, that.krijuesiKuizit) &&
                Objects.equals(piketEKuizit, that.piketEKuizit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(kuiziId, emriKuizit, pyetja, opsioniA, opsioniB, opsioniC, opcioniD, opsioniSakt, krijuesiKuizit, piketEKuizit);
    }
}
