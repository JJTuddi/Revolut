package com.app.banking.service;

import com.app.banking.data.dto.mapper.DepositMapper;
import com.app.banking.data.dto.model.CardDto;
import com.app.banking.data.dto.model.DepositDto;
import com.app.banking.data.sql.entity.*;
import com.app.banking.data.sql.repo.CardTypeRepository;
import com.app.banking.data.sql.repo.DepositRepository;
import com.app.banking.data.sql.repo.DepositTypeRepository;
import com.app.banking.data.sql.repo.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class DepositService {
    private final DepositRepository depositRepository;
    private final DepositMapper depositMapper;
    private final UserRepository userRepository;
    private final DepositTypeRepository depositTypeRepository;

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
        Optional<User> userOp = userRepository.findByUsername(depositDto.getOwner().getUsername());
        Optional<DepositType> depositTypeOp = depositTypeRepository.findByNameLike(depositDto.getDepositType().getName());


        Deposit deposit = depositMapper.depositDtoToDeposit(depositDto);

        userOp.ifPresent(deposit::setOwner);
        depositTypeOp.ifPresent(deposit::setDepositType);

        DepositDto depositDtoAdded;

        try{
            depositDtoAdded = depositMapper.depositToDepositDto(depositRepository.save(deposit));
        }catch(Exception e){
            depositDtoAdded = null;
        }

        return depositDtoAdded;
    }

    public DepositDto update(Integer id, DepositDto depositDto){
        Deposit depositEntity = depositMapper.depositDtoToDeposit(depositDto);
        depositEntity.setId(id);

        Optional<User> userOp = userRepository.findByUsername(depositDto.getOwner().getUsername());
        Optional<DepositType> depositTypeOp = depositTypeRepository.findByNameLike(depositDto.getDepositType().getName());


        userOp.ifPresent(depositEntity::setOwner);
        depositTypeOp.ifPresent(depositEntity::setDepositType);

        DepositDto depositDtoAdded;

        try{
            depositDtoAdded = depositMapper.depositToDepositDto(depositRepository.save(depositEntity));
        }catch(Exception e){
            depositDtoAdded = null;
        }

        return depositDtoAdded;
    }

    public void delete(Integer id){
        depositRepository.deleteById(id);
    }
}
