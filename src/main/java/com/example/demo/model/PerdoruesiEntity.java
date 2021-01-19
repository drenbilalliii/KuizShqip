package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * author Gramos Shala
 */

@Entity
@Table(name = "Perdoruesi")
public class PerdoruesiEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "PerdoruesiID")
    private int perdoruesiId;
    @Basic
    @Column(name = "username")
    private String username;
    @Basic
    @Column(name = "emri")
    private String emri;
    @Basic
    @Column(name = "mbiemri")
    private String mbiemri;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "password")
    private String password;


    public int getPerdoruesiId() {
        return perdoruesiId;
    }

    public void setPerdoruesiId(int perdoruesiId) {
        this.perdoruesiId = perdoruesiId;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }


    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }


    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PerdoruesiEntity that = (PerdoruesiEntity) o;
        return perdoruesiId == that.perdoruesiId &&
                Objects.equals(username, that.username) &&
                Objects.equals(emri, that.emri) &&
                Objects.equals(mbiemri, that.mbiemri) &&
                Objects.equals(email, that.email) &&
                Objects.equals(password, that.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(perdoruesiId, username, emri, mbiemri, email, password);
    }
}
