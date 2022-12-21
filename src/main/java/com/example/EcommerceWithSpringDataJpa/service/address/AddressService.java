package com.example.EcommerceWithSpringDataJpa.service.address;

import com.example.EcommerceWithSpringDataJpa.entity.Address;
import com.example.EcommerceWithSpringDataJpa.entity.Customer;
import com.example.EcommerceWithSpringDataJpa.exception.AddressNotFoundException;

import java.util.List;

public interface AddressService {

    Address createAddress(Address address, Customer customer);
    List<Address> getUserAddresses(int userId);
    Address getAddressById(int addressId) throws AddressNotFoundException;
    Address updateAddress(int addressId, Address updatedAddress) throws AddressNotFoundException;
    void deleteAddress(int addressId) throws AddressNotFoundException;

}
