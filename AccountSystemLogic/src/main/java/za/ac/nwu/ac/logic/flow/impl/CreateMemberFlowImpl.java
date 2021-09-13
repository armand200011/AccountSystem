package za.ac.nwu.ac.logic.flow.impl;

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

    public CreateMemberFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDto create(MemberDto member){
        if(member.getBalance()==null) {
            member.setBalance(50);
        }

        return memberTranslator.create(member);
    }
}