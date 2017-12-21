package com.employee.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "leave_type")
public class LeaveType {

    private int id;
    private String leaveName;

    private Set<LeaveHistory> leaveHistories = new HashSet<LeaveHistory>(0);

    public LeaveType(){}

    public LeaveType(int id, String leaveName, Set<LeaveHistory> leaveHistories) {
        this.id = id;
        this.leaveName = leaveName;
        this.leaveHistories = leaveHistories;
    }

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "LEAVE_NAME")
    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "leaveType")
    public Set<LeaveHistory> getLeaveHistories() {
        return leaveHistories;
    }

    public void setLeaveHistories(Set<LeaveHistory> leaveHistories) {
        this.leaveHistories = leaveHistories;
    }
}
