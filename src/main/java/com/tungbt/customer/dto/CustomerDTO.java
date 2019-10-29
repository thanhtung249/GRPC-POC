package com.tungbt.customer.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {

  private int id;

  private String fristName;

  private String lastName;

  private String email;

  private String address;

  private Double balance;

}
