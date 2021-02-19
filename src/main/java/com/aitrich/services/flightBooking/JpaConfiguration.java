package com.aitrich.services.flightBooking;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages = {"com.aitrich.services.flightBooking.domain.repo"})
public class JpaConfiguration {

}
