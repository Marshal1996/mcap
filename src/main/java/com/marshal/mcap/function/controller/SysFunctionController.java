package com.marshal.mcap.function.controller;

import com.marshal.mcap.function.entity.SysFunction;
import com.marshal.mcap.function.service.SysFunctionService;
import com.marshal.mcap.function.service.SysResourceService;
import com.marshal.mcap.system.controller.BaseController;
import com.marshal.mcap.system.entity.ResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * author: Marshal
 * Date: 2018/11/5
 * Time: 22:06
 * Description:
 */
@RestController
@RequestMapping("/sys/function")
public class SysFunctionController extends BaseController {

    @Autowired
    SysFunctionService sysFunctionService;

    /**
     * 获取菜单
     * @return
     */
    @RequestMapping("/getMenus")
    public List<SysFunction> getMenuList(){
        List<SysFunction> topFunctionList = sysFunctionService.selectTopFunctions();
        getChildFunctions(topFunctionList);
        return topFunctionList;
    }
    /**
     * 递归填充最外层菜单的子菜单
     * @param functionList
     * @return
     */
    public List<SysFunction> getChildFunctions(List<SysFunction> functionList){
        for(SysFunction item :functionList){
            List<SysFunction> childList = sysFunctionService.selectChildFunctions(item.getFunctionId());
            if(childList!=null&&childList.size()>0){
                item.setChildFunctions(childList);
                getChildFunctions(childList);
            }else{
                continue;
            }
        }
        return functionList;
    }


    /**
     * 基础crud
     */
    @RequestMapping("/query")
    public ResponseData query(@RequestBody SysFunction condition, int pageNum, int pageSize) {
        List<SysFunction> list = sysFunctionService.selectFunctions(condition, pageNum, pageSize);
        return new ResponseData(list);
    }

    @RequestMapping("/save")
    public ResponseData save(@RequestBody SysFunction sysFunction) {
        if (!getValidator().isValid(sysFunction)) {
            return new ResponseData(false, getValidator().getErrors(sysFunction));
        }
        sysFunctionService.save(sysFunction);
        return new ResponseData(true, "保存成功");
    }

    @RequestMapping("/delete")
    public ResponseData delete(@RequestParam("selectedIds") Long[] selectedIds) {
        sysFunctionService.delete(selectedIds);
        return new ResponseData(true, "删除成功");
    }

    @RequestMapping("/queryById")
    public SysFunction queryById(@RequestParam Long id) {
        return sysFunctionService.selectByPrimaryKey(id);
    }

    @RequestMapping("/getFunctionOptions")
    public List<Map> getFunctionOptions() {
        return sysFunctionService.getFunctionOptions();
    }
}
