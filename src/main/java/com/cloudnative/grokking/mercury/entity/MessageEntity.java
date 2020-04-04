package com.cloudnative.grokking.mercury.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

/**
 * @author nghiatn
 */

@Getter
@Setter
@Builder
@Entity
@Table(name = "Message")
public class MessageEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String content;
}
