package org.example.entity;

import javax.persistence.*;

public class Class1 {

    private int id;

    private String firstLine;

    private String saldoInActiv;

    private String saldoInPassiv;

    private String debit;

    private String credit;

    private String saldoOutActiv;

    private String saldoOutPassiv;

    public Class1(String firstLine, String saldoInActiv, String saldoInPassiv, String debit, String credit, String saldoOutActiv, String saldoOutPassiv) {
        this.firstLine = firstLine;
        this.saldoInActiv = saldoInActiv;
        this.saldoInPassiv = saldoInPassiv;
        this.debit = debit;
        this.credit = credit;
        this.saldoOutActiv = saldoOutActiv;
        this.saldoOutPassiv = saldoOutPassiv;
    }

    public Class1() {

    }

    public String getFirstLine() {
        return firstLine;
    }

    public void setFirstLine(String firstLine) {
        this.firstLine = firstLine;
    }

    public String getSaldoInActiv() {
        return saldoInActiv;
    }

    public void setSaldoInActiv(String saldoInActiv) {
        this.saldoInActiv = saldoInActiv;
    }

    public String getSaldoInPassiv() {
        return saldoInPassiv;
    }

    public void setSaldoInPassiv(String saldoInPassiv) {
        this.saldoInPassiv = saldoInPassiv;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    public String getSaldoOutActiv() {
        return saldoOutActiv;
    }

    public void setSaldoOutActiv(String saldoOutActiv) {
        this.saldoOutActiv = saldoOutActiv;
    }

    public String getSaldoOutPassiv() {
        return saldoOutPassiv;
    }

    public void setSaldoOutPassiv(String saldoOutPassiv) {
        this.saldoOutPassiv = saldoOutPassiv;
    }

    @Override
    public String toString() {
        return "Class1{" +
                "firstLine='" + firstLine + '\'' +
                ", saldoInActiv='" + saldoInActiv + '\'' +
                ", saldoInPassiv='" + saldoInPassiv + '\'' +
                ", debit='" + debit + '\'' +
                ", credit='" + credit + '\'' +
                ", saldoOutActiv='" + saldoOutActiv + '\'' +
                ", saldoOutPassiv='" + saldoOutPassiv + '\'' +
                '}';
    }
}
