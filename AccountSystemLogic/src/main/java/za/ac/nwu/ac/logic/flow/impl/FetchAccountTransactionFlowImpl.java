package za.ac.nwu.ac.logic.flow.impl;

import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Component
public class FetchAccountTransactionFlowImpl implements FetchAccountTransactionFlow{
    @Override
    public List<AccountTransactionDto> getAllAccountTransactions() {
        return null;
    }

    @Override
    public AccountTransactionDto getAccountTransactionByAccountTransactionId(String accountTypeCode) {
        return null;
    }
}
