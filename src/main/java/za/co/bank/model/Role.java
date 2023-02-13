package za.co.bank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {

    @Id
    private long roleID;

    @Column(length = 60)
    private String name;

    public Role() {
    }

    public Role(long roleID, String name) {
        this.roleID = roleID;
        this.name = name;
    }

    public long getRoleID() {
        return roleID;
    }

    public void setRoleID(long roleID) {
        this.roleID = roleID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
