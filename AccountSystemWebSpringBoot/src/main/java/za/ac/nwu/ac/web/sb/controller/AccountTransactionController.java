package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTransactionFlow;
import za.ac.nwu.ac.logic.flow.FetchAccountTransactionFlow;


import java.util.List;

@RestController
@RequestMapping("account-transaction")
public class AccountTransactionController {/*

    private final FetchAccountTransactionFlow fetchAccountTransactionFlowFlow;
    private final CreateAccountTransactionFlow createAccountTransactionFlowFlow;


    public AccountTransactionController(FetchAccountTransactionFlow fetchAccountTransactionFlowFlow, CreateAccountTransactionFlow createAccountTransactionFlowFlow) {
        this.fetchAccountTransactionFlowFlow = fetchAccountTransactionFlowFlow;
        this.createAccountTransactionFlowFlow = createAccountTransactionFlowFlow;
    }

    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured AccountTransactions", notes = "Returns a list of accountTransactions")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account transaction returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<AccountTransactionDto>>> getAll(){
        List<AccountTransactionDto> accountTransactions = fetchAccountTransactionFlowFlow.getAllAccountTransactions();
        GeneralResponse<List<AccountTransactionDto>> response = new GeneralResponse<>(true, accountTransactions);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }


    @PostMapping("/new")
    @ApiOperation(value = "Create a new accountTransaction", notes = "Create a new accountTransaction in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The accountTransaction was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> create(
            @ApiParam(value = "Request body to create new accountTransaction", required = true)
            @RequestBody AccountTransactionDto accountType){
        AccountTransactionDto accountTypeResponse = createAccountTransactionFlowFlow.create(accountType);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true, accountTypeResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping("{accountTransactionId}")
    @ApiOperation(value = "Fetches the specified AccountTransaction", notes = "Fetches the AccountTransaction corresponding AccountTransactionId")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<AccountTransactionDto>> getAccountType(
            @ApiParam(value = "The accountTransaction that uniquely identifies the AccountTransactionId",
                    example = "MILES",
                    name = "accountTypeCode",
                    required = true)
            @PathVariable("accountTypeCode") final String accountTypeCode){
        AccountTransactionDto accountType = fetchAccountTransactionFlowFlow.getAccountTransactionByAccountTransactionId(accountTypeCode);
        GeneralResponse<AccountTransactionDto> response = new GeneralResponse<>(true,accountType);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }*/
}
