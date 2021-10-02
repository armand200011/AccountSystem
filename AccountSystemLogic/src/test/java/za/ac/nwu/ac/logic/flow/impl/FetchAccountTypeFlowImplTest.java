package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FetchAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;
    @InjectMocks
    private FetchAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllAccountTypes() {
        try {
            String expectedResponse = "[AccountTypeDto{accountTypeId='1'accountTypeCode='accountTypeCode', accountTypeName='name'}]";
            List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
            accountTypeDtos.add(new AccountTypeDto(Long.valueOf(1),"accountTypeCode", "name"));
            when(translator.getAllAccountTypes()).thenReturn(accountTypeDtos);
            List<AccountTypeDto> res = flow.getAllAccountTypes();
            assertNotNull(res);
            verify(translator, atLeastOnce()).getAllAccountTypes();
            assertEquals(expectedResponse, res.toString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }

    @Test
    public void getAccountTypeByAccountTypeCode() {
        try {
            String expectedResponse = "AccountTypeDto{accountTypeId='1'accountTypeCode='accountTypeCode', accountTypeName='name'}";
            AccountTypeDto accountTypeDto = new AccountTypeDto(Long.valueOf(1),"accountTypeCode", "name");
            when(translator.getAccountTypeByAccountTypeCodeNativeQuery(anyString())).thenReturn(accountTypeDto);
            AccountTypeDto res = flow.getAccountTypeByAccountTypeCode("accountTypeCode");
            assertNotNull(res);
            verify(translator, atLeastOnce()).getAccountTypeByAccountTypeCodeNativeQuery(anyString());
            assertEquals(expectedResponse, res.toString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }
}