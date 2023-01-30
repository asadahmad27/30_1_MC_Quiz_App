package com.example.myapplication20230130;

public class Student {
    String Date;
    String fajar, zuhr, asar, maghrib, isha;
    String f_count, z_count, a_count, m_count, i_count;


    public Student(String date, String fajar, String zuhr, String asar, String maghrib, String isha, String f_count, String z_count, String a_count, String m_count, String i_count) {
        Date = date;
        this.fajar = fajar;
        this.zuhr = zuhr;
        this.asar = asar;
        this.maghrib = maghrib;
        this.isha = isha;
        this.f_count = f_count;
        this.z_count = z_count;
        this.a_count = a_count;
        this.m_count = m_count;
        this.i_count = i_count;
    }

    @Override
    public String toString() {
        return "Student{" +
                "Date='" + Date + '\'' +
                ", fajar='" + fajar + '\'' +
                ", f_count='" + f_count + '\'' +
                ", zuhr='" + zuhr + '\'' +
                ", z_count='" + z_count + '\'' +
                ", asar='" + asar + '\'' +
                ", a_count='" + a_count + '\'' +
                ", maghrib='" + maghrib + '\'' +
                ", m_count='" + m_count + '\'' +
                ", isha='" + isha + '\'' +
                ", i_count='" + i_count + '\'' +
                '}';
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String date) {
        Date = date;
    }

    public String getFajar() {
        return fajar;
    }

    public void setFajar(String fajar) {
        this.fajar = fajar;
    }

    public String getZuhr() {
        return zuhr;
    }

    public void setZuhr(String zuhr) {
        this.zuhr = zuhr;
    }

    public String getAsar() {
        return asar;
    }

    public void setAsar(String asar) {
        this.asar = asar;
    }

    public String getMaghrib() {
        return maghrib;
    }

    public void setMaghrib(String maghrib) {
        this.maghrib = maghrib;
    }

    public String getIsha() {
        return isha;
    }

    public void setIsha(String isha) {
        this.isha = isha;
    }

    public String getF_count() {
        return f_count;
    }

    public void setF_count(String f_count) {
        this.f_count = f_count;
    }

    public String getZ_count() {
        return z_count;
    }

    public void setZ_count(String z_count) {
        this.z_count = z_count;
    }

    public String getA_count() {
        return a_count;
    }

    public void setA_count(String a_count) {
        this.a_count = a_count;
    }

    public String getM_count() {
        return m_count;
    }

    public void setM_count(String m_count) {
        this.m_count = m_count;
    }

    public String getI_count() {
        return i_count;
    }

    public void setI_count(String i_count) {
        this.i_count = i_count;
    }
}
