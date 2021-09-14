//package com.codegym.cms.service.transfer;
//
//import com.codegym.cms.model.Transfer;
//import com.codegym.cms.repository.ITransferRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.Optional;
//
//public class TransferService implements ITransferServicce{
//
//    @Autowired
//    ITransferRepository transferRepository;
//
//    @Override
//    public Iterable<Transfer> findAll() {
//        return transferRepository.findAll();
//    }
//
//    @Override
//    public Optional<Transfer> findById(Long id) {
//       return transferRepository.findById(id);
//    }
//
//    @Override
//    public void save(Transfer transfer) {
//        transferRepository.save(transfer);
//    }
//
//    @Override
//    public void remove(Long id) {
//        transferRepository.deleteById(id);
//    }
//}
