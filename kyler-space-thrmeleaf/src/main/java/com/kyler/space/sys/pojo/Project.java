package com.kyler.space.sys.pojo;

import java.io.Serializable;
import java.util.Date;

public class Project implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long projectSid;

    private Long orgSid;

    private String projectName;

    private String projectEname;

    private String status;

    private Date projectStartTime;

    private Date projectEndTime;

    private String projectDesc;

    private String projecrFiles;

    private String createdBy;

    private Date createdDt;

    private String updatedBy;

    private Date updatedDt;

    private Long version;
    
    private String startTimeDesc;
    private String endTimeDesc;

    public Long getProjectSid() {
        return projectSid;
    }

    public void setProjectSid(Long projectSid) {
        this.projectSid = projectSid;
    }

    public Long getOrgSid() {
        return orgSid;
    }

    public void setOrgSid(Long orgSid) {
        this.orgSid = orgSid;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectEname() {
        return projectEname;
    }

    public void setProjectEname(String projectEname) {
        this.projectEname = projectEname;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getProjectStartTime() {
        return projectStartTime;
    }

    public void setProjectStartTime(Date projectStartTime) {
        this.projectStartTime = projectStartTime;
    }

    public Date getProjectEndTime() {
        return projectEndTime;
    }

    public void setProjectEndTime(Date projectEndTime) {
        this.projectEndTime = projectEndTime;
    }

    public String getProjectDesc() {
        return projectDesc;
    }

    public void setProjectDesc(String projectDesc) {
        this.projectDesc = projectDesc;
    }

    public String getProjecrFiles() {
        return projecrFiles;
    }

    public void setProjecrFiles(String projecrFiles) {
        this.projecrFiles = projecrFiles;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

	public String getStartTimeDesc() {
		return startTimeDesc;
	}

	public void setStartTimeDesc(String startTimeDesc) {
		this.startTimeDesc = startTimeDesc;
	}

	public String getEndTimeDesc() {
		return endTimeDesc;
	}

	public void setEndTimeDesc(String endTimeDesc) {
		this.endTimeDesc = endTimeDesc;
	}
    
    
}