package ftn.uns.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{

}
