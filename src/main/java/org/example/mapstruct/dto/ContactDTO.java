package org.example.mapstruct.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContactDTO {
    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
}
