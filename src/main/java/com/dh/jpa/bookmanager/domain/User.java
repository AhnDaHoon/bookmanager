package com.dh.jpa.bookmanager.domain;

import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

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
    // enum을 사용할 때 기본 값은 ORDINAL이다. ORDINAL의 문제점은 enum의 index를 저장하기 때문에
    // 리팩토링이나, 다른 사람이 데이터를 추가하거나 데이터의 위치를 바꾸고 나서 조회할 때 이상한 값으로 조회가 된다.
    // 그래서 enum을 사용할 때는 value = EnumType.STRING를 사용해야 한다.
    @Enumerated(value = EnumType.STRING)
    private Gender gender;

    @Column(updatable = false) // 업데이트 시 해당 값 저장하지 않음
    private LocalDateTime createdAt;

//    @Column(insertable = false) // 추가 시 해당 값 저장하지 않음
    private LocalDateTime updatedAt;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

    @Transient // 영속성 처리에서 제외되기 때문에 DB에 저장되지 않는다.
               // DB에 저장하지 않고 객체에서 따로 쓰는 필드는 @Transient를 붙여서 사용한다.
    private String testData;

}
