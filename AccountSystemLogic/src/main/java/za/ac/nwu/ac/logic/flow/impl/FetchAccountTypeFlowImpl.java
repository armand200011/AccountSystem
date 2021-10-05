package za.ac.nwu.ac.logic.flow.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTypeFlowImpl implements FetchAccountTypeFlow {


    private final AccountTypeTranslator accountTypeTranslator;
    private static final Logger LOGGER = LoggerFactory.getLogger(FetchAccountTypeFlowImpl.class);

    @Autowired
    public FetchAccountTypeFlowImpl(AccountTypeTranslator accountTypeTranslator){
        this.accountTypeTranslator = accountTypeTranslator;
    }

    @Override
    public List<AccountTypeDto> getAllAccountTypes() {
        List<AccountTypeDto> list = viewAllAccountTypes();
        return list;
    }

    private List<AccountTypeDto> viewAllAccountTypes() {
        return accountTypeTranslator.getAllAccountTypes();
    }

    @Override
    public AccountTypeDto getAccountTypeByAccountTypeCode(String accountTypeCode) {
        LOGGER.info("Input: {}", accountTypeCode);
        AccountTypeDto viewTypeCode = viewByAccountTypeCode(accountTypeCode);
        return viewTypeCode;
    }

    private AccountTypeDto viewByAccountTypeCode(String accountTypeCode) {
        return accountTypeTranslator.getAccountTypeByAccountTypeCodeNativeQuery(accountTypeCode);
    }
}
