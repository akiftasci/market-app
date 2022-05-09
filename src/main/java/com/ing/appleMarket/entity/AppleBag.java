package com.ing.appleMarket.entity;

import com.ing.appleMarket.validator.Supplier;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

@Setter
@Getter
@Entity
@Table(name = "appleBag")
public class AppleBag {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "amount")
    @DecimalMin(value = "1", message = "Minimum amount can be 1")
    @DecimalMax(value = "100", message = "Maximum amount can be 100")
    private int amount;

    @Supplier
    @Column(name = "supplier")
    private String supplier;

    @Column(name = "datetime", nullable = false, updatable = false)
    @CreationTimestamp
    private LocalDateTime created;

    @Column(name = "price")
    @DecimalMin(value = "1", message = "Minimum amount can be 1")
    @DecimalMax(value = "50", message = "Maximum amount can be 50")
    private int price;
}
