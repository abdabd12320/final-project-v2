package com.example.thawaq.Service;

import com.example.thawaq.Api.ApiException;
import com.example.thawaq.DTO.AddressDTO;
import com.example.thawaq.Model.Address;
import com.example.thawaq.Model.Branch;
import com.example.thawaq.Repository.AddressRepository;
import com.example.thawaq.Repository.BranchRepository;
import com.example.thawaq.Repository.StoreAdminRepository;
import com.example.thawaq.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final BranchRepository branchRepository;
    private final StoreRepository storeRepository;
    private final StoreAdminRepository storeAdminRepository;

    public List<Address> getAddresses()
    {
        return addressRepository.findAll();
    }

    public void addAddress(Integer storeAdminID,Integer storeID,AddressDTO addressDTO) //v2
    {
        if(storeRepository.findStoreById(storeID) == null)
        {
            throw new ApiException("Store not found");
        }
        if(storeAdminRepository.findStoreAdminById(storeAdminID) == null)
        {
            throw new ApiException("Store admin not found");
        }
        if(storeAdminRepository.findStoreAdminById(storeAdminID).getStore().getId() != storeRepository.findStoreById(storeID).getId())
        {
            throw new ApiException("Not match");
        }

        Branch b = branchRepository.findBranchById(addressDTO.getBranch_id());
        if(b == null)
        {
            throw new ApiException("Branch not found");
        }
        Address a = new Address(null,addressDTO.getCity(), addressDTO.getStreet(), b);

        addressRepository.save(a);
    }

    public void updateAddress(Integer storeAdminID,Integer storeID,AddressDTO addressDTO) //v2
    {
        if(storeRepository.findStoreById(storeID) == null)
        {
            throw new ApiException("Store not found");
        }
        if(storeAdminRepository.findStoreAdminById(storeAdminID) == null)
        {
            throw new ApiException("Store admin not found");
        }
        if(storeAdminRepository.findStoreAdminById(storeAdminID).getStore().getId() != storeAdminRepository.findStoreAdminById(storeAdminID).getId())
        {
            throw new ApiException("Not match");
        }

        Address a = addressRepository.findAddressById(addressDTO.getBranch_id());
        if(a == null)
        {
            throw new ApiException("Address not found");
        }
        a.setCity(addressDTO.getCity());
        a.setStreet(addressDTO.getStreet());
        addressRepository.save(a);
    }
    public void deleteAddress(Integer id)
    {
        if(addressRepository.findAddressById(id) == null)
        {
            throw new ApiException("Address not found");
        }
        addressRepository.deleteById(id);
    }
}
