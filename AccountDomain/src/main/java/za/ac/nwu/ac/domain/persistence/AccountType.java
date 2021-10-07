package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "ACCOUNT_TYPE", schema = "ARMAND")
public class AccountType implements Serializable {


    private static final long serialVersionUID = 5417020135534385990L;
    //383725316797154577L

    private Long accountTypeId;
    private String accountTypeCode;
    private String accountTypeName;


    public AccountType() {
    }

    public AccountType(String accountTypeCode, String accountTypeName) {
        this.accountTypeCode = accountTypeCode;
        this.accountTypeName = accountTypeName;
    }

    public AccountType(Long accountTypeId, String accountTypeCode) {
        this.accountTypeId = accountTypeId;
        this.accountTypeCode = accountTypeCode;
    }

    public AccountType(Long accountTypeId, String accountTypeCode, String accountTypeName) {
        this.accountTypeId = accountTypeId;
        this.accountTypeCode = accountTypeCode;
        this.accountTypeName = accountTypeName;
    }

    @Id
    @SequenceGenerator(name = "ACCOUNT_TYPE_GENERIC_SEQ", sequenceName = "ARMAND.ACCOUNT_TYPE_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TYPE_GENERIC_SEQ")
    @Column(name = "ACCOUNT_TYPE_ID")
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @Column(name = "ACCOUNT_TYPE_CODE")
    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    @Column(name = "ACCOUNT_TYPE_NAME")
    public String getAccountTypeName() {
        return accountTypeName;
    }

    public void setAccountTypeName(String accountTypeName) {
        this.accountTypeName = accountTypeName;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(accountTypeCode, that.accountTypeCode) && Objects.equals(accountTypeName, that.accountTypeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, accountTypeCode, accountTypeName);
    }


    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", accountTypeCode='" + accountTypeCode + '\'' +
                ", accountTypeName='" + accountTypeName +
                '}';
    }
}
