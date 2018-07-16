package com.kyler.space.sys.pojo;

import java.io.Serializable;
import java.util.Date;

public class Code implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 微代码SID
     */
    private Long codeSid;

    /**
     * 微代码
     */
    private String codeCategory;

    /**
     * 微代码值
     */
    private String codeValue;

    /**
     * 微代码显示值
     */
    private String codeDisplay;

    /**
     * 上级微代码值
     */
    private String parentCodeValue;

    /**
     * 是否启用(1:启用;0:不启用)
     */
    private String enabled;

    /**
     * 排序
     */
    private Long sort;

    /**
     * 描述
     */
    private String description;

    /**
     * 创建人
     */
    private String createdBy;

    /**
     * 创建时间
     */
    private Date createdDt;

    /**
     * 更新人
     */
    private String updatedBy;

    /**
     * 更新时间
     */
    private Date updatedDt;

    /**
     * 版本号
     */
    private Long version;

    /**
     * @return 微代码SID
     */
    public Long getCodeSid() {
        return codeSid;
    }

    /**
     * @param codeSid 
	 *            微代码SID
     */
    public void setCodeSid(Long codeSid) {
        this.codeSid = codeSid;
    }

    /**
     * @return 微代码
     */
    public String getCodeCategory() {
        return codeCategory;
    }

    /**
     * @param codeCategory 
	 *            微代码
     */
    public void setCodeCategory(String codeCategory) {
        this.codeCategory = codeCategory;
    }

    /**
     * @return 微代码值
     */
    public String getCodeValue() {
        return codeValue;
    }

    /**
     * @param codeValue 
	 *            微代码值
     */
    public void setCodeValue(String codeValue) {
        this.codeValue = codeValue;
    }

    /**
     * @return 微代码显示值
     */
    public String getCodeDisplay() {
        return codeDisplay;
    }

    /**
     * @param codeDisplay 
	 *            微代码显示值
     */
    public void setCodeDisplay(String codeDisplay) {
        this.codeDisplay = codeDisplay;
    }

    /**
     * @return 上级微代码值
     */
    public String getParentCodeValue() {
        return parentCodeValue;
    }

    /**
     * @param parentCodeValue 
	 *            上级微代码值
     */
    public void setParentCodeValue(String parentCodeValue) {
        this.parentCodeValue = parentCodeValue;
    }

    /**
     * @return 是否启用(1:启用;0:不启用)
     */
    public String getEnabled() {
        return enabled;
    }

    /**
     * @param enabled 
	 *            是否启用(1:启用;0:不启用)
     */
    public void setEnabled(String enabled) {
        this.enabled = enabled;
    }

    /**
     * @return 排序
     */
    public Long getSort() {
        return sort;
    }

    /**
     * @param sort 
	 *            排序
     */
    public void setSort(Long sort) {
        this.sort = sort;
    }

    /**
     * @return 描述
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description 
	 *            描述
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return 创建人
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * @param createdBy 
	 *            创建人
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * @return 创建时间
     */
    public Date getCreatedDt() {
        return createdDt;
    }

    /**
     * @param createdDt 
	 *            创建时间
     */
    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    /**
     * @return 更新人
     */
    public String getUpdatedBy() {
        return updatedBy;
    }

    /**
     * @param updatedBy 
	 *            更新人
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * @return 更新时间
     */
    public Date getUpdatedDt() {
        return updatedDt;
    }

    /**
     * @param updatedDt 
	 *            更新时间
     */
    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
    }

    /**
     * @return 版本号
     */
    public Long getVersion() {
        return version;
    }

    /**
     * @param version 
	 *            版本号
     */
    public void setVersion(Long version) {
        this.version = version;
    }
}