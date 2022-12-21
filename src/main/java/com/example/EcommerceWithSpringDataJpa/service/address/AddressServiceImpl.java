package com.example.EcommerceWithSpringDataJpa.service.address;

import com.example.EcommerceWithSpringDataJpa.entity.Address;
import com.example.EcommerceWithSpringDataJpa.entity.Customer;
import com.example.EcommerceWithSpringDataJpa.exception.AddressNotFoundException;
import com.example.EcommerceWithSpringDataJpa.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;

    @Autowired
    public AddressServiceImpl(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address createAddress(Address address, Customer customer) {
        address.setCustomer(customer);
        address.setOrder(new ArrayList<>());
        return addressRepository.save(address);
    }

    @Override
    public List<Address> getUserAddresses(int userId) {
        return addressRepository.getUserAddresses(userId);
    }

    @Override
    public Address getAddressById(int addressId) throws AddressNotFoundException {
        return addressRepository.findById(addressId).orElseThrow(AddressNotFoundException::new);
    }

    @Override
    public Address updateAddress(int addressId, Address updatedAddress) throws AddressNotFoundException {
        Address address = addressRepository.findById(addressId).orElseThrow(AddressNotFoundException::new);
        address.setStreet(updatedAddress.getStreet());
        address.setCity(updatedAddress.getCity());
        address.setBuildingNumber(updatedAddress.getBuildingNumber());
        return addressRepository.save(address);
    }

    @Override
    public void deleteAddress(int addressId) throws AddressNotFoundException {
        Address address = addressRepository.findById(addressId).orElseThrow(AddressNotFoundException::new);
        addressRepository.delete(address);
    }
}
