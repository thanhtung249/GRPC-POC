package com.tungbt.customer.service.impl;

import com.tungbt.customer.constant.GrpcResponseStatusCodeEnum;
import com.tungbt.customer.dto.CustomerDTO;
import com.tungbt.customer.entity.CustomerEntity;
import com.tungbt.customer.mapper.CustomerMapper;
import com.tungbt.customer.repository.CustomerRepository;
import com.tungbt.customer.service.CustomerService;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CustomerServiceImpl implements CustomerService {

  @Autowired
  CustomerRepository customerRepository;

  @Transactional
  @Override
  public GrpcResponseStatusCodeEnum checkAndReduceBalance(Integer customerId, Integer value){
    Optional<CustomerEntity> found = customerRepository.findById(customerId);
    if (found.isPresent()){
      CustomerEntity entity = found.get();
      CustomerDTO dto = CustomerMapper.INSTANCE.customerEntityToCustomerDTO(entity);
      if (value <= dto.getBalance()){
          dto.setBalance(dto.getBalance() - value);
          customerRepository.save(CustomerMapper.INSTANCE.createCustomerDTOToCustomerEntity(dto));
          return GrpcResponseStatusCodeEnum.SUCCESS;
      } else {
        return GrpcResponseStatusCodeEnum.NOT_ENOUGH_BALANCE;
      }
    } else{
      return GrpcResponseStatusCodeEnum.CUSTOMER_NOT_FOUND;
    }

  }
}
