package com.idea.pruebas.dto;

import com.idea.pruebas.entity.Message;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MessageResponseDto {

    public String message;

    public Long expiration;

    public MessageResponseDto(Message message) {
        this.message = message.getMessage();
        this.expiration = message.getExpiration();
    }
}
