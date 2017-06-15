package com.softserve.edu.service;

import com.softserve.edu.dao.DAOFactory;
import com.softserve.edu.entity.Offer;
import com.softserve.edu.entity.Perfume;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class PerfumeService {
    @Transactional
    public void addPerfume(Perfume perfume) {
        DAOFactory.getInstance().getPerfumeDAO().addElement(perfume);
    }

    @Transactional
    public void updatePerfume(Perfume perfume) {
        DAOFactory.getInstance().getPerfumeDAO().updateElement(perfume);
    }

    @Transactional
    public Perfume getPerfumeById(int id) {
        Perfume perfume = DAOFactory.getInstance().getPerfumeDAO().getElementById(id);
        return perfume;
    }
    @Transactional
    public void deletePerfume(Perfume perfume) {
        DAOFactory.getInstance().getPerfumeDAO().deleteElement(perfume);
    }


    @Transactional
    public List<Perfume> getAllPerfumes() {
        return DAOFactory.getInstance().getPerfumeDAO().getAllElements();
    }
}
