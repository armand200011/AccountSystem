package za.ac.nwu.ac.domain.persistence;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ACCOUNT_MEMBER", schema = "ARMAND")
public class Member implements Serializable {


    private static final long serialVersionUID = 392991213906053599L;

    private Long memberId;
    private String memberFullName;
    private Double balance;
    private LocalDate memberDate;

    private AccountType accountType;

//  private Set<AccountType> accountTypes;

    public Member() {
    }


    public Member(Long memberId, String memberFullName, Double balance, AccountType accountType, LocalDate memberDate) {
        this.memberId = memberId;
        this.memberFullName = memberFullName;
        this.balance = balance;
        this.accountType = accountType;
        this.memberDate = memberDate;
    }

    public Member(String memberFullName, Double balance) {
        this.memberFullName = memberFullName;
        this.balance = balance;
    }

    public Member(Long memberId, String memberFullName, Double balance) {
        this.memberId = memberId;
        this.memberFullName = memberFullName;
        this.balance = balance;
    }

    public Member(Long memberId, String memberFullName) {
        this.memberId = memberId;
        this.memberFullName = memberFullName;
    }

    @Id
    @SequenceGenerator(name = "MEMBER_GENERIC_SEQ", sequenceName = "ARMAND.MEMBER_GENERIC_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "MEMBER_GENERIC_SEQ")
    @Column(name = "MEMBER_ID")
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @Column(name = "MEMBER_FULLNAME")
    public String getMemberFullName() {
        return memberFullName;
    }

    public void setMemberFullName(String memberFullName) {
        this.memberFullName = memberFullName;
    }

    @Column(name = "BALANCE")
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(memberId, member.memberId) && Objects.equals(memberFullName, member.memberFullName) && Objects.equals(balance, member.balance)&&Objects.equals(accountType, member.accountType) && Objects.equals(memberDate, member.memberDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberFullName, balance, accountType, memberDate);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ACCOUNT_TYPE_ID")
    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public LocalDate getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(LocalDate memberDate) {
        this.memberDate = memberDate;
    }

    @Override
    public String toString() {
        return "Member{" +
                "memberId=" + memberId +
                ", memberFullName='" + memberFullName + '\'' +
                ", balance=" + balance +
                ", memberDate=" + memberDate +
                ", accountType=" + accountType +
                '}';
    }
}
