package com.flex.service.impl;

import com.flex.dao.AdUserDao;
import com.flex.service.AdUSerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdUserServiceIpml implements AdUSerService {
    @Autowired
    private AdUserDao adUserDao;
}
