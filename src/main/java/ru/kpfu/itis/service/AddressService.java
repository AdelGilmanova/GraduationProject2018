package ru.kpfu.itis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kpfu.itis.entity.Address;
import ru.kpfu.itis.repository.AddressRepository;

/**
 * Created by Adel on 01.05.2017.
 */
@Service
public class AddressService {
    @Autowired
    private AddressRepository addressRepository;

    public Address getAddressByUserId(Long userId) {
        return addressRepository.getAddressByUserId(userId);
    }

    public void addAddress(Address address) {
        addressRepository.save(address);
    }
}
