package com.example.sawdhyay.services;

import com.example.sawdhyay.models.Pcategory;

import java.util.List;

public interface PcategoryService {

    void addPcategory(Pcategory pcategory);

    void updatePcategory(Pcategory pcategory);

    void deletePcategoryById(int id);

    List<Pcategory> findAllPcategorys();

    Pcategory getPcategoryById(int id);
    
}
