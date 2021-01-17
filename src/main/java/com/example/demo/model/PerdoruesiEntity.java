package com.example.demo.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * author Gramos Shala
 */

@Entity
@Table(name = "Perdoruesi", schema = "dbo", catalog = "kuiziDatabase")
public class PerdoruesiEntity {
    private int perdoruesiId;
    private String username;
    private String emri;
    private String mbiemri;
    private String email;
    private String password;

    @Id
    @Column(name = "PerdoruesiID")
    public int getPerdoruesiId() {
        return perdoruesiId;
    }

    public void setPerdoruesiId(int perdoruesiId) {
        this.perdoruesiId = perdoruesiId;
    }

    @Basic
    @Column(name = "Username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "Emri")
    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    @Basic
    @Column(name = "Mbiemri")
    public String getMbiemri() {
        return mbiemri;
    }

    public void setMbiemri(String mbiemri) {
        this.mbiemri = mbiemri;
    }

    @Basic
    @Column(name = "Email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "Password")
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
