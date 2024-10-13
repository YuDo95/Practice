package dk.kea.practice.Model;

import java.time.LocalDate;

public class Lejeaftale {
    private int lejeaftaleId;         // Primary key
    private int bilVognnummer;         // Foreign key reference to Bil
    private int userId;                // Foreign key reference to User
    private LocalDate startdato;          // Start date of the rental in String format (e.g., "YYYY-MM-DD")
    private LocalDate slutdato;           // End date of the rental in String format (e.g., "YYYY-MM-DD")
    private double pris;               // Rental price
    private int aftaltKm;              // Agreed kilometers
    private Integer slutKm;            // Ending kilometers
    private boolean overkoerteKm;      // Flag for exceeded kilometers
    private LocalDate createdAt;           // Record creation timestamp in String format
    private LocalDate updatedAt;           // Record update timestamp in String format

    // Default constructor
    public Lejeaftale() {
    }

    // Parameterized constructor for form inputs
    public Lejeaftale(int bilVognnummer, int userId, LocalDate startdato, LocalDate slutdato, double pris,
                      int aftaltKm) {
        this.bilVognnummer = bilVognnummer;
        this.userId = userId;
        this.startdato = startdato;
        this.slutdato = slutdato;
        this.pris = pris;
        this.aftaltKm = aftaltKm;
        this.slutKm = null;           // Default to null for optional field
        this.overkoerteKm = false;    // Default to false for boolean field
    }

    // Getters and setters
    public int getLejeaftaleId() {
        return lejeaftaleId;
    }

    public void setLejeaftaleId(int lejeaftaleId) {
        this.lejeaftaleId = lejeaftaleId;
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

    public LocalDate getStartdato() {
        return startdato;
    }

    public void setStartdato(LocalDate startdato) {
        this.startdato = startdato;
    }

    public LocalDate getSlutdato() {
        return slutdato;
    }

    public void setSlutdato(LocalDate slutdato) {
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

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDate updatedAt) {
        this.updatedAt = updatedAt;
    }
}
