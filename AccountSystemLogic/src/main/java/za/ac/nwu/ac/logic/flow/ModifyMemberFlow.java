package za.ac.nwu.ac.logic.flow;

import za.ac.nwu.ac.domain.dto.MemberDto;

public interface ModifyMemberFlow {
    MemberDto addAccountBalance(String memberFullName,Double amount);
}
