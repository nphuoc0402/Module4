package com.codegym.cms.repository;


import com.codegym.cms.model.Transfer;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface ITransferRepository extends PagingAndSortingRepository<Transfer,Long> {

}
