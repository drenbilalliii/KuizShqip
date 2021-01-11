package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "KuizeTeLuajtura", schema = "dbo", catalog = "kuiziDatabase")
public class KuizeTeLuajturaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "KuizeTeLuajturaID")
    private int kuizeTeLuajturaId;
    @Basic
    @Column(name = "EmriLojtarit")
    private String emriLojtarit;
    @JoinColumn(name = "KuiziID", referencedColumnName = "KuiziID")
    @ManyToOne(optional = false)
    private KuiziEntity kuiziEntity;

    @Id
    @Column(name = "KuizeTeLuajturaID")
    public int getKuizeTeLuajturaId() {
        return kuizeTeLuajturaId;
    }

    public void setKuizeTeLuajturaId(int kuizeTeLuajturaId) {
        this.kuizeTeLuajturaId = kuizeTeLuajturaId;
    }


    public String getEmriLojtarit() {
        return emriLojtarit;
    }

    public void setEmriLojtarit(String emriLojtarit) {
        this.emriLojtarit = emriLojtarit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        KuizeTeLuajturaEntity that = (KuizeTeLuajturaEntity) o;

        if (kuizeTeLuajturaId != that.kuizeTeLuajturaId) return false;
        if (emriLojtarit != null ? !emriLojtarit.equals(that.emriLojtarit) : that.emriLojtarit != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = kuizeTeLuajturaId;
        result = 31 * result + (emriLojtarit != null ? emriLojtarit.hashCode() : 0);
        return result;
    }
}
