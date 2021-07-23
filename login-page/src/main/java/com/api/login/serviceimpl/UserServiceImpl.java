package com.api.login.serviceimpl;

import com.api.login.dto.LoginResponseDto;
import com.api.login.dto.UserDto;
import com.api.login.entity.Application;
import com.api.login.entity.Mortgage;
import com.api.login.entity.TransactionalAccount;
import com.api.login.exception.UserNotFoundException;
import com.api.login.repository.ApplicationRepository;
import com.api.login.repository.MortgageRepository;
import com.api.login.repository.TransactionalRepository;
import com.api.login.service.UserService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class UserServiceImpl implements UserService {
    @Autowired
    ApplicationRepository applicationRepository;
    @Autowired
    TransactionalRepository transactionalRepository;
    @Autowired
    MortgageRepository mortgageRepository;
    @Override

    public LoginResponseDto getlogInUserDetails(UserDto userDto) {

        Optional<Application> applications = applicationRepository.findById(userDto.getCustomerId());
        LoginResponseDto loginResponseDto = new LoginResponseDto();
        if (applications.isPresent()) {
            if (userDto.getCustomerId().toString().equalsIgnoreCase(applications.get().getCustomerId().toString()) &&
                    userDto.getPassword().equalsIgnoreCase(applications.get().getPassword())) {
                Optional<TransactionalAccount> transactionalAccount = transactionalRepository.findById(applications.get().getTransactionalAccNo());
                Optional<Mortgage> mortgage = mortgageRepository.findById(applications.get().getMortgageAccNo());
                if(mortgage.isPresent()) {
                    loginResponseDto.setMortgageAccountNumber(mortgage.get().getAccountNumber());
                    loginResponseDto.setMortgageAmount(mortgage.get().getAmount());
                    loginResponseDto.setMortgageBalance(mortgage.get().getBalance());
                    loginResponseDto.setMortgageComment(mortgage.get().getComment());
                    loginResponseDto.setMortgagedateTime(mortgage.get().getDateTime());
                }if(transactionalAccount.isPresent()){
                    loginResponseDto.setTransactionalAccountNumber(transactionalAccount.get().getAccountNumber());
                    loginResponseDto.setTransactionalAmount(transactionalAccount.get().getAmount());
                    loginResponseDto.setMortgageBalance(transactionalAccount.get().getBalance());
                    loginResponseDto.setTransactionalComment(transactionalAccount.get().getComment());
                    loginResponseDto.setTransactionaldateTime(transactionalAccount.get().getDateTime());
                }
            }else{
                throw new UserNotFoundException("User is Not Available!");
            }
            return loginResponseDto;

        }
        return loginResponseDto;
    }


}
