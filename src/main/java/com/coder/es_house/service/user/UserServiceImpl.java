package com.coder.es_house.service.user;

import com.coder.es_house.entity.Role;
import com.coder.es_house.entity.User;
import com.coder.es_house.repository.RoleRepository;
import com.coder.es_house.repository.UserRepository;
import com.coder.es_house.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:apple
 * @date: 2019/2/11
 * @time: 上午10:28
 */
@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;


    @Override
    public User findUserByName(String name) {
        User user = userRepository.findByName(name);
        if (user == null){
            return  null;
        }
        List<Role> roleList = roleRepository.findRolesByUserId(user.getId());

        if(roleList == null || roleList.isEmpty()){
            throw new DisabledException("权限非法");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        roleList.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getName())));
        user.setGrantedAuthorityList(authorities);

        return user;
    }
}
