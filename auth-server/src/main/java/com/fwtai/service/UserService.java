package com.fwtai.service;

import com.fwtai.entity.User;
import com.fwtai.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @作者 田应平
 * @版本 v1.0
 * @创建时间 2020-05-31 20:32
 * @QQ号码 444141300
 * @Email service@dwlai.com
 * @官网 http://www.fwtai.com
 */
@Service
public class UserService implements UserDetailsService{

    @Autowired
    private UserDao userDao;

    @Override
    public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException{
        final User user = userDao.findUserByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("用户不存在");
        }
        return user;
    }
}