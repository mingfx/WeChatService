package com.imooc.demo.service.impl;

import com.imooc.demo.dao.AreaDao;
import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service//告诉容器这也是其中一个bean
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;
    @Override
    public List<Area> getAreaList() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        int a=1/0;
        return areaDao.queryAreaById(areaId);
    }

    @Transactional//可以加标签（rollbackFor=Exception.class)，抛出异常时改用Exception
    @Override
    public boolean addArea(Area area) {
        //把一切业务逻辑尽可能放到service层里面
        if(area.getAreaName()!=null&&!"".equals(area.getAreaName()))
        {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try{
                int effectedNum = areaDao.insertArea(area);
                if(effectedNum>0) {
                    return true;
                }else {
                    throw new RuntimeException("插入区域信息失败");//Tansactional不是接受所有异常回滚，默认接受RuntimeException然后回滚
                }
            } catch (Exception e){
                throw new RuntimeException("插入区域信息失败:"+e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空");
        }
    }

    @Transactional
    @Override
    public boolean modifyArea(Area area) {
        if(area.getAreaId() != null && area.getAreaId() > 0){
            area.setLastEditTime(new Date());
            try{
                int effectedNum = areaDao.updateArea(area);
                if(effectedNum > 0){
                    return true;
                }else {
                    throw new RuntimeException("更新区域信息失败");
                }
            } catch (Exception e){
                throw new RuntimeException("更新区域信息失败："+e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Transactional
    @Override
    public boolean deleteArea(int areaId) {
        if(areaId > 0){
            try{
                int effectedNum = areaDao.deleteArea(areaId);
                if(effectedNum > 0){
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息失败");
                }
            } catch (Exception e){
                throw new RuntimeException("删除区域信息失败："+e.getMessage());
            }
        } else {
            throw new RuntimeException("区域Id不能为空" );
        }
    }
}
