package com.employee.entity;

import com.employee.utility.Common;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "leave_history")
public class LeaveHistory {

    private int id;
    private String account;
    private Timestamp start;
    private Timestamp end;
    private String reason;
    private int status;
    private Timestamp applyDate;
    private int year;
    private LeaveType leaveType;
    private Set<LeaveHistory> leaveHistories = new HashSet<LeaveHistory>(0);

    @Id
    @GeneratedValue
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "ACCOUNT", nullable = false)
    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    @Column(name = "START", nullable = false)
    public Timestamp getStart() {
        return start;
    }

    public void setStart(Timestamp start) {
        this.start = start;
    }

    @Column(name = "END", nullable = false)
    public Timestamp getEnd() {
        return end;
    }

    public void setEnd(Timestamp end) {
        this.end = end;
    }

    @Column(name = "REASON")
    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    @Column(name = "STATUS", nullable = false)
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Column(name = "APPLY_DATE")
    public Timestamp getApplyDate() {
        return applyDate;
    }

    public void setApplyDate(Timestamp applyDate) {
        this.applyDate = applyDate;
    }

    @Column(name = "YEAR", nullable = false)
    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "LEAVE_TYPE_ID", nullable = false)
    public LeaveType getLeaveType() {
        return leaveType;
    }

    public void setLeaveType(LeaveType leaveType) {
        this.leaveType = leaveType;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "id")
    public Set<LeaveHistory> getLeaveHistories() {
        return leaveHistories;
    }

    public void setLeaveHistories(Set<LeaveHistory> leaveHistories) {
        this.leaveHistories = leaveHistories;
    }

    public double createDuration() throws Exception{

        Date startDateTime = new Date(start.getTime());
        Date endDateTime = new Date(end.getTime());

        Date startDate = Common.formatDateToDate(startDateTime, "yyyyMMdd");
        Date endDate = Common.formatDateToDate(endDateTime, "yyyyMMdd");
        long subtractDate = Common.subtract2Date(startDate, endDate);

        int startHour = Common.getHour(startDateTime);
        int endHour = Common.getHour(endDateTime);
        int subtractHour = endHour - startHour;

        double duration = Common.countDuration(subtractDate, subtractHour);

        return duration;
    }
}
