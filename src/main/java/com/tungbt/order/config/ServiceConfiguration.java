package com.tungbt.order.config;

import javax.persistence.criteria.CriteriaBuilder.In;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix="service-config")
@Getter
@Setter
@ToString
public class ServiceConfiguration {

  private String customerServiceHost;

  private Integer customerServicePort;

}
