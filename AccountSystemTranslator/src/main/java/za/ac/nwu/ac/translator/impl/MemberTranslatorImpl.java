package za.ac.nwu.ac.translator.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import za.ac.nwu.ac.domain.dto.AccountTypeDto;
import za.ac.nwu.ac.domain.dto.MemberDto;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Member;
import za.ac.nwu.ac.repo.persistence.AccountTypeRepository;
import za.ac.nwu.ac.repo.persistence.MemberRepository;
import za.ac.nwu.ac.translator.MemberTranslator;

import java.util.ArrayList;
import java.util.List;

@Component
public class MemberTranslatorImpl implements MemberTranslator {
    private final MemberRepository memberRepository;

    @Autowired
    public MemberTranslatorImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public List<MemberDto> getAllMembers() {
        List<MemberDto> members = new ArrayList<>();
        try {
            for (Member member : memberRepository.findAll()){
                members.add(new MemberDto(member));
            }
        }
        catch (Exception e){
            throw new RuntimeException("Not able to read from database.", e);
        }
        return members;
    }

    @Override
    public MemberDto create(MemberDto memberDto){
        try{
            Member member = memberRepository.save(memberDto.getMember());
            return new MemberDto(member);
        }

        catch (Exception e){
            throw new RuntimeException("Unable to save to database", e);
        }
    }
}
