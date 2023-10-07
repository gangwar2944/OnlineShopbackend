package com.Shop.Ecommerce.Controller;

import com.Shop.Ecommerce.EntityDto.AddressDto;
import com.Shop.Ecommerce.Response.HttpStatus;
import com.Shop.Ecommerce.Response.MessageResponse;
import com.Shop.Ecommerce.Service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/address/")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("getAllAddress")
    MessageResponse getAllAddressByUserId(@RequestParam Long userid){
        List<AddressDto> allAddress = addressService.getAllAddress(userid);
        if(allAddress!=null){
            return new MessageResponse("All address of the user", HttpStatus.SUCCESS,allAddress);
        }else{
            return new MessageResponse("Address not found",HttpStatus.SUCCESS);
        }
    }

    @GetMapping("getAddressById/{addressId}")
    MessageResponse getAllAddressByAddressId(@PathVariable Long addressId){
        AddressDto addressById = addressService.getById(addressId);
        if(addressById!=null){
            return new MessageResponse("Address By address address id", HttpStatus.SUCCESS,addressById);
        }else{
            return new MessageResponse("Address not found by this id",HttpStatus.SUCCESS);
        }
    }

    @PostMapping("saveAndUpdateAddress")
    MessageResponse saveNewAddres(@RequestBody AddressDto addressDto,@RequestParam Long userId){

        if(addressDto.getId()==null){
            AddressDto savedAddress = addressService.saveAddress(addressDto, userId);

            return new MessageResponse("Address saved successfully ", HttpStatus.SUCCESS,savedAddress);
        }else{
            AddressDto updatedAddress = addressService.updadteAddress(addressDto);
            return new MessageResponse("Address updated successfully ",HttpStatus.SUCCESS,updatedAddress);
        }
    }

    @DeleteMapping("deleteAddress/{addressId}")
    MessageResponse deleteAddress(@PathVariable Long addressId){

        if(addressId!=null){
            addressService.deleteAddress(addressId);
            return new MessageResponse("Address deleted successfully ", HttpStatus.SUCCESS);
        }else{
            return new MessageResponse("Provide address id for delete address",HttpStatus.SUCCESS);
        }
    }
}
