package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountType;
import za.ac.nwu.ac.domain.persistence.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    @Query(value = "SELECT "+
            "   MEMBER_ID,"+
            "   ACCOUNT_TYPE_ID,"+
            "   MEMBER_FULLNAME,"+
            "   BALANCE,"+
            "   MEMBER_DATE"+
            "   FROM "+
            "   ARMAND.ACCOUNT_MEMBER "+
            "   WHERE MEMBER_FULLNAME = :memberFullName", nativeQuery =true)
    Member getAccountBalanceNativeQuery(String memberFullName);
}
