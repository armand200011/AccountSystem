package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.flow.FetchMemberFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import za.ac.nwu.ac.translator.MemberTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchMemberFlowImpl implements FetchMemberFlow {

    private final MemberTranslator memberTranslator;
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchMemberFlowImpl.class);

    @Autowired
    public FetchMemberFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public List<MemberDto> getAllMembers() {
        List<MemberDto> list = viewAllMembers();
        return list;
    }

    private List<MemberDto> viewAllMembers() {
        return memberTranslator.getAllMembers();
    }

    @Override
    public MemberDto getAccountBalance(String memberFullName) {
        LOGGER.info("Input: {}", memberFullName);
        MemberDto balance = retrieveMemberBalance(memberFullName);
        return balance;
    }

    private MemberDto retrieveMemberBalance(String memberFullName) {
        return memberTranslator.getAccountBalanceNativeQuery(memberFullName);
    }
}
