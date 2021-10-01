package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.logic.flow.CreateMemberFlow;
import za.ac.nwu.ac.translator.MemberTranslator;
import za.ac.nwu.ac.domain.dto.MemberDto;

import javax.transaction.Transactional;


@Transactional
@Component("createMemberFlowName")
public class CreateMemberFlowImpl implements CreateMemberFlow {

    private final MemberTranslator memberTranslator;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateMemberFlowImpl.class);

    public CreateMemberFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDto create(MemberDto member){
        LOGGER.info("Input: {}", member);
        if(null == member.getBalance()) {
            member.setBalance(50.55);
        }

        return memberTranslator.create(member);
    }
}
