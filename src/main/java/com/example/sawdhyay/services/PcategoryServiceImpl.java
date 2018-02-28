package com.example.sawdhyay.services;

import com.example.sawdhyay.daos.PcategoryDao;
import com.example.sawdhyay.models.Pcategory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("pcategoryService")
public class PcategoryServiceImpl implements PcategoryService{

    @Autowired
    private PcategoryDao pcategoryDao;

    @Override
    @Transactional
    public void addPcategory(Pcategory pcategory) {
        this.pcategoryDao.savePcategory(pcategory);
    }

    @Override
    @Transactional
    public void updatePcategory(Pcategory pcategory) {
        this.pcategoryDao.updatePcategory(pcategory);
    }

    @Override
    @Transactional
    public void deletePcategoryById(int id) {
        this.pcategoryDao.deletePcategory(id);
    }

    @Override
    @Transactional
    public List<Pcategory> findAllPcategorys() {
        return this.pcategoryDao.listPcategorys();
    }

    @Override
    @Transactional
    public Pcategory getPcategoryById(int id) {
        return this.pcategoryDao.getPcategory(id);
    }
}
