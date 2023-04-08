package com.example.QA.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.LocalTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "shop_name")
    private String shopName;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City cityId;
    @ManyToOne
    @JoinColumn(name = "street_id")
    private Street streetId;
    @Column(name = "house_number")
    private String houseNumber;
    @Column(name = "open_time")
    private LocalTime openTime;
    @Column(name = "close_time")
    private LocalTime closeTime;

}
