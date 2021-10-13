package models;


import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name = "roles")
public class Roles {
    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    @Id
    @Column(name = "id")
    private Integer role_id;

    @Column(name = "role_name")
    private String role_name;


    public enum roleTypeEnum{
        CUSTOMER(2),  ADMIN(1);
        private Integer roleId;
        public Integer getRoleId() {
            return roleId;
        }

        roleTypeEnum(Integer id){
            this.roleId = id;
        }

    }

    public  static  Roles getInstance(Integer id) {
        Roles roles = new Roles();
        roles.setRole_id(id);
        return roles;


    }
    public static final Finder<Integer, Roles> find = new Finder<>(Roles.class);


}
