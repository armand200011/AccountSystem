package za.ac.nwu.ac.web.sb.controller;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.logic.flow.CreateMemberFlow;
import za.ac.nwu.ac.logic.flow.FetchMemberFlow;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;
import za.ac.nwu.ac.repo.persistence.MemberRepository;
import za.ac.nwu.ac.translator.impl.MemberTranslatorImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MemberControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_TYPE_CONTROLLER_URL = APP_URL + "/member";

    @Mock
    private ModifyMemberFlow modifyMemberFlow;
    @Mock
    private FetchMemberFlow fetchMemberFlow;
    @Mock
    private CreateMemberFlow createMemberFlow;
    @InjectMocks
    private MemberController memberController;
    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc= MockMvcBuilders.standaloneSetup(memberController).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":[{\"memberId\":1,\"memberFullName\":\"Armand\",\"balance\":10.5,\"accountTypeId\":1,\"accountTypeCode\":\"MILES\",\"memberDate\":[2020,1,1]}]}";
        List<MemberDto> accountTypes = new ArrayList<>();
        accountTypes.add(new MemberDto(Long.valueOf(1),"Armand", 10.50,Long.valueOf(1),"MILES",LocalDate.parse("2020-01-01")));
        when(fetchMemberFlow.getAllMembers()).thenReturn(accountTypes);
        MvcResult mvcR = mockMvc.perform(get((String.format("%s%s", ACCOUNT_TYPE_CONTROLLER_URL, "/viewAll")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(fetchMemberFlow, times(1)).getAllMembers();
        assertEquals(expectedResponse, mvcR.getResponse().getContentAsString());
    }

    @Test
    public void create() {
        try {
            String val ="{\n" +
                    "  \"memberId\": 1,\n" +
                    "  \"memberFullName\": \"Johan\",\n" +
                    "  \"balance\": 10000.99,\n" +
                    "  \"accountTypeId\": 1,\n" +
                    "  \"accountTypeCode\": \"MILES\",\n" +
                    "  \"memberDate\": \"2021-01-01\"\n" +
                    "}";
            //"{\"memberId\":1,\"memberFullName\":\"Johan\",\"balance\":10.11,\"accountTypeId\":1,\"accountTypeCode\":\"MILES\",\"memberDate\":[2021,01,01]}";
            String expectedResponse = "{\"successful\":true,\"payload\":{\"memberId\":1,\"memberFullName\":\"Johan\",\"balance\":10.11,\"accountTypeId\":1,\"accountTypeCode\":\"MILES\",\"memberDate\":[2021,1,1]}}";
            MemberDto memberDto = new MemberDto(Long.valueOf(1),"Johan", 10.11,Long.valueOf(1),"MILES", LocalDate.parse("2021-01-01"));
            when(createMemberFlow.create(any(MemberDto.class))).thenReturn(memberDto);
            MvcResult mvcR = mockMvc.perform(post((String.format("%s%s", ACCOUNT_TYPE_CONTROLLER_URL, "/createNew")))
                            .servletPath(APP_URL)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(val)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andReturn();
            assertNotNull(mvcR);
            verify(createMemberFlow, atLeastOnce()).create(any(MemberDto.class));
            assertEquals(expectedResponse, mvcR.getResponse().getContentAsString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }

    @Test
    public void getAccountBalance() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":{\"memberId\":1,\"memberFullName\":\"John\",\"balance\":10.21,\"accountTypeId\":1,\"accountTypeCode\":\"MILES\",\"memberDate\":[2020,1,1]}}";
        MemberDto accountTypes = new MemberDto(Long.valueOf(1),"John", 10.21, Long.valueOf(1),"MILES",LocalDate.parse("2020-01-01"));
        when(fetchMemberFlow.getAccountBalance(anyString())).thenReturn(accountTypes);

        MvcResult mvcR = mockMvc.perform(get((String.format("%s%s", ACCOUNT_TYPE_CONTROLLER_URL, "/view/John")))
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(fetchMemberFlow, times(1)).getAccountBalance(anyString());
        assertEquals(expectedResponse, mvcR.getResponse().getContentAsString());
    }

    @Test
    public void addToMemberBalance() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":{\"memberId\":1,\"memberFullName\":\"John\",\"balance\":10.21,\"accountTypeId\":1,\"accountTypeCode\":\"MILES\",\"memberDate\":[2020,1,1]}}";
        MemberDto accountTypes = new MemberDto(Long.valueOf(1),"John", 10.21, Long.valueOf(1),"MILES",LocalDate.parse("2020-01-01"));
        when(modifyMemberFlow.addAccountBalance(anyString(),anyDouble(),any(LocalDate.class))).thenReturn(accountTypes);

        MvcResult mvcR = mockMvc.perform(put((String.format("%s%s", ACCOUNT_TYPE_CONTROLLER_URL, "/addTo/John")))
                        .param("memberFullName","John")
                        .param("amount","50.2")
                        .param("date","2020-01-01")
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(modifyMemberFlow, times(1)).addAccountBalance(anyString(),anyDouble(),any(LocalDate.class));
        assertEquals(expectedResponse, mvcR.getResponse().getContentAsString());
    }

    @Test
    public void subtractToMemberBalance() throws Exception {
        String expectedResponse = "{\"successful\":true,\"payload\":{\"memberId\":1,\"memberFullName\":\"John\",\"balance\":10.21,\"accountTypeId\":1,\"accountTypeCode\":\"MILES\",\"memberDate\":[2020,1,1]}}";
        MemberDto accountTypes = new MemberDto(Long.valueOf(1),"John", 10.21, Long.valueOf(1),"MILES",LocalDate.parse("2020-01-01"));
        when(modifyMemberFlow.subtractAccountBalance(anyString(),anyDouble(),any(LocalDate.class))).thenReturn(accountTypes);

        MvcResult mvcR = mockMvc.perform(put((String.format("%s%s", ACCOUNT_TYPE_CONTROLLER_URL, "/subtractFrom/John")))
                        .param("memberFullName","John")
                        .param("amount","50.2")
                        .param("date","2020-01-01")
                        .servletPath(APP_URL)
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andReturn();

        verify(modifyMemberFlow, times(1)).subtractAccountBalance(anyString(),anyDouble(),any(LocalDate.class));
        assertEquals(expectedResponse, mvcR.getResponse().getContentAsString());
    }
}