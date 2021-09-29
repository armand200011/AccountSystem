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
import za.ac.nwu.ac.translator.impl.MemberTranslatorImpl;

import java.time.LocalDate;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class CreateMemberFlowImplTest {

    @Mock
    private MemberTranslator translator;
    @InjectMocks
    private CreateMemberFlowImpl flow;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void create() {
        try {
            MemberDto memberDto = new MemberDto("memberFullname",  50.55);
            when(translator.create(any(MemberDto.class))).thenReturn(memberDto);
            MemberDto res = flow.create(new MemberDto());
            assertNotNull(res);
            verify(translator, atLeastOnce()).create(any(MemberDto.class));
        } catch (Exception e) {
           assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }
}