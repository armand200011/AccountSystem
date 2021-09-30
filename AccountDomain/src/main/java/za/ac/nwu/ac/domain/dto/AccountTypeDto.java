package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountType", description = "A DTO that represents the AccountType")
public class AccountTypeDto implements Serializable {


    private static final long serialVersionUID = -7731154715176897719L;

    private Long accountTypeID;
    private String accountTypeCode;
    private String accountTypeName;
    private LocalDate accountTypeDateCreated;

    public AccountTypeDto() {
    }

    public AccountTypeDto(Long accountTypeID, String accountTypeCode, String accountTypeName, LocalDate accountTypeDateCreated) {
        this.accountTypeID = accountTypeID;
        this.accountTypeCode = accountTypeCode;
        this.accountTypeName = accountTypeName;
        this.accountTypeDateCreated = accountTypeDateCreated;
    }

    public AccountTypeDto(String accountTypeCode, String accountTypeName, LocalDate accountTypeDateCreated) {
        this.accountTypeCode = accountTypeCode;
        this.accountTypeName = accountTypeName;
        this.accountTypeDateCreated = accountTypeDateCreated;
    }
/*
    public AccountTypeDto(AccountType accountType) {
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setAccountTypeDateCreated(accountType.getAccountTypeDateCreated());
        this.setAccountTypeCode(accountType.getAccountTypeCode());
    }*/

    public AccountTypeDto(AccountType accountType) {
        this.setAccountTypeID(accountType.getAccountTypeId());
        this.setAccountTypeName(accountType.getAccountTypeName());
        this.setAccountTypeDateCreated(accountType.getAccountTypeDateCreated());
        this.setAccountTypeCode(accountType.getAccountTypeCode());
    }

    @ApiModelProperty(position = 1,
            value = "AccountType AccountTypeId",
            name = "AccountTypeId",
            notes = "Uniquely identifies the account typeId",
            dataType = "java.lang.Long",
            example = "1",
            required = true)
    public Long getAccountTypeID() {
        return accountTypeID;
    }

    public void setAccountTypeID(Long accountTypeID) {
        this.accountTypeID = accountTypeID;
    }

    @ApiModelProperty(position = 2,
            value = "AccountType AccountTypeCode",
            name = "AccountTypeCode",
            notes = "Uniquely identifies the account type",
            dataType = "java.lang.String",
            example = "MILES",
            required = true)
    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    @ApiModelProperty(position = 3,
            value = "AccountType AccountTypeName",
            name = "AccountTypeName",
            notes = "The name of the account type",
            dataType = "java.lang.String",
            example = "Miles",
            required = true)
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

    @ApiModelProperty(position = 4,
            value = "AccountType AccountTypeDateCreated",
            name = "AccountTypeDateCreated",
            notes = "The data on which the AccountType was created",
            dataType = "java.lang.String",
            example = "2021-01-01",
            allowEmptyValue = true)
    public LocalDate getAccountTypeDateCreated() {
        return accountTypeDateCreated;
    }

    public void setAccountTypeDateCreated(LocalDate accountTypeDateCreated) {
        this.accountTypeDateCreated = accountTypeDateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTypeDto that = (AccountTypeDto) o;
        return Objects.equals(accountTypeID, that.accountTypeID) && Objects.equals(accountTypeCode, that.accountTypeCode) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(accountTypeDateCreated, that.accountTypeDateCreated);
    }

    @JsonIgnore
    public AccountType getAccountType(){
        return new AccountType(getAccountTypeID(), getAccountTypeCode(), getAccountTypeName(), getAccountTypeDateCreated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeID, accountTypeCode, accountTypeName, accountTypeDateCreated);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "accountTypeId='" + accountTypeID + '\'' +
                "accountTypeCode='" + accountTypeCode + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", accountTypeDateCreated=" + accountTypeDateCreated +
                '}';
    }
}
