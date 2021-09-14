package com.cg.repository;

import com.cg.dto.DepositDTO;
import com.cg.dto.RecipientDTO;
import com.cg.dto.WithdrawDTO;
import com.cg.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestBody;

import java.math.BigDecimal;
import java.util.Optional;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Long> {

    Iterable<Customer> findAllByDeletedIsFalse();

    @Query("SELECT NEW com.cg.dto.DepositDTO(c.id, c.fullName, c.balance) FROM Customer c WHERE c.id = ?1")
    Optional<DepositDTO> findByIdWithDepositDTO(Long id);

    @Query("SELECT NEW com.cg.dto.WithdrawDTO (c.id, c.fullName, c.balance) FROM Customer c WHERE c.id = ?1")
    Optional<WithdrawDTO> findByIdWithWithdrawDTO(Long id);

    @Query("SELECT NEW com.cg.dto.RecipientDTO(c.id, c.fullName) FROM Customer c WHERE c.id <> ?1")
    Iterable<RecipientDTO> findAllRecipientDTOByIdWithoutSender(Long id);

    @Query("SELECT NEW com.cg.dto.RecipientDTO() FROM Customer c WHERE c.id <> ?1 AND c.deleted")
    Iterable<RecipientDTO> findAllRecipientDTOByIdWithoutSenderAndDeletedIsFalse(Long id);

    @Modifying(flushAutomatically = true)
    @Query("UPDATE Customer c SET c.balance = c.balance + :balance WHERE c.id = :id")
    void updateBalance(@Param("balance") BigDecimal balance, @Param("id") Long id);

    @Modifying(flushAutomatically = true)
    @Query("UPDATE Customer c SET c.balance = c.balance + :transferAmount WHERE c.id = :id")
    void incrementBalance(@Param("transferAmount") BigDecimal transferAmount, @Param("id") Long id);

    @Modifying(flushAutomatically = true)
    @Query("UPDATE Customer c Set c.balance = c.balance - :transactionAmount WHERE c.id = :id")
    void decreaseBalance(@Param("transactionAmount") BigDecimal transactionAmount, @Param("id") Long id);

    Boolean existsByEmail(String email);

}
