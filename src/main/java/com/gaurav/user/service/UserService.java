package com.gaurav.user.service;

import com.gaurav.user.entity.User;
import com.gaurav.user.repository.UserRepository;
import com.gaurav.user.vo.Department;
import com.gaurav.user.vo.ResponseTemplateVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("UserService::save");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartment(Long userId) {
        log.info("UserService::getUserWithDepartment");
        ResponseTemplateVO templateVO = new ResponseTemplateVO();
        User user =userRepository.findByUserId(userId);
        Department department =  restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/"+user.getDepartmentId(),Department.class);
        templateVO.setUser(user);
        templateVO.setDepartment(department);
        return templateVO;
    }
}
