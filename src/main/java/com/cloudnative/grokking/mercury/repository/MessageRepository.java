package com.cloudnative.grokking.mercury.repository;

import com.cloudnative.grokking.mercury.entity.MessageEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author nghiatn
 */

@Repository
public interface MessageRepository extends JpaRepository<MessageEntity, Long> {
}
