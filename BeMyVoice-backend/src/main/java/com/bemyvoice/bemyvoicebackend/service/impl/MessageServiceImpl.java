package com.bemyvoice.bemyvoicebackend.service.impl;

import com.bemyvoice.bemyvoicebackend.dto.MessageDto;
import com.bemyvoice.bemyvoicebackend.entity.Message;
import com.bemyvoice.bemyvoicebackend.mapper.MessageMapper;
import com.bemyvoice.bemyvoicebackend.respository.MessageRepository;
import com.bemyvoice.bemyvoicebackend.service.MessageService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MessageServiceImpl implements MessageService {

    private MessageRepository messageRepository;
    @Override
    public MessageDto sendMessage(MessageDto messageDto) {
        Message message = MessageMapper.mapToMessage(messageDto);
        Message savedMessage = messageRepository.save(message);

        return MessageMapper.mapToMessageDto(savedMessage);
    }

    @Override
    public List<MessageDto> receiveMessage(UUID sender, UUID receiver) {
        List<Message> messages = messageRepository.findBySenderAndReceiver(sender, receiver);
        return messages.stream().map((message) -> MessageMapper.mapToMessageDto(message)).collect(Collectors.toList());
    }
}
