package com.javaeat.model;

import com.javaeat.enums.Status;
import com.javaeat.request.RestaurantRequest;
import lombok.*;

import jakarta.persistence.*;
import java.time.LocalTime;
import java.util.List;

@Setter
@Getter
@NoArgsConstructor
@Entity
@Table(name = "Restaurant")
@AllArgsConstructor
@Builder
@EqualsAndHashCode(callSuper = false)
public class Restaurant extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "restaurant_id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;
    @Column(name = "location")
    private String location;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status restaurantStatus;
    @Column(name = "opening_time")
    private LocalTime OpeningTime;
    @Column(name = "closing_time")
    private LocalTime ClosingTime;
    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "restaurant_id")
    private List<Address> addresses ;
    @OneToMany(mappedBy = "restaurant" , fetch = FetchType.LAZY)
    private List<Order> orders;
    public static Restaurant buildRestaurant(RestaurantRequest request){
        Restaurant restaurant = Restaurant.builder()
                .id(request.getId())
                .name(request.getName())
                .description(request.getDescription())
                .location(request.getLocation())
                .restaurantStatus(request.getStatus())
                .restaurantStatus(Status.ACTIVE)
                .build();
        restaurant.setCreatedBy(request.getCreatedBy());
        restaurant.setUpdatedBy(request.getUpdatedBy());
        return restaurant;
    }
}
