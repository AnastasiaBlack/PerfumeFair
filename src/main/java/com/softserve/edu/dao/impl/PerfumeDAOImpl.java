package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.PerfumeDAO;
import com.softserve.edu.entity.Perfume;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PerfumeDAOImpl extends ElementDAOImpl<Perfume> implements
        PerfumeDAO {
    private SessionFactory sessionFactory;

    @Autowired
    public PerfumeDAOImpl(SessionFactory sessionFactory) {
        super(Perfume.class);
        this.sessionFactory=sessionFactory;
    }

}
