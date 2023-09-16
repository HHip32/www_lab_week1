package vn.edu.iuh.fit.models;

import java.time.LocalDateTime;

public class Logs {
    private long id;
    private Account accountId;
    private LocalDateTime loginTime;
    private LocalDateTime logoutTime;
    private String notes;

    public Logs() {
    }

    public Logs(long id) {
        this.id = id;
    }

    public Logs(Account accountId, LocalDateTime loginTime, LocalDateTime logoutTime, String notes) {
        this.accountId = accountId;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.notes = notes;
    }

    public Logs(long id, Account accountId, LocalDateTime loginTime, LocalDateTime logoutTime, String notes) {
        this.id = id;
        this.accountId = accountId;
        this.loginTime = loginTime;
        this.logoutTime = logoutTime;
        this.notes = notes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public LocalDateTime getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(LocalDateTime loginTime) {
        this.loginTime = loginTime;
    }

    public LocalDateTime getLogoutTime() {
        return logoutTime;
    }

    public void setLogoutTime(LocalDateTime logoutTime) {
        this.logoutTime = logoutTime;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public String toString() {
        return "Logs{" +
                "id=" + id +
                ", accountId=" + accountId +
                ", loginTime=" + loginTime +
                ", logoutTime=" + logoutTime +
                ", notes='" + notes + '\'' +
                '}';
    }
}
