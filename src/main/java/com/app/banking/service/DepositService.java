package com.app.banking.service;

import com.app.banking.data.dto.mapper.DepositMapper;
import com.app.banking.data.dto.model.CardDto;
import com.app.banking.data.dto.model.DepositDto;
import com.app.banking.data.sql.entity.Card;
import com.app.banking.data.sql.entity.Deposit;
import com.app.banking.data.sql.repo.DepositRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepositService {
    private final DepositRepository depositRepository;
    private final DepositMapper depositMapper;

    public List<DepositDto> findAll(){
        return depositRepository.findAll().stream()
                .map(depositMapper::depositToDepositDto)
                .collect(Collectors.toList());
    }

    public List<DepositDto> allDepositsByOwner(Integer id){
        return depositRepository.findAllByOwnerId(id).stream()
                .map(depositMapper::depositToDepositDto)
                .collect(Collectors.toList());
    }

    public DepositDto addDeposit(DepositDto depositDto){
        return depositMapper.depositToDepositDto(
                depositRepository.save(
                        depositMapper.depositDtoToDeposit(depositDto)));
    }

    public DepositDto update(Integer id, DepositDto depositDto){
        Deposit depositEntity = depositMapper.depositDtoToDeposit(depositDto);
        depositEntity.setId(id);

        return depositMapper.depositToDepositDto(depositRepository.save(depositEntity));
    }

    public void delete(Integer id){
        depositRepository.deleteById(id);
    }
}
