package com.lottery.lottery_app.model;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lottery {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String participantName;
    private String mobileNumber;

    private String selectedSequence;
    private String drawnSequence;

    private double percentageWon;
    private double amountWon;
}