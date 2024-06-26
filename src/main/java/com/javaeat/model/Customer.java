package com.javaeat.model;

import com.javaeat.security.model.User;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "customer")
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true ,callSuper = false)
public class Customer  extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    @EqualsAndHashCode.Include
    private Integer id;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Cart cart;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Order> orders;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    private List<Address> addresses ;
}
