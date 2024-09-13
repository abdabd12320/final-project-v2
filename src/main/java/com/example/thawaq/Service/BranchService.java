package com.example.thawaq.Service;

import com.example.thawaq.Api.ApiException;
import com.example.thawaq.Model.Branch;
import com.example.thawaq.Model.Store;
import com.example.thawaq.Model.StoreAdmin;
import com.example.thawaq.Repository.BranchRepository;
import com.example.thawaq.Repository.StoreAdminRepository;
import com.example.thawaq.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final StoreRepository storeRepository;
    private final StoreAdminRepository storeAdminRepository;

    public List<Branch> getBranches()
    {
        return branchRepository.findAll();
    }

    public void addBranch(Integer storeAdminID,Integer storeID, Branch branch) //v2
    {
        Store s = storeRepository.findStoreById(storeID);
        StoreAdmin sa = storeAdminRepository.findStoreAdminById(storeAdminID);
        if(s == null)
        {
            throw new ApiException("Store not found");
        }
        if(sa == null)
        {
            throw new ApiException("Store admin not found");
        }
        if(sa.getStore().getId() != s.getId()) // v2
        {
            throw new ApiException("Not match");
        }
        branch.setStore(s);
        branchRepository.save(branch);
    }
    public void updateBranch(Integer storeAdminID,Integer storeID,Integer branchID,Branch branch) //v2
    {
        Branch b = branchRepository.findBranchById(branchID);
        if(b == null)
        {
            throw new ApiException("Branch not found");
        }
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
            throw new ApiException("Not match between store admin and store");
        }
        if(branchRepository.findBranchById(branchID).getStore().getId() != branchRepository.findBranchById(branchID).getId())
        {
            throw new ApiException("Not match between branch and store");
        }
        b.setName(branch.getName());
        b.setOpen(branch.isOpen());
        branchRepository.save(b);
    }
    public void deleteBranch(Integer bID)
    {
        if(branchRepository.findBranchById(bID) == null)
        {
            throw new ApiException("Branch not found");
        }
        branchRepository.deleteById(bID);
    }
}
