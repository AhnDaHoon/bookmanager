package com.dh.jpa.bookmanager.domain;

import com.sun.istack.NotNull;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @NotNull
    private String name;
    @NotNull
    private String email;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;


}
