package com.javaeat.model;

import com.javaeat.enums.PaymentMethod;
import com.javaeat.enums.PaymentStatus;
import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@NoArgsConstructor
@Entity
@Table(name = "Payment")
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(callSuper = false)
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private long id ;
    @Column(name = "amount")
    private double amount ;
    @Column(name = "payment_method")
    @Enumerated(EnumType.STRING)
    private PaymentMethod method ;
    @Column(name = "payment_status")
    @Enumerated(EnumType.STRING)
    private PaymentStatus status ;
    @OneToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order;


}
