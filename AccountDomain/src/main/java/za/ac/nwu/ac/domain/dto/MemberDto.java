package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;
import java.util.Objects;

@ApiModel(value = "Member", description = "A DTO that represents a Member")
public class MemberDto implements Serializable {


    private static final long serialVersionUID = -3675411777951570019L;

    private String memberFullName;
    private Double balance;

    public MemberDto() {
    }

    public MemberDto(String memberFullName, Double balance) {
        this.memberFullName = memberFullName;
        this.balance = balance;
    }

    public MemberDto(Member member) {
        this.setMemberFullName(member.getMemberFullName());
        this.setBalance(member.getBalance());
    }

    @ApiModelProperty(position = 1,
            value = "Member MemberFullName",
            name = "FullName",
            notes = "The member's fullname",
            dataType = "java.lang.String",
            example = "Armand de Beer",
            required = true)
    public String getMemberFullName() {
        return memberFullName;
    }

    public void setMemberFullName(String memberFullName) {
        this.memberFullName = memberFullName;
    }

    @ApiModelProperty(position = 2,
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

    @JsonIgnore
    public Member getMember(){
        return new Member(getMemberFullName(), getBalance());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MemberDto memberDto = (MemberDto) o;
        return Objects.equals(memberFullName, memberDto.memberFullName) && Objects.equals(balance, memberDto.balance);
    }

    @Override
    public int hashCode() {
        return Objects.hash(memberFullName, balance);
    }

    @Override
    public String toString() {
        return "MemberDto{" +
                "memberFullName='" + memberFullName + '\'' +
                ", balance=" + balance +
                '}';
    }
}
