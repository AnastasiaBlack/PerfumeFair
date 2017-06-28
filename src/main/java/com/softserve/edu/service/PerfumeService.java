package com.softserve.edu.service;

import com.softserve.edu.entity.Perfume;

import java.util.List;

public interface PerfumeService {

    void addPerfume(Perfume perfume);


    void updatePerfume(Perfume perfume);


    Perfume getPerfumeById(int id);

    void deletePerfume(Perfume perfume);


    List<Perfume> getAllPerfumes();

}
