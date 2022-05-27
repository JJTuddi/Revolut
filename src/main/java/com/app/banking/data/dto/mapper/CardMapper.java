package com.app.banking.data.dto.mapper;

import com.app.banking.data.dto.model.CardDto;
import com.app.banking.data.sql.entity.Card;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CardMapper {

    Card cardDtoToCard(CardDto cardDto);

    @Mappings({
            @Mapping(target = "cardType.name", source = "cardType.name"),
            @Mapping(target = "currentAmount", source = "currentAmount"),
            @Mapping(target = "cvv", source = "cvv"),
            @Mapping(target = "number", source = "number"),
            @Mapping(target = "expirationDate", source = "expirationDate")
    })
    CardDto cardToCardDto(Card card);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateCardFromCardDto(CardDto cardDto, @MappingTarget Card card);

}
