package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "ACCOUNT_TRANS", schema = "ARMAND")
public class AccountTransaction implements Serializable {


    private static final long serialVersionUID = 742896982468674488L;
    /*383725316797154577L*/
    @Id
    @SequenceGenerator(name = "ACCOUNT_TRANS_GENERIC_SEQ", sequenceName = "ARMAND.ACCOUNT_TRANS_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ACCOUNT_TRANS_GENERIC_SEQ")

    private Long accountTransId;
    private AccountType accountType;
    private Member member;
    private Long amount;
    private LocalDate accountTransDateCreated;

    public AccountTransaction() {
    }

    public AccountTransaction(Long accountTransId, AccountType accountType, Member member, Long amount, LocalDate accountTransDateCreated) {
        this.accountTransId = accountTransId;
        this.accountType = accountType;
        this.member = member;
        this.amount = amount;
        this.accountTransDateCreated = accountTransDateCreated;
    }

    @Column(name = "ACCOUNT_TRANS_ID")
    public Long getAccountTransId() {
        return accountTransId;
    }

    public void setAccountTransId(Long accountTransId) {
        this.accountTransId = accountTransId;
    }

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountTypeId) {
        this.accountType = accountType;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MEMBER_ID")
    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Column(name = "AMOUNT")
    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    @Column(name = "ACCOUNT_TRANS_DATE_CREATED")
    public LocalDate getAccountTransDateCreated() {
        return accountTransDateCreated;
    }

    public void setAccountTransDateCreated(LocalDate accountTransDateCreated) {
        this.accountTransDateCreated = accountTransDateCreated;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AccountTransaction that = (AccountTransaction) o;
        return Objects.equals(accountTransId, that.accountTransId) && Objects.equals(accountType, that.accountType) && Objects.equals(member, that.member) && Objects.equals(amount, that.amount) && Objects.equals(accountTransDateCreated, that.accountTransDateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransId, accountType, member, amount, accountTransDateCreated);
    }

    @Override
    public String toString() {
        return "AccountTransaction{" +
                "accountTransId=" + accountTransId +
                ", accountType=" + accountType +
                ", member=" + member +
                ", amount=" + amount +
                ", accountTransDateCreated=" + accountTransDateCreated +
                '}';
    }
}
