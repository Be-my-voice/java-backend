package com.bemyvoice.bemyvoicebackend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "messages")
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "sender")
    private UUID sender;

    @Column(name = "receiver")
    private UUID receiver;

    @Column(name = "msg")
    private String msg;

    @Column(name = "seen")
    private Boolean seen;
}
