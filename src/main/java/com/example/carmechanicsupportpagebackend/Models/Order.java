package com.example.carmechanicsupportpagebackend.Models;

/*import jakarta.persistence.*;

@Entity
@Table(name = "ORDER")*/
public class Order {

    /*@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ORDER_ID", nullable = false)*/
    private int order_id;

    //@Column(name = "SEVERITY", nullable = false, length = 50)
    private String severity;

    //@Column(name = "APPROXIMATE_POSITION", nullable = false, length = 100)
    private String approximate_position;

    //@Column(name = "DESCRIPTION", nullable = false, length = 400)
    private String description;
}
