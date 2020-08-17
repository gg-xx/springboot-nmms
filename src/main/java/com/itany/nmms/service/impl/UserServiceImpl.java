package com.itany.nmms.service.impl;

import com.itany.nmms.dao.UserMapper;
import com.itany.nmms.entity.User;
import com.itany.nmms.entity.UserExample;
import com.itany.nmms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int alterUser(User user) {
        UserExample example = new UserExample();
        example.createCriteria().andUserIdEqualTo(user.getUserId());
        return userMapper.updateByExampleSelective(user,example);
    }

    @Override
    public List<User> findAllBySelect(User user) {
        UserExample example = new UserExample();
        example.or().andUserNameEqualTo(user.getUserName())
                .andLoginNameEqualTo(user.getLoginName())
                .andPhoneEqualTo(user.getPhone())
                .andAddressEqualTo(user.getAddress())
                .andIsValidEqualTo(user.getIsValid());
        return userMapper.selectByExample(example);
    }

    @Override
    public int alterStatus(User user) {
        return 0;
    }
}
