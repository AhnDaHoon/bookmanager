package com.dh.jpa.bookmanager.domain;

import com.dh.jpa.bookmanager.domain.listener.Auditable;
import com.dh.jpa.bookmanager.domain.listener.UserEntityListener;
import com.sun.istack.NotNull;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@Table(name = "MEMBERS")
@Entity
@EntityListeners(value =  {AuditingEntityListener.class, UserEntityListener.class})
public class User extends BaseEntity {

    public User(String name, String email){
        this.name = name;
        this.email = email;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

//    @Column(updatable = false) // 업데이트 시 해당 값 저장하지 않음
//    @CreatedDate
//    private LocalDateTime createdAt;
//
////    @Column(insertable = false) // 추가 시 해당 값 저장하지 않음
//    @LastModifiedDate
//    private LocalDateTime updatedAt;

//    @OneToMany(fetch = FetchType.EAGER)
//    private List<Address> address;

    @Transient // 영속성 처리에서 제외되기 때문에 DB에 저장되지 않는다.
               // DB에 저장하지 않고 객체에서 따로 쓰는 필드는 @Transient를 붙여서 사용한다.
    private String testData;

//    @PrePersist
//    public void prePersist(){
//        System.out.println(">>> PrePersist");
//    }
//    @PostPersist
//    public void postPersist(){
//        System.out.println(">>> postPersist");
//    }
//
//    @PreUpdate
//    public void preUpdate(){
//        System.out.println(">>> preUpdate");
//
//    }
//    @PreRemove
//    public void preRemove(){
//        System.out.println(">>> preRemove");
//    }
//
//    @PostUpdate
//    public void postUpdate(){
//        System.out.println(">>> postUpdate");
//    }
//
//    @PostRemove
//    public void postRemove(){
//        System.out.println(">>> postRemove");
//    }
//
//    @PostLoad
//    public void postLoad(){
//        System.out.println(">>> postLoad");
//    }


    // MyEntityListener를 만들어서 중복코드를 제거함
//    @PrePersist
//    public void prePersist(){
//        this.createdAt = LocalDateTime.now();
//        this.updatedAt = LocalDateTime.now();
//    }
//
//    @PreUpdate
//    public void preUpdate(){
//        this.updatedAt = LocalDateTime.now();
//    }

}
