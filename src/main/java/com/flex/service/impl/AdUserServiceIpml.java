package com.flex.service.impl;

import com.flex.dao.AdUserDao;
import com.flex.service.AdUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdUserServiceIpml implements AdUserService {
    @Autowired
    private AdUserDao adUserDao;
}
