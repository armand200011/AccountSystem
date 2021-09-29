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
import za.ac.nwu.ac.translator.MemberTranslator;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class FetchMemberFlowImplTest {

    @Mock
    private MemberTranslator translator;
    @InjectMocks
    private FetchMemberFlowImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllMembers() {
        try {
            String expectedResponse = "[MemberDto{memberFullName='memberFullName', balance=10.0}]";
            List<MemberDto> memberDtos = new ArrayList<>();
            memberDtos.add(new MemberDto("memberFullName", 10.00));
            when(translator.getAllMembers()).thenReturn(memberDtos);
            List<MemberDto> res = flow.getAllMembers();
            assertNotNull(res);
            verify(translator, atLeastOnce()).getAllMembers();
            assertEquals(expectedResponse, res.toString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }

    @Test
    public void getAccountBalance() {
        try {
            String expectedResponse = "MemberDto{memberFullName='null', balance=null}";
            MemberDto memberDto = new MemberDto();
            when(translator.getAccountBalanceNativeQuery(anyString())).thenReturn(memberDto);
            MemberDto res = flow.getAccountBalance("memberFullName");
            assertNotNull(res);
            verify(translator, atLeastOnce()).getAccountBalanceNativeQuery(anyString());
            assertEquals(expectedResponse, res.toString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }
}