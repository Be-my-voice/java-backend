package com.bemyvoice.bemyvoicebackend.respository;

import com.bemyvoice.bemyvoicebackend.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionRepository extends JpaRepository<Question, Long> {

}
