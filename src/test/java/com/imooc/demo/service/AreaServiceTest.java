package com.imooc.demo.service;

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

@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaServiceTest {

    @Autowired
    private AreaService areaService;
    @Test
    @Ignore
    public void getAreaList() {
        List<Area> areaList=areaService.getAreaList();
        assertEquals(2, areaList.size());
    }

    @Test
    @Ignore
    public void getAreaById() {
        Area area = areaService.getAreaById(1);
        assertEquals("东苑",area.getAreaName());
    }

    @Test
    @Ignore
    public void addArea() {
        Area area=new Area();
        area.setAreaName("西苑");
        area.setPriority(1);
        boolean effectedNum = areaService.addArea(area);
        assertEquals(true,effectedNum);
    }

    @Test
    @Ignore
    public void modifyArea() {
        Area area = new Area();
        area.setAreaName("南苑");
        area.setAreaId(3);
        area.setLastEditTime(new Date());
        boolean effectedNum = areaService.modifyArea(area);
        assertEquals(true,effectedNum);
    }

    @Test
    public void deleteArea() {
        boolean effectedNum = areaService.deleteArea(3);
        assertEquals(true,effectedNum);
    }
}