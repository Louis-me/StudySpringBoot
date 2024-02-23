package xyz.shi.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.conditions.query.LambdaQueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.shi.mapper.UserMapper;
import xyz.shi.pojo.User;

import java.util.List;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public List<User> findAll() {

        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();

        List<User> users = userMapper.selectList(queryWrapper);
        return users;
    }

    //分页
    public List<User> findPage(Integer CurrentPage, Integer PageSize) {
        System.out.println(CurrentPage);
        System.out.println(PageSize);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        Page page = new Page(CurrentPage, PageSize);
        Page<User> userPage = userMapper.selectPage(page, queryWrapper);
        log.info("total:{}", userPage.getTotal());
        log.info("pages:{}", userPage.getPages());
        return userPage.getRecords();
    }
}