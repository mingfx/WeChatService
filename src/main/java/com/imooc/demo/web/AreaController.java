package com.imooc.demo.web;

import com.imooc.demo.entity.Area;
import com.imooc.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    //返回map对象，如果遇到多值返回，String代表一个值的Key
    private Map<String,Object> listArea() {
        Map<String,Object> modelMap = new HashMap<String,Object>();
        List<Area> list = new ArrayList<Area>();
        list = areaService.getAreaList();
        modelMap.put("areaList",list);
        return modelMap;
    }

    @RequestMapping(value = "/getareabyid",method = RequestMethod.GET)
    private Map<String,Object> getAreaById(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        Area area = areaService.getAreaById(areaId);
        modelMap.put("area",area);
        return modelMap;
    }

    //用整个表单提交，要用post
    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    //@RequestBody 标识接收的内容是处理x3wformurlencode编码之外的内容，如Jason，xml等
    private Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.addArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/modifyarea",method = RequestMethod.POST)
    private Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.modifyArea(area));
        return modelMap;
    }

    @RequestMapping(value = "/removearea",method = RequestMethod.GET)
    private Map<String,Object> removeArea(Integer areaId){
        Map<String,Object> modelMap = new HashMap<String,Object>();
        modelMap.put("success",areaService.deleteArea(areaId));
        return modelMap;
    }

}
