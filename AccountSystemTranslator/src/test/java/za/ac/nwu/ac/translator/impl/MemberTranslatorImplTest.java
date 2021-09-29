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
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repo.persistence.MemberRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class MemberTranslatorImplTest {

    @Mock
    private MemberRepository repository;
    @InjectMocks
    private MemberTranslatorImpl translator;

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAllMembers() {
        try {
            String expectedResponse = "[MemberDto{memberFullName='null', balance=null}]";
            List<Member> member = new ArrayList<>();
            member.add(new Member());
            when(repository.findAll()).thenReturn(member);
            List<MemberDto> res = translator.getAllMembers();
            assertNotNull(res);
            verify(repository, atLeastOnce()).findAll();
            assertEquals(expectedResponse, res.toString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }

    @Test
    public void create() {
        try {
            Member member = new Member("memberFullName", 10.00);
            when(repository.save(any(Member.class))).thenReturn(member);
            MemberDto res = translator.create(new MemberDto(member));
            assertNotNull(res);
            verify(repository, atLeastOnce()).save(any(Member.class));
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }

    @Test
    public void getAccountBalanceNativeQuery() {
        try {
            String expectedResponse = "MemberDto{memberFullName='null', balance=null}";
            Member member = new Member();
            when(repository.getAccountBalanceNativeQuery(anyString())).thenReturn(member);
            MemberDto res = translator.getAccountBalanceNativeQuery("memberFullName");
            assertNotNull(res);
            verify(repository, atLeastOnce()).getAccountBalanceNativeQuery(anyString());
            assertEquals(expectedResponse, res.toString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }

    @Test
    public void addAccountBalance() {
        try {
            String expectedResponse = "MemberDto{memberFullName='memberFullName', balance=20.0}";
            Member member = new Member("memberFullName", 10.00);
            when(repository.getAccountBalanceNativeQuery(anyString())).thenReturn(member);
            MemberDto res = translator.addAccountBalance("memberFullName", 10.00);
            assertNotNull(res);
            verify(repository, atLeastOnce()).getAccountBalanceNativeQuery(anyString());
            assertEquals(expectedResponse, res.toString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }

    @Test
    public void subtractAccountBalance() {
        try {
            String expectedResponse = "MemberDto{memberFullName='memberFullName', balance=0.0}";
            Member member = new Member("memberFullName", 10.00);
            when(repository.getAccountBalanceNativeQuery(anyString())).thenReturn(member);
            MemberDto res = translator.subtractAccountBalance("memberFullName", 10.00);
            assertNotNull(res);
            verify(repository, atLeastOnce()).getAccountBalanceNativeQuery(anyString());
            assertEquals(expectedResponse, res.toString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }
}