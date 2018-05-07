package cn.rootadmin.service;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import cn.rootadmin.mapper.UserMapper;
import cn.rootadmin.pojo.User;

@Service
public class UserService extends BaseService<User>{
	
	

	    @Autowired
	    private UserMapper userMapper;

    
    /**
     * 实际登录操作
     * @param loginName
     * @param password
     * @return
     * @throws JsonProcessingException
     */
    public User doLogin(String loginName, String password) throws JsonProcessingException {
        User record = new User();
        record.setUserQq(loginName);
        User user = this.userMapper.selectOne(record);
        if (null == user) {
            return null;
        }

        if (!StringUtils.equalsIgnoreCase(password, user.getPassword())) {
            return null;
        }
        return user;
    }


}
