package model;
import java.time.LocalDate;

public class Member {
    private Integer id;
    private String name;
    private String surname;
    private String fin;
    private String passwordNumber;
    private Integer departures;
    private Integer amount;
    private LocalDate expirationDate;
    private Integer rowInfoId;
    private LocalDate registerDate;
    private LocalDate updateDate;
    private Integer status;


    public Member(String name, String surname, String fin, String passwordNumber, Integer departures, Integer amount, LocalDate expirationDate) {
        this.name = name;
        this.surname = surname;
        this.fin = fin;
        this.passwordNumber = passwordNumber;
        this.departures = departures;
        this.amount = amount;
        this.expirationDate = expirationDate;
    }

    public Member(String name, String surname, String fin, String passwordNumber, Integer departures, Integer amount, LocalDate expirationDate, LocalDate registerDate, LocalDate updateDate) {
        this.name = name;
        this.surname = surname;
        this.fin = fin;
        this.passwordNumber = passwordNumber;
        this.departures = departures;
        this.amount = amount;
        this.expirationDate = expirationDate;
        this.registerDate = registerDate;
        this.updateDate = updateDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public String getPasswordNumber() {
        return passwordNumber;
    }

    public void setPasswordNumber(String passwordNumber) {
        this.passwordNumber = passwordNumber;
    }

    public Integer getDepartures() {
        return departures;
    }

    public void setDepartures(Integer departures) {
        this.departures = departures;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getRowInfoId() {
        return rowInfoId;
    }

    public void setRowInfoId(Integer rowInfoId) {
        this.rowInfoId = rowInfoId;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    public LocalDate getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(LocalDate updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", fin='" + fin + '\'' +
                ", passwordNumber='" + passwordNumber + '\'' +
                ", departures=" + departures +
                ", amount=" + amount +
                ", expirationDate=" + expirationDate +
                ", registerDate=" + registerDate +
                ", updateDate=" + updateDate +
                '}';
    }
}
