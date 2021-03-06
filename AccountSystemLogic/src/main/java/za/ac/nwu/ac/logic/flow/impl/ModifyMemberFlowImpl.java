package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;
import za.ac.nwu.ac.translator.MemberTranslator;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.time.LocalDate;

@Transactional
@Component
public class ModifyMemberFlowImpl implements ModifyMemberFlow {

    private final MemberTranslator memberTranslator;
    private static final Logger LOGGER = LoggerFactory.getLogger(ModifyMemberFlowImpl.class);

    public ModifyMemberFlowImpl(MemberTranslator memberTranslator) {
        this.memberTranslator = memberTranslator;
    }

    @Override
    public MemberDto addAccountBalance(String memberFullName, Double amount, LocalDate date) {
        LOGGER.info("Input memberFullName: {}, Input amount: {}, Input date: {}", memberFullName, amount, date);
        if(null==date)
        { try {
            throw new Exception();
            }catch(Exception e){
              date = LocalDate.now();
            }
        }

        MemberDto add = addAmount(memberFullName, amount, date);
        return add;
    }

    private MemberDto addAmount(String memberFullName, Double amount, LocalDate date) {
        return memberTranslator.addAccountBalance(memberFullName, amount, date);
    }

    @Override
    public MemberDto subtractAccountBalance(String memberFullName, Double amount, LocalDate date) {
        LOGGER.info("Input memberFullName: {}, Input amount: {}, Input date: {}", memberFullName, amount, date);
        if(null==date)
        {
            date = LocalDate.now();

        }
        MemberDto sub = subAmount(memberFullName, amount, date);
        return sub;
    }

    private MemberDto subAmount(String memberFullName, Double amount, LocalDate date) {
        return memberTranslator.subtractAccountBalance(memberFullName, amount, date);
    }
}
