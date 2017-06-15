package com.softserve.edu.dao;

import com.softserve.edu.entity.Perfume;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public class PerfumeDAO extends ElementDAOImpl<Perfume> {
    public PerfumeDAO() {
        super(Perfume.class);
    }

}
