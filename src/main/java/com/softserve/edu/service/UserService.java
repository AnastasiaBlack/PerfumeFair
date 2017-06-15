package com.softserve.edu.service;

import com.softserve.edu.dao.DAOFactory;
import com.softserve.edu.entity.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
@Service
public class UserService {
    @Transactional
    public void addUser(User user) {
        DAOFactory.getInstance().getUserDAO().addElement(user);
    }

    @Transactional
    public void updateUser(User user) {
        DAOFactory.getInstance().getUserDAO().updateElement(user);
    }

    @Transactional
    public User getUserById(int id) {
        User user = DAOFactory.getInstance().getUserDAO().getElementById(id);
        return user;
    }
    @Transactional
    public void deleteUser(User user) {
        DAOFactory.getInstance().getUserDAO().deleteElement(user);
    }

    @Transactional
    public List<User> getAllUsers() {
        return DAOFactory.getInstance().getUserDAO().getAllElements();
    }
}
