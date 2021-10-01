package za.ac.nwu.ac.logic.flow.impl;

import javax.transaction.Transactional;

import jdk.nashorn.internal.runtime.options.LoggingOption;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;
import java.time.LocalDate;

@Transactional
@Component("createAccountTypeFlowName")
public class CreateAccountTypeFlowImpl implements CreateAccountTypeFlow {

    private final AccountTypeTranslator accountTypeTranslator;
    private static final Logger LOGGER = LoggerFactory.getLogger(CreateAccountTypeFlowImpl.class);

    public CreateAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator) {
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public AccountTypeDto create(AccountTypeDto accountType){
        LOGGER.info("Input: {}",accountType);
        if(null == accountType.getAccountTypeDateCreated()){
            accountType.setAccountTypeDateCreated(LocalDate.now());
        }
        return accountTypeTranslator.create(accountType);
    }
}
