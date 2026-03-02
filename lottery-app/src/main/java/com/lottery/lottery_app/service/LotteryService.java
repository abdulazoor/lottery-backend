package com.lottery.lottery_app.service;

import com.lottery.lottery_app.model.Lottery;
import com.lottery.lottery_app.repository.LotteryRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class LotteryService {

    private final LotteryRepository repository;
    private static final double JACKPOT = 10000.0;

    public LotteryService(LotteryRepository repository) {
        this.repository = repository;
    }

    public Lottery playLottery(String name, String mobile, String selectedSequence) {

        String drawnSequence = generateRandomSequence();

        double percentage = calculateWinningPercentage(selectedSequence, drawnSequence);
        double amountWon = (percentage / 100.0) * JACKPOT;

        Lottery lottery = new Lottery();
        lottery.setParticipantName(name);
        lottery.setMobileNumber(mobile);
        lottery.setSelectedSequence(selectedSequence);
        lottery.setDrawnSequence(drawnSequence);
        lottery.setPercentageWon(percentage);
        lottery.setAmountWon(amountWon);

        return repository.save(lottery);
    }

    public String generateRandomSequence() {
        Random random = new Random();

        List<Integer> digits = new ArrayList<>();
        while (digits.size() < 4) {
            int num = random.nextInt(10);
            if (!digits.contains(num)) {
                digits.add(num);
            }
        }

        char letter = (char) ('A' + random.nextInt(26));

        return digits.get(0) + " " + digits.get(1) + " " +
                digits.get(2) + " " + digits.get(3) + " " + letter;
    }

    private double calculateWinningPercentage(String selected, String drawn) {

        String[] sel = selected.split(" ");
        String[] dr = drawn.split(" ");

        double percentage = 0;

        // check digits
        for (int i = 0; i < 4; i++) {
            if (sel[i].equals(dr[i])) {
                percentage += 20;
            } else {
                for (int j = 0; j < 4; j++) {
                    if (i != j && sel[i].equals(dr[j])) {
                        percentage += 10;
                    }
                }
            }
        }

        // check letter
        if (sel[4].equals(dr[4])) {
            percentage += 10;
        }

        // perfect match
        if (selected.equals(drawn)) {
            percentage = 100;
        }

        return percentage;
    }
}