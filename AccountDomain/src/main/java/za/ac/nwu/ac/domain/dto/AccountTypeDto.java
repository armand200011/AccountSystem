package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.ac.domain.persistence.AccountType;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class AccountTypeDto implements Serializable {


    private static final long serialVersionUID = -7731154715176897719L;

    private String accountTypeCode;
    private String accountTypeName;
    private LocalDate accountTypeDateCreated;

    public AccountTypeDto() {
    }

    public AccountTypeDto(String accountTypeCode, String accountTypeName, LocalDate accountTypeDateCreated) {
        this.accountTypeCode = accountTypeCode;
        this.accountTypeName = accountTypeName;
        this.accountTypeDateCreated = accountTypeDateCreated;
    }

    public AccountTypeDto(AccountType accountType) {
        accountType.setAccountTypeName(accountType.getAccountTypeName());
        accountType.setAccountTypeDateCreated(accountType.getAccountTypeDateCreated());
        accountType.setAccountTypeCode(accountType.getAccountTypeCode());
    }

    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }

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
        return Objects.equals(accountTypeCode, that.accountTypeCode) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(accountTypeDateCreated, that.accountTypeDateCreated);
    }

    @JsonIgnore
    public AccountType getAccountType(){
        return new AccountType(getAccountTypeCode(), getAccountTypeName(), getAccountTypeDateCreated());
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeCode, accountTypeName, accountTypeDateCreated);
    }

    @Override
    public String toString() {
        return "AccountTypeDto{" +
                "accountTypeCode='" + accountTypeCode + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", accountTypeDateCreated=" + accountTypeDateCreated +
                '}';
    }
}
