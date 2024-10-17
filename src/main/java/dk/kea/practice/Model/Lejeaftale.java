package dk.kea.practice.Model;

import java.time.LocalDate;

public class Lejeaftale {
    private int lejeaftaleId;
    private int bilVognnummer;
    private int userId;
    private LocalDate startdato;
    private LocalDate slutdato;
    private double pris;
    private int aftaltKm;
    private Integer slutKm;
    private boolean overkoerteKm;
    private LocalDate createdAt;
    private LocalDate updatedAt;


    public Lejeaftale() {}


    public Lejeaftale(int bilVognnummer, int userId, LocalDate startdato, LocalDate slutdato, double pris, int aftaltKm)
    {
        this.bilVognnummer = bilVognnummer;
        this.userId = userId;
        this.startdato = startdato;
        this.slutdato = slutdato;
        this.pris = pris;
        this.aftaltKm = aftaltKm;
        this.slutKm = null;
        this.overkoerteKm = false;
    }


    // Getters and setters
    public int getLejeaftaleId() {return lejeaftaleId;}

    public void setLejeaftaleId(int lejeaftaleId) {this.lejeaftaleId = lejeaftaleId;}

    public int getBilVognnummer() {return bilVognnummer;}

    public void setBilVognnummer(int bilVognnummer) {this.bilVognnummer = bilVognnummer;}

    public int getUserId() {return userId;}

    public void setUserId(int userId) {this.userId = userId;}

    public LocalDate getStartdato() {return startdato;}

    public void setStartdato(LocalDate startdato) {this.startdato = startdato;}

    public LocalDate getSlutdato() {return slutdato;}

    public void setSlutdato(LocalDate slutdato) {this.slutdato = slutdato;}

    public double getPris() {return pris;}

    public void setPris(double pris) {this.pris = pris;}

    public int getAftaltKm() {return aftaltKm;}

    public void setAftaltKm(int aftaltKm) {this.aftaltKm = aftaltKm;}

    public Integer getSlutKm() {return slutKm;}

    public void setSlutKm(Integer slutKm) {this.slutKm = slutKm;}

    public boolean isOverkoerteKm() {return overkoerteKm;}

    public void setOverkoerteKm(boolean overkoerteKm) {this.overkoerteKm = overkoerteKm;}

    public LocalDate getCreatedAt() {return createdAt;}

    public void setCreatedAt(LocalDate createdAt) {this.createdAt = createdAt;}

    public LocalDate getUpdatedAt() {return updatedAt;}

    public void setUpdatedAt(LocalDate updatedAt) {this.updatedAt = updatedAt;}


    @Override
    public String toString()
    {
        return "Lejeaftale{" +
                "aftaltKm=" + aftaltKm +
                ", lejeaftaleId=" + lejeaftaleId +
                ", bilVognnummer=" + bilVognnummer +
                ", userId=" + userId +
                ", startdato=" + startdato +
                ", slutdato=" + slutdato +
                ", pris=" + pris +
                ", slutKm=" + slutKm +
                ", overkoerteKm=" + overkoerteKm +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }

}
