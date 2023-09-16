package vn.edu.iuh.fit.models;

public class GrantAccess {
    private Role roleId;
    private Account accountId;
    private isGrant isGrant;
    private String note;

    public GrantAccess() {
    }

    public GrantAccess(Role roleId, Account accountId) {
        this.roleId = roleId;
        this.accountId = accountId;
    }

    public GrantAccess(vn.edu.iuh.fit.models.isGrant isGrant, String note) {
        this.isGrant = isGrant;
        this.note = note;
    }

    public GrantAccess(Role roleId, Account accountId, vn.edu.iuh.fit.models.isGrant isGrant, String note) {
        this.roleId = roleId;
        this.accountId = accountId;
        this.isGrant = isGrant;
        this.note = note;
    }

    public Role getRoleId() {
        return roleId;
    }

    public void setRoleId(Role roleId) {
        this.roleId = roleId;
    }

    public Account getAccountId() {
        return accountId;
    }

    public void setAccountId(Account accountId) {
        this.accountId = accountId;
    }

    public vn.edu.iuh.fit.models.isGrant getIsGrant() {
        return isGrant;
    }

    public void setIsGrant(vn.edu.iuh.fit.models.isGrant isGrant) {
        this.isGrant = isGrant;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "GrantAccess{" +
                "roleId=" + roleId +
                ", accountId=" + accountId +
                ", isGrant=" + isGrant +
                ", note='" + note + '\'' +
                '}';
    }
}
