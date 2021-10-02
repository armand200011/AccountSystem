package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

@ApiModel(value = "Member", description = "A DTO that represents a Member")
public class MemberDto implements Serializable {


    private static final long serialVersionUID = -3675411777951570019L;

    private Long memberId;
    private String memberFullName;
    private Double balance;
    private Long accountTypeId;
    private String accountTypeCode;
    private LocalDate memberDate;


    public MemberDto(Long memberId, String memberFullName, Double balance, Long accountTypeId, String accountTypeCode, LocalDate memberDate) {
        this.memberId = memberId;
        this.memberFullName = memberFullName;
        this.balance = balance;
        this.accountTypeId = accountTypeId;
        this.accountTypeCode = accountTypeCode;
        this.memberDate = memberDate;
    }


    public MemberDto() {
    }

    public MemberDto(Long memberId, String memberFullName, Double balance) {
        this.memberId = memberId;
        this.memberFullName = memberFullName;
        this.balance = balance;
    }

    public MemberDto(String memberFullName, Double balance) {
        this.memberFullName = memberFullName;
        this.balance = balance;
    }

    public MemberDto(Member member) {
        this.setMemberId(member.getMemberId());
        this.setMemberFullName(member.getMemberFullName());
        this.setBalance(member.getBalance());
        this.setAccountTypeId(member.getAccountType().getAccountTypeId());
        this.setAccountTypeCode(member.getAccountType().getAccountTypeCode());
        this.setMemberDate(member.getMemberDate());
    }

    @ApiModelProperty(position = 1,
            value = "Member MemberId",
            name = "Id",
            notes = "The memberId",
            dataType = "java.lang.Long",
            example = "1",
            required = true)
    public Long getMemberId() {
        return memberId;
    }

    public void setMemberId(Long memberId) {
        this.memberId = memberId;
    }

    @ApiModelProperty(position = 2,
            value = "Member MemberFullName",
            name = "FullName",
            notes = "The member's fullname",
            dataType = "java.lang.String",
            example = "Johan",
            required = true)
    public String getMemberFullName() {
        return memberFullName;
    }

    public void setMemberFullName(String memberFullName) {
        this.memberFullName = memberFullName;
    }

    @ApiModelProperty(position = 3,
            value = "Member Balance",
            name = "Balance",
            notes = "The member's balance",
            dataType = "java.lang.Double",
            example = "10000.99",
            required = true)
    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @ApiModelProperty(position = 4,
            value = "AccountType AccountTypeId",
            name = "AccountTypeId",
            notes = "Uniquely identifies the account typeId",
            dataType = "java.lang.Long",
            example = "1",
            required = true)
    public Long getAccountTypeId() {
        return accountTypeId;
    }

    public void setAccountTypeId(Long accountTypeId) {
        this.accountTypeId = accountTypeId;
    }

    @ApiModelProperty(position = 5,
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
    @JsonIgnore
    public AccountType getAccountType()
    {
        return new AccountType(this.accountTypeId,this.getAccountTypeCode());
    }

    @JsonIgnore
    public Member getMember(){
        return new Member(getMemberId(), getMemberFullName(), getBalance(),getAccountType(), getMemberDate());
    }

    @ApiModelProperty(position = 6,
            value = "Member memberDate",
            name = "MemberDate",
            notes = "The date the balance was last updated",
            dataType = "java.lang.String",
            example = "2021-01-01",
            allowEmptyValue = true)
    public LocalDate getMemberDate() {
        return memberDate;
    }

    public void setMemberDate(LocalDate memberDate) {
        this.memberDate = memberDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDto memberDto = (MemberDto) o;
        return Objects.equals(memberId, memberDto.memberId) && Objects.equals(memberFullName, memberDto.memberFullName) && Objects.equals(balance, memberDto.balance) && Objects.equals(accountTypeId, memberDto.accountTypeId) && Objects.equals(accountTypeCode, memberDto.accountTypeCode) && Objects.equals(memberDate, memberDto.memberDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberId, memberFullName, balance, accountTypeId, accountTypeCode, memberDate);
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "memberId=" + memberId +
                ", memberFullName='" + memberFullName + '\'' +
                ", balance=" + balance +
                ", accountTypeId=" + accountTypeId +
                ", accountTypeCode='" + accountTypeCode + '\'' +
                ", memberDate=" + memberDate +
                '}';
    }
}
