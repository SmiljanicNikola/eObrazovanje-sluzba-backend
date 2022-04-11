package ftn.uns.eObrazovanje.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ftn.uns.eObrazovanje.model.Payment;

@Repository
public interface PaymentRepo extends JpaRepository<Payment, Integer>{
}
