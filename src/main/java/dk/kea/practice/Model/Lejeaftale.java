package dk.kea.practice.Model;

public class Lejeaftale {

    private int id;
    private int bilVognnummer;
    private int userId;
    private String startdato;
    private String slutdato;
    private double pris;
    private int aftaltKm;
    private int slutKm; // Can be null
    private boolean overkoerteKm;
    private String createdAt;
    private String updatedAt;


    public Lejeaftale() {
    }

    public Lejeaftale(int aftaltKm, int bilVognnummer, String createdAt, int id, boolean overkoerteKm, double pris, String slutdato, Integer slutKm, String startdato, String updatedAt, int userId) {
        this.aftaltKm = aftaltKm;
        this.bilVognnummer = bilVognnummer;
        this.createdAt = createdAt;
        this.id = id;
        this.overkoerteKm = overkoerteKm;
        this.pris = pris;
        this.slutdato = slutdato;
        this.slutKm = slutKm;
        this.startdato = startdato;
        this.updatedAt = updatedAt;
        this.userId = userId;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBilVognnummer() {
        return bilVognnummer;
    }

    public void setBilVognnummer(int bilVognnummer) {
        this.bilVognnummer = bilVognnummer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getStartdato() {
        return startdato;
    }

    public void setStartdato(String startdato) {
        this.startdato = startdato;
    }

    public String getSlutdato() {
        return slutdato;
    }

    public void setSlutdato(String slutdato) {
        this.slutdato = slutdato;
    }

    public double getPris() {
        return pris;
    }

    public void setPris(double pris) {
        this.pris = pris;
    }

    public int getAftaltKm() {
        return aftaltKm;
    }

    public void setAftaltKm(int aftaltKm) {
        this.aftaltKm = aftaltKm;
    }

    public Integer getSlutKm() {
        return slutKm;
    }

    public void setSlutKm(Integer slutKm) {
        this.slutKm = slutKm;
    }

    public boolean isOverkoerteKm() {
        return overkoerteKm;
    }

    public void setOverkoerteKm(boolean overkoerteKm) {
        this.overkoerteKm = overkoerteKm;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "Lejeaftale{" +
                "aftaltKm=" + aftaltKm +
                ", id=" + id +
                ", bilVognnummer=" + bilVognnummer +
                ", userId=" + userId +
                ", startdato='" + startdato + '\'' +
                ", slutdato='" + slutdato + '\'' +
                ", pris=" + pris +
                ", slutKm=" + slutKm +
                ", overkoerteKm=" + overkoerteKm +
                ", createdAt='" + createdAt + '\'' +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}
