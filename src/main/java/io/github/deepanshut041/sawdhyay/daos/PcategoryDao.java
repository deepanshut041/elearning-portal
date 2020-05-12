package io.github.deepanshut041.sawdhyay.daos;

import io.github.deepanshut041.sawdhyay.models.Pcategory;

import java.util.List;

public interface PcategoryDao {

    void savePcategory(Pcategory pcategory);
    Pcategory getPcategory(int id);
    List<Pcategory> listPcategorys();
    void updatePcategory(Pcategory pcategory);
    void deletePcategory(int id);

}
