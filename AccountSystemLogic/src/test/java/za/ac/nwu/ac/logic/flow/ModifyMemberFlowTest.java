package za.ac.nwu.ac.logic.flow;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoJUnitRunner;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.logic.flow.impl.ModifyMemberFlowImpl;
import za.ac.nwu.ac.translator.MemberTranslator;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class ModifyMemberFlowTest {

    @Mock
    private MemberTranslator translator;
    @InjectMocks
    private ModifyMemberFlowImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addAccountBalance() {
        try {
            String expectedResponse = "MemberDto{memberId='1'memberFullName='JAMMY', balance=50.2}";
            MemberDto memberDto =new MemberDto(Long.valueOf(1),"JAMMY",50.20);
            when(translator.addAccountBalance(anyString(), anyDouble())).thenReturn(memberDto);
            MemberDto res = flow.addAccountBalance("memberFullName", 10.00);
            assertNotNull(res);
            verify(translator, atLeastOnce()).addAccountBalance(anyString(), anyDouble());
            assertEquals(expectedResponse, res.toString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }

    @Test
    public void subtractAccountBalance() {
        try {
            String expectedResponse = "MemberDto{memberId='1'memberFullName='JAMMY', balance=50.2}";
            MemberDto memberDto = new MemberDto(Long.valueOf(1),"JAMMY",50.20);
            when(translator.subtractAccountBalance(anyString(), anyDouble())).thenReturn(memberDto);
            MemberDto res = flow.subtractAccountBalance("memberFullName", 10.00);
            assertNotNull(res);
            verify(translator, atLeastOnce()).subtractAccountBalance(anyString(), anyDouble());
            assertEquals(expectedResponse, res.toString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }
}