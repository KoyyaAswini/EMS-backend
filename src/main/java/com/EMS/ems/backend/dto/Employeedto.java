package com.EMS.ems.backend.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employeedto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
}

