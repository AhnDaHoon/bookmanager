package com.dh.jpa.bookmanager.domain;

import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "MEMBERS")
@Entity
public class User {

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }


    @Id
    @GeneratedValue
    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String email;

    private LocalDateTime createdAt;

    private LocalDateTime updatedAt;



}
