package com.example.EcommerceWithSpringDataJpa.typeEditor;

import com.example.EcommerceWithSpringDataJpa.entity.Address;
//import com.example.EcommerceWithSpringDataJpa.service.address.AddressService;
import org.springframework.beans.factory.annotation.Autowired;

import java.beans.PropertyEditorSupport;

public class AddressEditor extends PropertyEditorSupport {

   /* private AddressService addressService;

    @Autowired
    public AddressEditor(AddressService addressService) {
        this.addressService = addressService;
    }

    public AddressEditor() {
    }

    @Override
    public String getAsText(){
        return super.getAsText();
    }

    @Override
    public void setAsText(String text) throws IllegalArgumentException {
        Address address = addressService.getAddressById(Integer.parseInt(text)).getObjectToBeReturned();
        this.setValue(address);
    }*/
}
