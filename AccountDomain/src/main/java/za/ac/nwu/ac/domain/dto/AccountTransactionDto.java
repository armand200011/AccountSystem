package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;

import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "AccountTransaction", description = "A DTO that represents the AccountTransaction")
public class AccountTransactionDto implements Serializable {
    private static final long serialVersionUID = -7011097649176232016L;


    private Long accountTransId;
    private Long accountTypeId;
    private String accountTypeCode;
    private Long memberId;
    private String memberFullName;
    private Long amount;
    private LocalDate accountTransDateCreated;


    public AccountTransactionDto(Long accountTransId, Long accountTypeId, String accountTypeCode, Long memberId, String memberFullName, Long amount, LocalDate accountTransDateCreated) {
        this.accountTransId = accountTransId;
        this.accountTypeId = accountTypeId;
        this.accountTypeCode = accountTypeCode;
        this.memberId = memberId;
        this.memberFullName = memberFullName;
        this.amount = amount;
        this.accountTransDateCreated = accountTransDateCreated;
    }

    public AccountTransactionDto(AccountTransaction accountTransaction) {


        this.accountTransId = accountTransaction.getAccountTransId();
       // LOGGER.info("save result {}",accountTransaction.getAccountTransId());
        this.accountTypeId = accountTransaction.getAccountType().getAccountTypeId();
      //  LOGGER.info("save result {}",result);
        this.accountTypeCode = accountTransaction.getAccountType().getAccountTypeCode();
      //  LOGGER.info("save result {}",result);
        this.memberId = accountTransaction.getMember().getMemberId();
      //  LOGGER.info("save result {}",result);
        this.memberFullName = accountTransaction.getMember().getMemberFullName();
       // LOGGER.info("save result {}",result);
        this.amount = accountTransaction.getAmount();
      //  LOGGER.info("save result {}",result);
        this.accountTransDateCreated = accountTransaction.getAccountTransDateCreated();
     //   LOGGER.info("save result {}",result);
    }

    public Long getAccountTransId() {
        return accountTransId;
    }

    public void setAccountTransId(Long accountTransId) {
        this.accountTransId = accountTransId;
    }

    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    public String getAccountTypeCode() {
        return accountTypeCode;
    }

    public void setAccountTypeCode(String accountTypeCode) {
        this.accountTypeCode = accountTypeCode;
    }

    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    public String getMemberFullName() {
        return memberFullName;
    }

    public void setMemberFullName(String memberFullName) {
        this.memberFullName = memberFullName;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

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
        AccountTransactionDto that = (AccountTransactionDto) o;
        return Objects.equals(accountTransId, that.accountTransId) && Objects.equals(accountTypeId, that.accountTypeId) && Objects.equals(accountTypeCode, that.accountTypeCode) && Objects.equals(memberId, that.memberId) && Objects.equals(memberFullName, that.memberFullName) && Objects.equals(amount, that.amount) && Objects.equals(accountTransDateCreated, that.accountTransDateCreated);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountTransId, accountTypeId, accountTypeCode, memberId, memberFullName, amount, accountTransDateCreated);
    }

    @JsonIgnore
    public AccountType getAccountType()
    {
        return new AccountType(this.accountTypeId,this.getAccountTypeCode());
    }
    @JsonIgnore
    public Member getMember(){
        return new Member(this.getMemberId(),this.getMemberFullName());
    }

    @JsonIgnore
    public AccountTransaction getAccountTransaction(){
        return new AccountTransaction(this.getAccountTransId(),this.getAccountType(),this.getMember(),this.getAmount(),this.getAccountTransDateCreated());
    }
    @JsonIgnore
    public AccountTransaction buildAccountTransaction(AccountType accountType, Member member)
    {
        return new AccountTransaction(this.getAccountTransId(),accountType,member,this.getAmount(),this.getAccountTransDateCreated());

    }

    @Override
    public String toString() {
        return "AccountTransactionDto{" +
                "accountTransId=" + accountTransId +
                ", accountTypeId=" + accountTypeId +
                ", accountTypeCode='" + accountTypeCode + '\'' +
                ", memberId=" + memberId +
                ", memberFullName='" + memberFullName + '\'' +
                ", amount=" + amount +
                ", accountTransDateCreated=" + accountTransDateCreated +
                '}';
    }
}
