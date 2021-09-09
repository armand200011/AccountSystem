package za.ac.nwu.ac.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import za.ac.nwu.ac.domain.persistence.Member;

import java.io.Serializable;
import java.util.Objects;

public class MemberDto implements Serializable {


    private static final long serialVersionUID = -3675411777951570019L;

    private String memberFullName;
    private Number balance;

    public MemberDto() {
    }

    public MemberDto(String memberFullName, Number balance) {
        this.memberFullName = memberFullName;
        this.balance = balance;
    }

    public MemberDto(Member member) {
        member.setMemberFullName(member.getMemberFullName());
        member.setBalance(member.getBalance());
    }

    public String getMemberFullName() {
        return memberFullName;
    }

    public void setMemberFullName(String memberFullName) {
        this.memberFullName = memberFullName;
    }

    public Number getBalance() {
        return balance;
    }

    public void setBalance(Number balance) {
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
