package finos.traderx.positionservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import finos.traderx.positionservice.model.Trade;

public interface TradeRepository extends JpaRepository<Trade, String> {
    
    List<Trade> findByAccountId(Integer id);
    
}
