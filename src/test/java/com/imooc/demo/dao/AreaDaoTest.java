package com.imooc.demo.dao;

import com.imooc.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)//以Spring的ut去跑
@SpringBootTest
public class AreaDaoTest {
    @Autowired//希望Spring动态的将需要用到的areaDao的mybatis实现类注入进来
    private AreaDao areaDao;

    @Test
    @Ignore
    public void queryArea() {
        List<Area> areaList=areaDao.queryArea();
        assertEquals(2,areaList.size());//预期值与返回值一致时测试通过
    }

    @Test
    @Ignore
    public void queryAreaById() {
        Area area=areaDao.queryAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void insertArea() {
        Area area=new Area();
        area.setAreaName("南苑");
        area.setPriority(1);
        int effectedNum=areaDao.insertArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    @Ignore
    public void updataArea() {
        Area area=new Area();
        area.setAreaName("西苑");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        int effectedNum=areaDao.updateArea(area);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteArea() {
        int effectedNum=areaDao.deleteArea(3);
        assertEquals(1,effectedNum);
    }
}