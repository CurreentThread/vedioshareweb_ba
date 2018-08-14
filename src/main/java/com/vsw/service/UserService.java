package com.vsw.service;

import com.vsw.domain.Vediouser;

public interface UserService {



    public Vediouser login(Vediouser vediouser);

    public Vediouser register(Vediouser vediouser);

    public boolean updateUser(Vediouser vediouser);

    public boolean logout(int userid);


    public Vediouser automicLogin(String mobile);

}
