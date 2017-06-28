package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.PerfumeDAO;
import com.softserve.edu.entity.Perfume;
import org.springframework.stereotype.Repository;

@Repository
public class PerfumeDAOImpl extends ElementDAOImpl<Perfume> implements
        PerfumeDAO {
    public PerfumeDAOImpl() {
        super(Perfume.class);
    }

}
