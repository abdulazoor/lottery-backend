package com.lottery.lottery_app.repository;

import com.lottery.lottery_app.model.Lottery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LotteryRepository extends JpaRepository<Lottery, Long> {
}