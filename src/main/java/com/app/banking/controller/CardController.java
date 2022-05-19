package com.app.banking.controller;

import com.app.banking.data.dto.model.CardDto;
import com.app.banking.service.CardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.app.banking.URLMapping.*;

@RestController
@RequestMapping(CARDS)
@RequiredArgsConstructor
public class CardController {
    private final CardService cardService;

    @GetMapping
    public List<CardDto> allCards(){
        return cardService.findAll();
    }

    @GetMapping(MY_CARDS)
    public List<CardDto> allCardsByOwner(@PathVariable Integer id){
        return cardService.allCardsByOwner(id);
    }

    @PostMapping
    public CardDto create(@RequestBody CardDto card){
        return cardService.addCard(card);
    }

    @PatchMapping(ID)
    public CardDto update(@PathVariable Integer id, @RequestBody CardDto card) {
        return cardService.update(id, card);
    }

    @DeleteMapping(ID)
    public void delete(@PathVariable Integer id) {
        cardService.delete(id);
    }

}
