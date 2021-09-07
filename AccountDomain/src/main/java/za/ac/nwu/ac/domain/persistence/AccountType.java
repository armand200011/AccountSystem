package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name = "ACCOUNT_TYPE", schema = "ARMAND")
public class AccountType implements Serializable {

    private static final long serialVersionID = 383725316797154577L;

    @Id
    @SequenceGenerator(name = "ACCOUNT_TYPE_GENERIC_SEQ", sequenceName = "ARMAND.ACCOUNT_TYPE_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TYPE_GENERIC_SEQ")

    private Long accountTypeId;
    private String accountTypeCode;
    private String accountTypeName;
    private LocalDate accountTypeDateCreated;

    private Set<AccountTransaction> accountTransactions;

    public AccountType() {
    }

    public AccountType(Long accountTypeId, String accountTypeCode, String accountTypeName, LocalDate accountTypeDateCreated) {
        this.accountTypeId = accountTypeId;
        this.accountTypeCode = accountTypeCode;
        this.accountTypeName = accountTypeName;
        this.accountTypeDateCreated = accountTypeDateCreated;
    }

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

    @Column(name = "ACCOUNT_TYPE_DATE_CREATED")
    public LocalDate getAccountTypeDateCreated() {
        return accountTypeDateCreated;
    }

    public void setAccountTypeDateCreated(LocalDate accountTypeDateCreated) {
        this.accountTypeDateCreated = accountTypeDateCreated;
    }

    @OneToMany(targetEntity = AccountTransaction.class, fetch = FetchType.LAZY, mappedBy = "accountType", orphanRemoval = true, cascade = CascadeType.PERSIST)
    public Set<AccountTransaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(Set<AccountTransaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountType that = (AccountType) o;
        return Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(accountTypeCode, that.accountTypeCode) && Objects.equals(accountTypeName, that.accountTypeName) && Objects.equals(accountTypeDateCreated, that.accountTypeDateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTypeId, accountTypeCode, accountTypeName, accountTypeDateCreated);
    }


    @Override
    public String toString() {
        return "AccountType{" +
                "accountTypeId=" + accountTypeId +
                ", accountTypeCode='" + accountTypeCode + '\'' +
                ", accountTypeName='" + accountTypeName + '\'' +
                ", accountTypeDateCreated=" + accountTypeDateCreated +
                '}';
    }
}
