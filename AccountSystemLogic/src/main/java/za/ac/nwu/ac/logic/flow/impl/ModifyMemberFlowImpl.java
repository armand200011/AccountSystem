package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;
import za.ac.nwu.ac.translator.MemberTranslator;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;

@Transactional
@Component
public class ModifyMemberFlowImpl implements ModifyMemberFlow {

    private final MemberTranslator memberTranslator;
    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyMemberFlowImpl.class);

    public ModifyMemberFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDto addAccountBalance(String memberFullName, Double amount) {
        LOGGER.info("Input memberFullName: {}, Input amount: {}", memberFullName, amount);
        return memberTranslator.addAccountBalance( memberFullName, amount);
    }

    @Override
    public MemberDto subtractAccountBalance(String memberFullName, Double amount) {
        LOGGER.info("Input memberFullName: {}, Input amount: {}", memberFullName, amount);
        return memberTranslator.subtractAccountBalance( memberFullName, amount);
    }
}
