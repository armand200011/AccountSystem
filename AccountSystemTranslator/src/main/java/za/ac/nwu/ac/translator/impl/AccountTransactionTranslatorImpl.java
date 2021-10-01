package za.ac.nwu.ac.translator.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import za.ac.nwu.ac.domain.dto.AccountTransactionDto;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.persistence.AccountTransaction;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTransactionRepository;
import za.ac.nwu.ac.translator.AccountTransactionTranslator;

import javax.persistence.EntityManager;

@Component
public class AccountTransactionTranslatorImpl implements AccountTransactionTranslator {
    private AccountTransactionRepository accountTransactionRepository;
    // private EntityManager em;
    private static final Logger LOGGER = LoggerFactory.getLogger(AccountTransactionTranslatorImpl.class);

    public AccountTransactionTranslatorImpl(AccountTransactionRepository accountTransactionRepository) {
        this.accountTransactionRepository = accountTransactionRepository;
    }

    @Override
    public AccountTransactionDto create(AccountTransactionDto accountType) {
        try{
            AccountTransaction result = accountTransactionRepository.save(accountType.getAccountTransaction());
            return new AccountTransactionDto(result);
        }

        catch (Exception e){
            throw new RuntimeException("Unable to save to database", e);
        }
    }

    @Override
    public AccountTransaction save(AccountTransaction accountTransaction) {
        try{
            LOGGER.info("save input {}",accountTransaction);
            AccountTransaction result = accountTransactionRepository.save(accountTransaction);
            LOGGER.info("save result {}",result);
            //  .em.persist(accountTransaction);
            return result;
        }

        catch (Exception e){
            throw new RuntimeException("Unable to save to database", e);
        }
    }
}
