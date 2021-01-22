package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Dren Bilalli on 1/23/2021
 */

@Entity
@Table(name = "Perdoruesi", schema = "dbo", catalog = "kuizDatabase")
public class PerdoruesiEntity {

    private int perdoruesiId;
    private String username;
    private String emri;
    private String mbiemri;
    private String email;
    private String password;

    public PerdoruesiEntity() {
    }

    public static void main(String[] args) {


    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "perdoruesi_id")
    public int getPerdoruesiId() {
        return perdoruesiId;
    }

    public void setPerdoruesiId(int perdoruesiId) {
        this.perdoruesiId = perdoruesiId;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "emri")
    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    @Basic
    @Column(name = "mbiemri")
    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "password")
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
    public String toString() {
        return "PerdoruesiEntity{" +
                "emri='" + emri + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(perdoruesiId, username, emri, mbiemri, email, password);
    }
}
