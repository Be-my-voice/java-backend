package com.bemyvoice.bemyvoicebackend.respository;

import com.bemyvoice.bemyvoicebackend.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

}
