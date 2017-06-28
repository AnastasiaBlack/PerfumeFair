package com.softserve.edu.service.impl;

import com.softserve.edu.dao.PerfumeDAO;
import com.softserve.edu.entity.Perfume;
import com.softserve.edu.service.PerfumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class PerfumeServiceImpl implements PerfumeService {
    private PerfumeDAO perfumeDAO;
    @Autowired
    public void setPerfumeDAO(PerfumeDAO perfumeDAO){
        this.perfumeDAO=perfumeDAO;
    }


    @Transactional
    @Override
    public void addPerfume(Perfume perfume) {
        perfumeDAO.addElement(perfume);
//        DAOFactory.getInstance().getPerfumeDAOImpl().addElement(perfume);
    }

    @Transactional
    @Override
    public void updatePerfume(Perfume perfume) {
        perfumeDAO.updateElement(perfume);
//        DAOFactory.getInstance().getPerfumeDAOImpl().updateElement(perfume);
    }

    @Transactional
    @Override
    public Perfume getPerfumeById(int id) {
      return perfumeDAO.getElementById(id);
//        Perfume perfume = DAOFactory.getInstance().getPerfumeDAOImpl().getElementById(id);
//        return perfume;
    }
    @Transactional
    @Override
    public void deletePerfume(Perfume perfume) {
        perfumeDAO.deleteElement(perfume);
//        DAOFactory.getInstance().getPerfumeDAOImpl().deleteElement(perfume);
    }


    @Transactional
    @Override
    public List<Perfume> getAllPerfumes() {
        return perfumeDAO.getAllElements();
//        return DAOFactory.getInstance().getPerfumeDAOImpl().getAllElements();
    }
}
