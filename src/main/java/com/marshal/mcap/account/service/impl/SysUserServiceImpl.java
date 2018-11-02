package com.marshal.mcap.account.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.marshal.mcap.account.entity.SysUser;
import com.marshal.mcap.account.mapper.SysUserMapper;
import com.marshal.mcap.account.service.SysUserService;
import com.marshal.mcap.system.entity.ResponseData;
import com.marshal.mcap.system.service.impl.BaseServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/10/26
 * Time: 20:10
 * Description:
 */
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    SysUserMapper sysUserMapper;

    @Override
    public List<SysUser> select(SysUser condition, int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        return sysUserMapper.select(condition);
    }

    @Override
    public SysUser selectByPrimaryKey(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Override
    public void save(SysUser SysUser) {
        if (SysUser.getUserId() != null) {
            sysUserMapper.updateByPrimaryKey(SysUser);
        } else {
            sysUserMapper.insert(SysUser);
        }
    }

    @Override
    public void delete(Long[] idList) {
        for (Long id : idList) {
            sysUserMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public List<Map> getUserOptions() {
        return sysUserMapper.getUserOptions();
    }
}
