package com.Shop.Ecommerce.ServiceImpl;

import com.Shop.Ecommerce.Entity.Address;
import com.Shop.Ecommerce.Entity.User;
import com.Shop.Ecommerce.EntityDto.AddressDto;
import com.Shop.Ecommerce.Repository.AddressRepo;
import com.Shop.Ecommerce.Repository.UserRepository;
import com.Shop.Ecommerce.Service.AddressService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AddressRepo addressRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public AddressDto saveAddress(AddressDto addressDto, Long userId) {
        Address address = modelMapper.map(addressDto,Address.class);
        Optional<User> byId = userRepository.findById(userId);
        address.setUser(byId.get());
        Address saveAddress = addressRepo.save(address);

        return modelMapper.map(saveAddress,AddressDto.class);
    }

    @Override
    public AddressDto updadteAddress(AddressDto addressDto) {
        Optional<Address> byId = addressRepo.findById(addressDto.getId());
        if(byId.isPresent()){
            Address address = modelMapper.map(addressDto,Address.class);
            Address saved = addressRepo.save(address);
            return modelMapper.map(saved,AddressDto.class);
        }else{
            return null;
        }

    }

    @Override
    public void deleteAddress(Long addressId) {
        Optional<Address> byId = addressRepo.findById(addressId);
        if(byId.isPresent()){
            addressRepo.delete(byId.get());
        }
    }

    @Override
    public List<AddressDto> getAllAddress(Long userId) {
        List<Address> byUserId = addressRepo.findByUserId(userId);
        if(byUserId==null){
            return null;
        }
        List<AddressDto> collect = byUserId.stream().map((item) -> modelMapper.map(item, AddressDto.class)).collect(Collectors.toList());
        return collect;
    }

    @Override
    public AddressDto getById(Long addressId) {

        Optional<Address> byId = addressRepo.findById(addressId);
        if(byId.isPresent()){
            return modelMapper.map(byId.get(),AddressDto.class);
        }
        return null;
    }
}
