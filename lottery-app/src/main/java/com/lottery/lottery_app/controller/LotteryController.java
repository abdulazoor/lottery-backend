package com.lottery.lottery_app.controller;

import com.lottery.lottery_app.model.Lottery;
import com.lottery.lottery_app.service.LotteryService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/lottery")
@CrossOrigin
public class LotteryController {

    private final LotteryService service;

    public LotteryController(LotteryService service) {
        this.service = service;
    }

    @GetMapping("/play")
    public Lottery play(
            @RequestParam String name,
            @RequestParam String mobile,
            @RequestParam String selectedSequence) {

        return service.playLottery(name, mobile, selectedSequence);
    }

    @GetMapping("/tickets")
    public List<String> generateTickets() {
        List<String> tickets = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            tickets.add(service.generateRandomSequence());
        }

        return tickets;
    }
}