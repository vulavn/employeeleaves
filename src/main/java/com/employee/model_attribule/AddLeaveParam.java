package com.employee.model_attribule;

import com.employee.utility.Message;
import org.hibernate.validator.constraints.NotEmpty;

public class AddLeaveParam {

    private String hdnAccount;
    private int selLeaveType;

    @NotEmpty(message = Message.EMPTY_START_DATE)
    private String dtStart;
    private String selStartTime;

    @NotEmpty(message = Message.EMPTY_END_DATE)
    private String dtEnd;
    private String selEndTime;
    private String txtReason;

    public int getSelLeaveType() {
        return selLeaveType;
    }

    public void setSelLeaveType(int selLeaveType) {
        this.selLeaveType = selLeaveType;
    }

    public String getDtStart() {
        return dtStart;
    }

    public void setDtStart(String dtStart) {
        this.dtStart = dtStart;
    }

    public String getSelStartTime() {
        return selStartTime;
    }

    public void setSelStartTime(String selStartTime) {
        this.selStartTime = selStartTime;
    }

    public String getDtEnd() {
        return dtEnd;
    }

    public void setDtEnd(String dtEnd) {
        this.dtEnd = dtEnd;
    }

    public String getSelEndTime() {
        return selEndTime;
    }

    public void setSelEndTime(String selEndTime) {
        this.selEndTime = selEndTime;
    }

    public String getTxtReason() {
        return txtReason;
    }

    public void setTxtReason(String txtReason) {
        this.txtReason = txtReason;
    }

    public String getHdnAccount() {
        return hdnAccount;
    }

    public void setHdnAccount(String hdnAccount) {
        this.hdnAccount = hdnAccount;
    }
}
