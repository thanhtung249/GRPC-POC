package com.tungbt.customer.mapper;

import com.tungbt.customer.dto.CustomerDTO;
import com.tungbt.customer.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface CustomerMapper {
  CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

  CustomerEntity createCustomerDTOToCustomerEntity(CustomerDTO request);
  CustomerDTO customerEntityToCustomerDTO(CustomerEntity entity);

}
