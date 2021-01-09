package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Dren Bilalli on 1/9/2021
 */

@Entity
@Table(name = "Pyetja", schema = "dbo", catalog = "kuizDatabase")
public class PyetjaEntity {

    private int pyetjaId;
    private String emriPyetjes;
    private String opsioniA;
    private String opsioniB;
    private String opsioniC;
    private String opsioniD;
    private String opsioniSakt;
    private Integer piket;

    public PyetjaEntity() {
    }

    public static void main(String[] args) {


    }

    @Id
    @Column(name = "PyetjaID")
    public int getPyetjaId() {
        return pyetjaId;
    }

    public void setPyetjaId(int pyetjaId) {
        this.pyetjaId = pyetjaId;
    }

    @Basic
    @Column(name = "EmriPyetjes")
    public String getEmriPyetjes() {
        return emriPyetjes;
    }

    public void setEmriPyetjes(String emriPyetjes) {
        this.emriPyetjes = emriPyetjes;
    }

    @Basic
    @Column(name = "OpsioniA")
    public String getOpsioniA() {
        return opsioniA;
    }

    public void setOpsioniA(String opsioniA) {
        this.opsioniA = opsioniA;
    }

    @Basic
    @Column(name = "OpsioniB")
    public String getOpsioniB() {
        return opsioniB;
    }

    public void setOpsioniB(String opsioniB) {
        this.opsioniB = opsioniB;
    }

    @Basic
    @Column(name = "OpsioniC")
    public String getOpsioniC() {
        return opsioniC;
    }

    public void setOpsioniC(String opsioniC) {
        this.opsioniC = opsioniC;
    }

    @Basic
    @Column(name = "OpsioniD")
    public String getOpsioniD() {
        return opsioniD;
    }

    public void setOpsioniD(String opsioniD) {
        this.opsioniD = opsioniD;
    }

    @Basic
    @Column(name = "OpsioniSakt")
    public String getOpsioniSakt() {
        return opsioniSakt;
    }

    public void setOpsioniSakt(String opsioniSakt) {
        this.opsioniSakt = opsioniSakt;
    }

    @Basic
    @Column(name = "Piket")
    public Integer getPiket() {
        return piket;
    }

    public void setPiket(Integer piket) {
        this.piket = piket;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PyetjaEntity that = (PyetjaEntity) o;
        return pyetjaId == that.pyetjaId &&
                Objects.equals(emriPyetjes, that.emriPyetjes) &&
                Objects.equals(opsioniA, that.opsioniA) &&
                Objects.equals(opsioniB, that.opsioniB) &&
                Objects.equals(opsioniC, that.opsioniC) &&
                Objects.equals(opsioniD, that.opsioniD) &&
                Objects.equals(opsioniSakt, that.opsioniSakt) &&
                Objects.equals(piket, that.piket);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pyetjaId, emriPyetjes, opsioniA, opsioniB, opsioniC, opsioniD, opsioniSakt, piket);
    }
}
