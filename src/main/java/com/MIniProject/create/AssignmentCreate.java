package com.MIniProject.create;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public class AssignmentCreate {

    private String cId;
    private String cAsgTitle;
    private String cInstrName;
    private String cStdName;
    private String cStatus;
    private Date cDeadline;
    private Date cAsgUploadedAt;
    private Date cLastUpdatedAt;




    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId;
    }

    public String getcAsgTitle() {
        return cAsgTitle;
    }

    public void setcAsgTitle(String cAsgTitle) {
        this.cAsgTitle = cAsgTitle;
    }

    public String getcInstrName() {
        return cInstrName;
    }

    public void setcInstrName(String cInstrName) {
        this.cInstrName = cInstrName;
    }

    public String getcStdName() {
        return cStdName;
    }

    public void setcStdName(String cStdName) {
        this.cStdName = cStdName;
    }

    public Date getcDeadline() {
        return cDeadline;
    }

    public void setcDeadline(Date cDeadline) {
        this.cDeadline = cDeadline;
    }

    public Date getcAsgUploadedAt() {
        return cAsgUploadedAt;
    }

    public void setcAsgUploadedAt(Date cAsgUploadedAt) {
        this.cAsgUploadedAt = cAsgUploadedAt;
    }

    public Date getcLastUpdatedAt() {
        return cLastUpdatedAt;
    }

    public void setcLastUpdatedAt(Date cLastUpdatedAt) {
        this.cLastUpdatedAt = cLastUpdatedAt;
    }

    public String getcStatus() {
        return cStatus;
    }

    public void setcStatus(String cStatus) {
        this.cStatus = cStatus;
    }
}
