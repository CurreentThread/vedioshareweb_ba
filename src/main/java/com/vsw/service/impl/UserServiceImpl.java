package com.vsw.service.impl;

import com.vsw.domain.Testvedio;
import com.vsw.domain.Vediouser;
import com.vsw.mapper.VediouserMapper;
import com.vsw.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private VediouserMapper vediouserMapper;


    @Override
    public Vediouser login(Vediouser vediouser) {
        Vediouser record = new Vediouser();
        record.setMobile(vediouser.getMobile());
        record.setPassword(vediouser.getPassword());
//        System.out.println(record);
        Vediouser findUser = (Vediouser) vediouserMapper.selectOne(record);
        return findUser;
    }

    @Override
    public Vediouser register(Vediouser vediouser) {
        int isInsert = vediouserMapper.insert(vediouser);
        if (isInsert > 0)
            return vediouser;
        else
            return null;
    }

    @Override
    public boolean updateUser(Vediouser vediouser) {

        int isUpdate = vediouserMapper.updateByPrimaryKey(vediouser);
        if (isUpdate > 0)
            return true;
        else
            return false;
    }

    @Override
    public boolean logout(int userid) {
        Vediouser find = vediouserMapper.selectByPrimaryKey(userid);
        if (find != null)
            return true;
        else
            return false;
    }

    @Override
    public Vediouser automicLogin(String mobile) {

        Vediouser record = new Vediouser();

        record.setMobile(mobile);



        return vediouserMapper.selectOne(record);
    }
}
