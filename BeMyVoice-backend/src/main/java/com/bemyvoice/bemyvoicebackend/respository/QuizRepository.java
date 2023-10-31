package com.bemyvoice.bemyvoicebackend.respository;

import com.bemyvoice.bemyvoicebackend.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuizRepository extends JpaRepository<Quiz, Long> {

    List<Quiz> findByEnabled(boolean b);
}
