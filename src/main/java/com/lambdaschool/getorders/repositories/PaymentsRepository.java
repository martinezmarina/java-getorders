package com.lambdaschool.getorders.repositories;

import com.lambdaschool.getorders.models.Payment;
import org.springframework.data.repository.CrudRepository;

public interface PaymentsRepository extends CrudRepository<Payment, Long> {
}
