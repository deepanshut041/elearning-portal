package io.github.deepanshut041.sawdhyay.services;

import io.github.deepanshut041.sawdhyay.models.Pcategory;

import java.util.List;

public interface PcategoryService {

    void addPcategory(Pcategory pcategory);

    void updatePcategory(Pcategory pcategory);

    void deletePcategoryById(int id);

    List<Pcategory> findAllPcategorys();

    Pcategory getPcategoryById(int id);
    
}
