package com.marshal.mcap.account.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.marshal.mcap.system.constants.BaseConstants;
import org.hibernate.validator.constraints.Email;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Pattern;

@Table(name = "sys_user")
public class SysUser {
    @Id
    @GeneratedValue(generator = "JDBC")
    private Long userId;

    private String userType;

    private String userName;

    private String passwordEncrypted;

    @Email
    private String email;

    @Pattern(regexp = BaseConstants.PATTERN_PHONE_REGEX,message = BaseConstants.PHONE_NOT_VALID)
    private String phone;

    @JsonFormat(pattern = BaseConstants.DATE_FORMAT)
    private Date startActiveDate;

    @JsonFormat(pattern = BaseConstants.DATE_FORMAT)
    private Date endActiveDate;

    private String status;

    @JsonFormat(pattern = BaseConstants.DATE_TIME_FORMAT)
    private Date lastLoginDate;

    @JsonFormat(pattern = BaseConstants.DATE_TIME_FORMAT)
    private Date lastPasswordUpdateDate;

    private String frozenFlag;

    private Date frozenDate;

    private String description;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPasswordEncrypted() {
        return passwordEncrypted;
    }

    public void setPasswordEncrypted(String passwordEncrypted) {
        this.passwordEncrypted = passwordEncrypted;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getStartActiveDate() {
        return startActiveDate;
    }

    public void setStartActiveDate(Date startActiveDate) {
        this.startActiveDate = startActiveDate;
    }

    public Date getEndActiveDate() {
        return endActiveDate;
    }

    public void setEndActiveDate(Date endActiveDate) {
        this.endActiveDate = endActiveDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    public Date getLastPasswordUpdateDate() {
        return lastPasswordUpdateDate;
    }

    public void setLastPasswordUpdateDate(Date lastPasswordUpdateDate) {
        this.lastPasswordUpdateDate = lastPasswordUpdateDate;
    }

    public String getFrozenFlag() {
        return frozenFlag;
    }

    public void setFrozenFlag(String frozenFlag) {
        this.frozenFlag = frozenFlag;
    }

    public Date getFrozenDate() {
        return frozenDate;
    }

    public void setFrozenDate(Date frozenDate) {
        this.frozenDate = frozenDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}