package com.cg.service.customer;

import com.cg.dto.DepositDTO;
import com.cg.dto.RecipientDTO;
import com.cg.dto.TransferDTO;
import com.cg.dto.WithdrawDTO;
import com.cg.model.Customer;
import com.cg.service.IGeneralService;

import java.math.BigDecimal;
import java.util.Optional;

public interface ICustomerService extends IGeneralService <Customer> {
   Boolean existByEmail(String email);

   Iterable<Customer> findAllByDeletedIsFalse();

   Optional<DepositDTO> findByIdWithDepositDTO(Long id);

   Optional<WithdrawDTO> findByIdWithWithdrawDTO(Long id);

   Iterable<RecipientDTO> findAllRecipientDTOByIdWithOutSender(Long id);

   Iterable<RecipientDTO> findAllRecipientDTOByIdWithOutSenderAndDeletedIsFalse(Long id);

   void doDeposit(DepositDTO depositDTO);

   void doWithdraw(WithdrawDTO withdrawDTO);

   void doTransfer(TransferDTO transferDTO,Optional<Customer> sender, Optional<Customer> recipient);

   void incrementBalance(BigDecimal balance, Long id);

   void decreaseBalance(BigDecimal balance, Long id);

}
