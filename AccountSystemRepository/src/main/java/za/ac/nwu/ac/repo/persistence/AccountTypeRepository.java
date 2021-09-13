package za.ac.nwu.ac.repo.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import za.ac.nwu.ac.domain.persistence.AccountType;

@Repository
public interface AccountTypeRepository extends JpaRepository<AccountType, Long> {

    @Query(value = "SELECT "+
    "   ACCOUNT_TYPE_ID,"+
    "   ACCOUNT_TYPE_NAME,"+
    "   ACCOUNT_TYPE_DATE_CREATED,"+
    "   ACCOUNT_TYPE_CODE"+
    "   FROM "+
    "   ARMAND.ACCOUNT_TYPE "+
    "   WHERE ACCOUNT_TYPE_CODE = :accountTypeCode", nativeQuery =true)
    AccountType getAccountTypeByAccountTypeCodeNativeQuery(String accountTypeCode);
}
