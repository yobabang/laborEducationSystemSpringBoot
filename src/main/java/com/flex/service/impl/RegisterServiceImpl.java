package com.flex.service.impl;

import com.flex.dao.RegisterDao;
import com.flex.domain.Register;
import com.flex.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterServiceImpl implements RegisterService {
    @Autowired
    private RegisterDao registerDao;

    public boolean save(Register register) {
        return registerDao.save(register) > 0;
    }

    public boolean update(Register register) {
        return registerDao.updata(register) > 0;
    }

    public boolean delete(Integer id) {
        return registerDao.delete(id) > 0;
    }

    public Register getById(Integer id) {
        return registerDao.getById(id);
    }

    public List<Register> getAll() {
        return registerDao.getAll();
    }
}
