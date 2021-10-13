package models;

import io.ebean.Finder;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "user")
public class User {

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return fname;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public Integer getMobile() {
        return mobile;
    }

    public void setMobile(Integer mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPan() {
        return pan;
    }

    public void setPan(String pan) {
        this.pan = pan;
    }

    public String getAadharNo() {
        return aadharNo;
    }

    public void setAadharNo(String aadharNo) {
        this.aadharNo = aadharNo;
    }

    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public Statuses getStatusId() {
        return statusId;
    }

    public void setStatusId(Statuses statusId) {
        this.statusId = statusId;
    }

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    @Id
    @Column(name = "id")
    private Integer id;

    @Column(name = "fname")
    private String fname;

    @Column(name = "lname")
    private String lname;

    @Column(name = "dob")
    private Date dob;

    @Column(name = "mobile")
    private Integer mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "pan")
    private String pan;

    @Column(name = "aadhar_no")
    private String aadharNo;

    @Column(name = "created_on")
    private Date createdOn;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "id")
    private Statuses statusId;

    @ManyToOne
    @JoinColumn(name = "role_id" , referencedColumnName = "id")
    private Roles roleId;


    public static final Finder<Integer, User> find = new Finder<>(User.class);

}
