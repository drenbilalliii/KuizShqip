package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Dren Bilalli on 1/9/2021
 */

@Entity
@Table(name = "Pyetja", schema = "dbo", catalog = "kuizDatabase")
public class PyetjaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int pyetjaId;
    @Basic
    @Column(name = "emripyetjes")
    private String emriPyetjes;
    @Basic
    @Column(name = "opsionia")
    private String opsioniA;
    @Basic
    @Column(name = "opsionib")
    private String opsioniB;
    @Basic
    @Column(name = "opsionic")
    private String opsioniC;
    @Basic
    @Column(name = "opsionid")
    private String opsioniD;
    @Basic
    @Column(name = "opsionisakt")
    private String opsioniSakt;
    @Basic
    @Column(name = "piket")
    private Integer piket;
    @JoinColumn(name = "KuiziID", referencedColumnName = "KuiziID")
    @ManyToOne(optional = false)
    private KuiziEntity kuiziEntity;

    public PyetjaEntity() {
    }




    public int getPyetjaId() {
        return pyetjaId;
    }

    public void setPyetjaId(int pyetjaId) {
        this.pyetjaId = pyetjaId;
    }


    public String getEmriPyetjes() {
        return emriPyetjes;
    }

    public void setEmriPyetjes(String emriPyetjes) {
        this.emriPyetjes = emriPyetjes;
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


    public String getOpsioniD() {
        return opsioniD;
    }

    public void setOpsioniD(String opsioniD) {
        this.opsioniD = opsioniD;
    }


    public String getOpsioniSakt() {
        return opsioniSakt;
    }

    public void setOpsioniSakt(String opsioniSakt) {
        this.opsioniSakt = opsioniSakt;
    }



    public Integer getPiket() {
        return piket;
    }

    public void setPiket(Integer piket) {
        this.piket = piket;
    }

    public KuiziEntity getKuiziEntity(){
        return kuiziEntity;
    }
    public void setKuiziEntity(KuiziEntity kuiziEntity){
        this.kuiziEntity = kuiziEntity;
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
