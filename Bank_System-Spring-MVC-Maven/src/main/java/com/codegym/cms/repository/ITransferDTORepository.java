//package com.codegym.cms.repository;
//
//import com.codegym.cms.DTO.TransferDTO;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.PagingAndSortingRepository;
//
//import java.util.List;
//
//public interface ITransferDTORepository extends PagingAndSortingRepository<TransferDTO,Long> {
//
//    @Query(value = "select t.id, t.idSender, c1.c_name AS nameSender, t.idReceiver, c2.c_name AS nameReceiver, t.amount, t.fee_percent, t.total_amount from transfers t join customers c1\n" +
//            "\t\tON t.idSender = c1.id\n" +
//            "        JOIN customers c2\n" +
//            "        ON t.idReceiver= c2.id",nativeQuery = true)
//    List<TransferDTO> listHistory();
//}
