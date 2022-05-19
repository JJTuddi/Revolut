package com.app.banking.service;

import com.app.banking.data.dto.mapper.CardMapper;
import com.app.banking.data.dto.model.CardDto;
import com.app.banking.data.sql.entity.Card;
import com.app.banking.data.sql.repo.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;

    public CardDto findById(Long id){       //TODO test
        return cardRepository.findById(id)      //TODO test
                .map(cardMapper::cardToCardDto)
                .orElseThrow(() -> new RuntimeException(format("Card with id %s not found", id)));
    }

    public List<CardDto> findAll(){
        return cardRepository.findAll().stream()
                .map(cardMapper::cardToCardDto)
                .collect(Collectors.toList());
    }

    public List<CardDto> allCardsByOwner(Long id){
        return cardRepository.findAllByOwnerId(id).stream()
                .map(cardMapper::cardToCardDto)
                .collect(Collectors.toList());
    }

    public CardDto addCard(CardDto cardDto){
        return cardMapper.cardToCardDto(
                cardRepository.save(
                        cardMapper.cardDtoToCard(cardDto)));
    }

    public CardDto update(Long id, CardDto cardDto){
        Card cardEntity = cardMapper.cardDtoToCard(cardDto);
        cardEntity.setId(id);

       return cardMapper.cardToCardDto(cardRepository.save(cardEntity));
    }

    public void delete(Long id){
        cardRepository.deleteById(id);
    }
}
