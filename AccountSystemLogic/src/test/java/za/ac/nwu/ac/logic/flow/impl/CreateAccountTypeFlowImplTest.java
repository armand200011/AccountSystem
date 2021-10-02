package za.ac.nwu.ac.logic.flow.impl;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.translator.AccountTypeTranslator;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateAccountTypeFlowImplTest {

    @Mock
    private AccountTypeTranslator translator;
    @InjectMocks
    private CreateAccountTypeFlowImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        try {
            AccountTypeDto accountTypeDto = new AccountTypeDto("accountTypeCode", "name");
            when(translator.create(any(AccountTypeDto.class))).thenReturn(accountTypeDto);
            AccountTypeDto res = flow.create(new AccountTypeDto());
            assertNotNull(res);
            verify(translator, atLeastOnce()).create(any(AccountTypeDto.class));
        } catch (Exception e) {
            assertTrue("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reasone the CreateAccountTypeFlowImplTest could not complete"));
        }
    }
}