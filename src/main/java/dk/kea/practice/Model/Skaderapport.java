package dk.kea.practice.Model;

public class Skaderapport {

    private int id;
    private int vognnummer;
    private int userId;
    private Integer xtraKm; // Can be null
    private double totalSkadePris;
    private String createdAt;
    private String updatedAt;


    public Skaderapport() {
    }

    public Skaderapport(String createdAt, int id, double totalSkadePris, String updatedAt, int userId, int vognnummer, Integer xtraKm) {
        this.createdAt = createdAt;
        this.id = id;
        this.totalSkadePris = totalSkadePris;
        this.updatedAt = updatedAt;
        this.userId = userId;
        this.vognnummer = vognnummer;
        this.xtraKm = xtraKm;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getVognnummer() {
        return vognnummer;
    }

    public void setVognnummer(int vognnummer) {
        this.vognnummer = vognnummer;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public Integer getXtraKm() {
        return xtraKm;
    }

    public void setXtraKm(Integer xtraKm) {
        this.xtraKm = xtraKm;
    }

    public double getTotalSkadePris() {
        return totalSkadePris;
    }

    public void setTotalSkadePris(double totalSkadePris) {
        this.totalSkadePris = totalSkadePris;
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
        return "Skaderapport{" +
                "createdAt='" + createdAt + '\'' +
                ", id=" + id +
                ", vognnummer=" + vognnummer +
                ", userId=" + userId +
                ", xtraKm=" + xtraKm +
                ", totalSkadePris=" + totalSkadePris +
                ", updatedAt='" + updatedAt + '\'' +
                '}';
    }
}

