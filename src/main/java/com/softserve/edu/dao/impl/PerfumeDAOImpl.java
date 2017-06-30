package com.softserve.edu.dao.impl;

import com.softserve.edu.dao.PerfumeDAO;
import com.softserve.edu.entity.Perfume;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class PerfumeDAOImpl extends ElementDAOImpl<Perfume> implements
        PerfumeDAO {
    private SessionFactory sessionFactory;
    public PerfumeDAOImpl(SessionFactory sessionFactory) {
        super(Perfume.class, sessionFactory);
        this.sessionFactory=sessionFactory;
    }

}
