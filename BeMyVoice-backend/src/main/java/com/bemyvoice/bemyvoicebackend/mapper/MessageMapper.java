package com.bemyvoice.bemyvoicebackend.mapper;

import com.bemyvoice.bemyvoicebackend.dto.MessageDto;
import com.bemyvoice.bemyvoicebackend.entity.Message;

public class MessageMapper {
    public static MessageDto mapToMessageDto(Message message){
        return new MessageDto(
                message.getId(),
                message.getSender(),
                message.getReceiver(),
                message.getMsg(),
                message.getSeen()
        );
    }

    public static Message mapToMessage(MessageDto messageDto){
        return new Message(
                messageDto.getId(),
                messageDto.getSender(),
                messageDto.getReceiver(),
                messageDto.getMsg(),
                messageDto.getSeen()
        );
    }
}
