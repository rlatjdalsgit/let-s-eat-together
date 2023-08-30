package Lets_Eat.Lets_Meal.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private String device_id;

//    @OneToMany(mappedBy = "member") //일대다, 고객하나에 주문은 여러개 가능하니가. 오ej
//    //오더 테이블에 매핑되었다.읽기전용느낌
//    private List<Order> orders = new ArrayList<>();
}
