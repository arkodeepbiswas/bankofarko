package models;

import io.ebean.Finder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name = "statuses")
public class Statuses {

    public Integer getStatusId() {
        return statusId;
    }

    public void setStatusId(Integer statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }
    @Id
    @Column(name = "id")
    private Integer statusId;

    @Column(name = "status_name")
    private String statusName;

    public enum statusTypeEnum{
        ACTIVE(1),  INACTIVE(2);
        private Integer Status_id;
        public Integer getStatus_id() {
            return Status_id;
        }

        statusTypeEnum(Integer id){
            this.Status_id = id;
        }

    }

    public  static  Statuses getInstance(Integer id) {
        Statuses statuses = new Statuses();
        statuses.setStatusId(id);
        return statuses;
    }

    public static final Finder<Integer, Statuses> find = new Finder<>(Statuses.class);


}
