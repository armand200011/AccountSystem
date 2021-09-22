package za.ac.nwu.ac.web.sb.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.service.GeneralResponse;
import za.ac.nwu.ac.logic.flow.CreateAccountTypeFlow;
import za.ac.nwu.ac.logic.flow.CreateMemberFlow;
import za.ac.nwu.ac.logic.flow.FetchMemberFlow;
import za.ac.nwu.ac.logic.flow.ModifyMemberFlow;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("member")
public class MemberController {
    private FetchMemberFlow fetchMemberFlow;
    private CreateMemberFlow createMemberFlow;
    private ModifyMemberFlow modifyMemberFlow;

    @Autowired
    public MemberController(FetchMemberFlow fetchMemberFlow,
                 @Qualifier("createMemberFlowName") CreateMemberFlow createMemberFlow,
                            ModifyMemberFlow modifyMemberFlow) {

        this.fetchMemberFlow = fetchMemberFlow;
        this.createMemberFlow = createMemberFlow;
        this.modifyMemberFlow = modifyMemberFlow;
    }


    @GetMapping("/all")
    @ApiOperation(value = "Gets all the configured Account types", notes = "Returns a list of account types")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Account types returned", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<List<MemberDto>>> getAll(){
        List<MemberDto> members = fetchMemberFlow.getAllMembers();
        GeneralResponse<List<MemberDto>> response = new GeneralResponse<>(true, members);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping("")
    @ApiOperation(value = "Create a new member", notes = "Create a new member in the database")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "The member was created successfully", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> create(
            @ApiParam(value = "Request body to create new member", required = true)
            @RequestBody MemberDto member){
        MemberDto memberResponse = createMemberFlow.create(member);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true, memberResponse);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }



    @GetMapping("{memberFullName}")
    @ApiOperation(value = "Fetches the specified Member", notes = "Fetches the Member corresponding MemberFullName")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Goal found", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> getAccountBalance(
            @ApiParam(value = "The memberFullName that uniquely identifies the Member",
                    example = "Johan",
                    name = "memberFullName",
                    required = true)
            @PathVariable("memberFullName")final String memberFullName){
        MemberDto member = fetchMemberFlow.getAccountBalance(memberFullName);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true,member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }




    @PutMapping("{memberFullName}")
    @ApiOperation(value = "Add the specified amount to the Member's balance", notes = "Add the specified amount to the balance of the Member corresponding MemberFullName")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Balance updated", response = GeneralResponse.class),
            @ApiResponse(code = 400, message = "Bad Request", response = GeneralResponse.class),
            @ApiResponse(code = 404, message = "Not found", response = GeneralResponse.class),
            @ApiResponse(code = 500, message = "Internal Server Error", response = GeneralResponse.class)
    })
    public ResponseEntity<GeneralResponse<MemberDto>> addToMemberBalance(
            @ApiParam(value = "The memberFullName that uniquely identifies the Member",
                    example = "Johan",
                    name = "memberFullName",
                    required = true)
            @PathVariable("memberFullName")final String memberFullName,
            @ApiParam(value = "The amount the balance will be increased by for the specified Member",
            example = "5.55",
            name = "amount",
            required = true)
            @RequestParam("amount") final Double amount){
        MemberDto member = modifyMemberFlow.addAccountBalance(memberFullName,amount);
        GeneralResponse<MemberDto> response = new GeneralResponse<>(true,member);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
