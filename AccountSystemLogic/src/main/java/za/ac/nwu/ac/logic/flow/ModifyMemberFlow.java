package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberDto;

import java.time.LocalDate;

public interface ModifyMemberFlow {
    MemberDto addAccountBalance(String memberFullName,Double amount, LocalDate date);
    MemberDto subtractAccountBalance(String memberFullName, Double amount, LocalDate date);
}
