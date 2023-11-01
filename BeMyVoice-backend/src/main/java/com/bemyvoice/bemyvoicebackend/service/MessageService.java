package com.bemyvoice.bemyvoicebackend.service;

import com.bemyvoice.bemyvoicebackend.dto.MessageDto;
import com.bemyvoice.bemyvoicebackend.entity.Message;

import java.util.List;
import java.util.UUID;

public interface MessageService {

    MessageDto sendMessage(MessageDto messageDto);

    List<MessageDto> receiveMessage(UUID sender, UUID receiver);

}