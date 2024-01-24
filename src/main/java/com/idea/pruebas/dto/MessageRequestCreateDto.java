package com.idea.pruebas.dto;

import com.idea.pruebas.entity.Message;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor

public class MessageRequestCreateDto implements Serializable {

    public String message;

    public Long expiration;

    public String receptor;

    public Long id_receptor;

    public MessageRequestCreateDto(Message message, String receptor, Long id_receptor) {
        this.message = message.getMessage();
        this.expiration = message.getExpiration();

    }
}
