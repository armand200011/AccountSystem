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
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;
import za.ac.nwu.ac.repo.persistence.MemberRepository;
import za.ac.nwu.ac.translator.impl.AccountTypeTranslatorImpl;
import za.ac.nwu.ac.translator.impl.MemberTranslatorImpl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.AdditionalAnswers.returnsFirstArg;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@RunWith(MockitoJUnitRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AccountTypeControllerTest {

    private static final String APP_URL = "/account-system/mvc";
    private static final String ACCOUNT_TYPE_CONTROLLER_URL = APP_URL + "/account-type";

    @Mock
    private FetchAccountTypeFlow fetchAccountTypeFlow;
    @Mock
    private CreateAccountTypeFlow createAccountTypeFlow;
    @Mock
    private ModifyMemberFlow modifyMemberFlow;
    @InjectMocks
    private AccountTypeController controller;

    private MockMvc mockMvc;

    @Before
    public void setUp() throws Exception {
        mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getAll() throws Exception {
        try{
            String expectedResponse = "{\"successful\":true,\"payload\":[{\"accountTypeID\":1,\"accountTypeCode\":\"MILES\",\"accountTypeName\":\"Miles account type\"}]}";
            List<AccountTypeDto> accountTypes = new ArrayList<>();
            accountTypes.add(new AccountTypeDto(Long.valueOf(1),"MILES", "Miles account type"));
            when(fetchAccountTypeFlow.getAllAccountTypes()).thenReturn(accountTypes);
            String val = String.format("%s%s", ACCOUNT_TYPE_CONTROLLER_URL, "/all");
            MvcResult mvcR = mockMvc.perform(get((String.format("%s%s", ACCOUNT_TYPE_CONTROLLER_URL, "/all")))
                            .servletPath(APP_URL)
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn();

            verify(fetchAccountTypeFlow, times(1)).getAllAccountTypes();
            assertEquals(expectedResponse, mvcR.getResponse().getContentAsString());
        }catch (Exception e) {
                assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }
    }
        /*try {
            String expectedResponse = "<200 OK OK,GeneralResponse{successful=true, payload=[AccountTypeDto{accountTypeCode='null', accountTypeName='null', accountTypeDateCreated=null}]};,[]>";
            List<AccountTypeDto> accountTypeDtos = new ArrayList<>();
            accountTypeDtos.add(new AccountTypeDto());
            when(translator.getAllAccountTypes()).thenReturn(accountTypeDtos);
            ResponseEntity<GeneralResponse<List<AccountTypeDto>>> res =controller.getAll();
            assertNotNull(res);
            verify(translator, atLeastOnce()).getAllAccountTypes();
            assertEquals(expectedResponse, res.toString());
        } catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }*/


    @Test
    public void create() throws Exception {
        //try{
            String expectedResponse = "{\"successful\":true,\"payload\":{\"accountTypeID\":1,\"accountTypeCode\":\"MILES\",\"accountTypeName\":\"Miles\"}}";
        String val = "{\n" +
                "  \"accountTypeID\": 1,\n" +
                "  \"accountTypeCode\": \"MILES\",\n" +
                "  \"accountTypeName\": \"Miles\"\n" +
                "}";
            AccountTypeDto accountType = new AccountTypeDto(Long.valueOf(1),"MILES", "Miles");
            when(createAccountTypeFlow.create(any(AccountTypeDto.class))).thenReturn(accountType);
            //String val = String.format("%s%s", ACCOUNT_TYPE_CONTROLLER_URL, "/new");
      //  GeneralResponse<AccountTypeDto> re = new GeneralResponse<>(true,accountType);

            MvcResult mvcR = mockMvc.perform(post((String.format("%s%s", ACCOUNT_TYPE_CONTROLLER_URL, "/new")))
                            .servletPath(APP_URL)
                            .accept(MediaType.APPLICATION_JSON)
                            .content(val)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isCreated())
                    .andReturn();

            verify(createAccountTypeFlow, times(1)).create(any(AccountTypeDto.class));
            assertEquals(expectedResponse, mvcR.getResponse().getContentAsString());
       /* }catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }*/

    }

    @Test
    public void getAccountBalance() {
        try{
            String expectedResponse = "{\"successful\":true,\"payload\":{\"accountTypeID\":1,\"accountTypeCode\":\"MILES\",\"accountTypeName\":\"Miles account type\"}}";
            AccountTypeDto accountTypes = new AccountTypeDto(Long.valueOf(1),"MILES", "Miles account type");
            when(fetchAccountTypeFlow.getAccountTypeByAccountTypeCode(anyString())).thenReturn(accountTypes);

            MvcResult mvcR = mockMvc.perform(get((String.format("%s%s", ACCOUNT_TYPE_CONTROLLER_URL, "/get/MILES")))
                            .servletPath(APP_URL)
                            .accept(MediaType.APPLICATION_JSON)
                            .contentType(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk())
                    .andReturn();

            verify(fetchAccountTypeFlow, times(1)).getAccountTypeByAccountTypeCode(anyString());
            assertEquals(expectedResponse, mvcR.getResponse().getContentAsString());
        }catch (Exception e) {
            assertFalse("Error message not as expected", e.getMessage().equalsIgnoreCase("Some reason the CreateMemberFlowImplTest could not complete"));
        }

    }
}