package za.ac.nwu.ac.translator.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class AccountTypeTranslatorImplTest {

    @Mock
    private AccountTypeRepository repository;
    @InjectMocks
    private AccountTypeTranslatorImpl translator;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllAccountTypes() {
        try {
            String expectedResponse = "[AccountTypeDto{accountTypeId='1'accountTypeCode='MILES', accountTypeName='Miles', accountTypeDateCreated="+LocalDate.now()+"}]";
            List<AccountType> accountType = new ArrayList<>();
            accountType.add(new AccountType(Long.valueOf(1),"MILES","Miles",LocalDate.now()));
            when(repository.findAll()).thenReturn(accountType);
            List<AccountTypeDto> res = translator.getAllAccountTypes();
            assertNotNull(res);
            verify(repository, atLeastOnce()).findAll();
            assertEquals(expectedResponse, res.toString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }
    @Test(expected = RuntimeException.class)
    public void createError() {

        String expectedResponse = "AccountTypeDto{accountTypeId='1'accountTypeCode='MILES', accountTypeName='Miles', accountTypeDateCreated="+LocalDate.now()+"}";

        AccountType accountTypeDto = new AccountType(Long.valueOf(1),"MILES","Miles",LocalDate.now());
       // when(repository.save(any(AccountType.class))).thenReturn(accountTypeDto);
        AccountTypeDto res = translator.create(null);
        assertNotNull(res);
        //verify(repository, atLeastOnce()).save(any(AccountType.class));
        assertEquals(expectedResponse, res.toString());

    }

    @Test
    public void create() {

            String expectedResponse = "AccountTypeDto{accountTypeId='1'accountTypeCode='MILES', accountTypeName='Miles', accountTypeDateCreated="+LocalDate.now()+"}";

            AccountType accountTypeDto = new AccountType(Long.valueOf(1),"MILES","Miles",LocalDate.now());
            when(repository.save(any(AccountType.class))).thenReturn(accountTypeDto);
            AccountTypeDto res = translator.create(new AccountTypeDto());
            assertNotNull(res);
            verify(repository, atLeastOnce()).save(any(AccountType.class));
            assertEquals(expectedResponse, res.toString());

    }
    @Test
    public void getAccountTypeByAccountTypeCodeNativeQuery() {
        String expectedResponse = "AccountTypeDto{accountTypeId='1'accountTypeCode='MILES', accountTypeName='Miles', accountTypeDateCreated="+LocalDate.now()+"}";
        AccountType accountTypeDto = new AccountType(Long.valueOf(1),"MILES","Miles",LocalDate.now());
        when(repository.getAccountTypeByAccountTypeCodeNativeQuery(anyString())).thenReturn(accountTypeDto);
        AccountTypeDto res = translator.getAccountTypeByAccountTypeCodeNativeQuery("memberFullName");
        assertNotNull(res);
        verify(repository, atLeastOnce()).getAccountTypeByAccountTypeCodeNativeQuery(anyString());
        assertEquals(expectedResponse, res.toString());

    }
    @Test(expected = RuntimeException.class)
    public void getAccountTypeByAccountTypeCodeNativeQueryError() {
            String expectedResponse = "AccountTypeDto{accountTypeId='1'accountTypeCode='MILES', accountTypeName='Miles', accountTypeDateCreated="+LocalDate.now()+"}";
            AccountType accountTypeDto = new AccountType(Long.valueOf(1),"MILES","Miles",LocalDate.now());
            //when(repository.getAccountTypeByAccountTypeCodeNativeQuery(anyString())).thenReturn(accountTypeDto);
            AccountTypeDto res = translator.getAccountTypeByAccountTypeCodeNativeQuery(null);
            assertNotNull(res);
          //  verify(repository, atLeastOnce()).getAccountTypeByAccountTypeCodeNativeQuery(anyString());
            assertEquals(expectedResponse, res.toString());

    }
}