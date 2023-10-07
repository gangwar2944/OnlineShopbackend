package com.Shop.Ecommerce.Service;

import com.Shop.Ecommerce.Entity.User;
import com.Shop.Ecommerce.EntityDto.AddressDto;

import java.util.List;

public interface AddressService {

    public AddressDto saveAddress(AddressDto addressDto,Long userId);

    public AddressDto updadteAddress(AddressDto addressDto);

    public void deleteAddress(Long addressId);

    public List<AddressDto> getAllAddress(Long userId);

    public AddressDto getById(Long addressId);
}
