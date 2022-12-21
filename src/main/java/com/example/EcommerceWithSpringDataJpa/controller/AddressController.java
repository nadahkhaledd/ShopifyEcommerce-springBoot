package com.example.EcommerceWithSpringDataJpa.controller;

import com.example.EcommerceWithSpringDataJpa.dto.AddressDTO;
import com.example.EcommerceWithSpringDataJpa.entity.Address;
import com.example.EcommerceWithSpringDataJpa.entity.Customer;
import com.example.EcommerceWithSpringDataJpa.exception.AddressNotFoundException;
import com.example.EcommerceWithSpringDataJpa.model.Response;
import com.example.EcommerceWithSpringDataJpa.service.address.AddressService;
import com.example.EcommerceWithSpringDataJpa.service.customer.CustomerService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer/{id}/address")
public class AddressController {

    @Autowired
    private ModelMapper modelMapper;
    private AddressService addressService;
    private CustomerService customerService;

    public AddressController(AddressService addressService, CustomerService customerService) {
        this.addressService = addressService;
        this.customerService = customerService;
    }

    @GetMapping
    public List<Address> getUserAddresses(@PathVariable("id") int id) {
        return addressService.getUserAddresses(id);
    }

    @GetMapping("/{addressId}")
    public ResponseEntity<AddressDTO> getAddressById(@PathVariable("addressId") int id) throws AddressNotFoundException {
        Address address = addressService.getAddressById(id);
        AddressDTO addressResponse = modelMapper.map(address, AddressDTO.class);
        return ResponseEntity.ok().body(addressResponse);
    }

    @PostMapping
    public ResponseEntity<AddressDTO> createAddress(@RequestBody AddressDTO addressDTO, @PathVariable("id") int userId) {

        Address addressRequest = modelMapper.map(addressDTO, Address.class);
        Customer customer = customerService.getByID(userId);
        Address address = addressService.createAddress(addressRequest, customer);

        AddressDTO addressResponse = modelMapper.map(address, AddressDTO.class);
        return new ResponseEntity<>(addressResponse, HttpStatus.CREATED);

    }

    @PutMapping("/{addressId}")
    public ResponseEntity<AddressDTO> updateAddress(@PathVariable("addressId") int addressId, @RequestBody AddressDTO addressDTO) throws AddressNotFoundException {
        Address addressRequest = modelMapper.map(addressDTO, Address.class);
        Address address = addressService.updateAddress(addressId, addressRequest);
        AddressDTO addressResponse = modelMapper.map(address, AddressDTO.class);
        return ResponseEntity.ok().body(addressResponse);
    }

    @DeleteMapping("/{addressId}")
    public ResponseEntity<Response<Boolean>> deleteAddress(@PathVariable("addressId") int id) throws AddressNotFoundException {
        addressService.deleteAddress(id);
        Response<Boolean> response = new Response<>("Address deleted successfully", 200, false,  false, true);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
