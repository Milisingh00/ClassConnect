package com.example.classconnect.model.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClassRoomCreationRequestDto {
    String email;
    String name;
    String description;
    String subject;
}
