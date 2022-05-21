package com.app.banking.service;

import com.app.banking.data.dto.mapper.CardMapper;
import com.app.banking.data.dto.model.CardDto;
import com.app.banking.data.sql.entity.Card;
import com.app.banking.data.sql.entity.CardStatus;
import com.app.banking.data.sql.entity.CardType;
import com.app.banking.data.sql.entity.User;
import com.app.banking.data.sql.repo.CardRepository;
import com.app.banking.data.sql.repo.CardStatusRepository;
import com.app.banking.data.sql.repo.CardTypeRepository;
import com.app.banking.data.sql.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CardService {
    private final CardRepository cardRepository;
    private final CardMapper cardMapper;
    private final UserRepository userRepository;
    private final CardTypeRepository cardTypeRepository;
    private final CardStatusRepository cardStatusRepository;

    public CardDto findById(Integer id){       //TODO test
        return cardRepository.findById(id)
                .map(cardMapper::cardToCardDto)
                .orElseThrow(() -> new RuntimeException(format("Card with id %s not found", id)));
    }

    public List<CardDto> findAll(){
        return cardRepository.findAll().stream()
                .map(cardMapper::cardToCardDto)
                .collect(Collectors.toList());
    }

    public List<CardDto> allCardsByOwner(Integer id){
        return cardRepository.findAllByOwnerId(id).stream()
                .map(cardMapper::cardToCardDto)
                .collect(Collectors.toList());
    }

    public CardDto addCard(CardDto cardDto){
        Optional<User> userOp = userRepository.findByUsername(cardDto.getOwner().getUsername());
        Optional<CardType> cardTypeOp = cardTypeRepository.findByNameLike(cardDto.getCardType().getName());
        Optional<CardStatus> cardStatusOp = cardStatusRepository.findByNameLike(cardDto.getCardStatus().getName());

        Card card = cardMapper.cardDtoToCard(cardDto);

        userOp.ifPresent(card::setOwner);
        cardTypeOp.ifPresent(card::setCardType);
        cardStatusOp.ifPresent(card::setCardStatus);

        CardDto cardDtoAdded;

        try{
            cardDtoAdded = cardMapper.cardToCardDto(cardRepository.save(card));
        }catch(Exception e){
            cardDtoAdded = null;
        }

        return cardDtoAdded;
    }

    public CardDto update(Integer id, CardDto cardDto){
        Card cardEntity = cardMapper.cardDtoToCard(cardDto);
        cardEntity.setId(id);

       return cardMapper.cardToCardDto(cardRepository.save(cardEntity));
    }

    public void delete(Integer id){
        cardRepository.deleteById(id);
    }
}
