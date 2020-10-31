package com.etc.delightstouring.controller;

import com.etc.delightstouring.domain.Province;
import com.etc.delightstouring.domain.Region;
import com.etc.delightstouring.domain.Scenicspot;
import com.etc.delightstouring.service.ProvinceService;
import com.etc.delightstouring.service.RegionService;
import com.etc.delightstouring.service.ScenicspotService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * @ClassName BackScenicspotController
 * @Description TODO 后台景点控制器
 * @Author Administrator
 * @Date 20/10/30 10:29
 * @Version 1.0
 **/
@Controller
@RequestMapping("/back/scenicspot")
public class BackScenicspotController {
    @Autowired
    private ScenicspotService scenicspotService;
    @Autowired
    private RegionService regionService;
    @Autowired
    private ProvinceService provinceService;

    /**
     * 分页模糊查询：根据条件查询信息
     * @param rId
     * @param ssName
     * @param ssDescribe
     * @param pageNum
     * @param pageSize
     * @return
     */
    @RequestMapping("/findAll")
    public String findAll(@RequestParam Integer rId, @RequestParam Integer pId,
                          @RequestParam(defaultValue = "") String ssName,
                          @RequestParam(defaultValue = "") String ssDescribe,
                          @RequestParam(defaultValue = "1") Integer pageNum,
                          @RequestParam(defaultValue = "5") Integer pageSize,
                          Model model){
        if (rId == null || rId == 0) {
            rId = null;
        }
        if(pId == null || pId == 0){
            pId = null;
        }
        model.addAttribute("findrId",rId);
        model.addAttribute("findpId",pId);
        model.addAttribute("findssName",ssName);
        model.addAttribute("findssDescribe",ssDescribe);
        // 根据条件查询到的记录
        PageInfo<Scenicspot> page = scenicspotService.findScenicspotByCondition(rId, pId, ssName, ssDescribe, pageNum, pageSize);
        page.getList().forEach(System.out::println);
        Scenicspot scenicspot = new Scenicspot();
        // 查询省份信息
        List<Province> provinces = provinceService.findAllProvince();
        // 地区信息
        List<Region> regions = regionService.findAllRegion();
        // 将数据存储到请求作用域中
        model.addAttribute("provinces",provinces);
        model.addAttribute("regions",regions);
        model.addAttribute("page",page);
        return "scenicspot/info";
    }

    /**
     * 根据省份编号查询地区信息
     * @param pId
     * @return
     */
    @RequestMapping("/findRegion")
    @ResponseBody
    public List<Region> findRegion(Integer pId){
        return regionService.findRegionByPid(pId);
    }

    /**
     * 删：根据编号删除景点信息
     * @param ssId
     * @return
     */
    @RequestMapping("/del/{ssId}")
    @ResponseBody
    public boolean delScenicspot(@PathVariable("ssId") String ssId){
        return scenicspotService.delScenicspotById(ssId);
    }

    /**
     * 查询所有省份信息
     * @return
     */
    @RequestMapping("/findProvinces")
    @ResponseBody
    public List<Province> findProvinces(){
        return provinceService.findAllProvince();
    }

    /**
     * 添加一个景点信息
     * @param scenicspot
     * @return
     */
    @RequestMapping("/add")
    @ResponseBody
    public boolean addScenicspot(Scenicspot scenicspot, MultipartFile photo, HttpServletRequest request){
        // 判断文件是否存在或者文件大小是否为0
        if (photo != null && photo.getSize() > 0) {
            String realPath = request.getServletContext().getRealPath("/upload");
            File file = new File(realPath);
            if (!file.exists()) {
                file.mkdir();
            }
            String fileName = photo.getOriginalFilename();
            File deskFile = new File(file, fileName);
            try {
                photo.transferTo(deskFile);
                scenicspot.setSsPhotopath("/upload/"+fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            scenicspot.setSsPhotopath("/upload/1.jpg");
        }
        return scenicspotService.addScenicspot(scenicspot);
    }

    /**
     * 查询：根据编号查询用户信息
     * @param ssId
     * @param request
     * @return
     */
    @RequestMapping("/findById/{ssId}")
    public String findById(@PathVariable("ssId") String ssId, HttpServletRequest request){
        Scenicspot scenicspot = scenicspotService.findScenicspotById(ssId);
        request.setAttribute("scenicspot",scenicspot);
        return "scenicspot/update";
    }

    /**
     * 改：根据编号修改景点信息
     * @param scenicspot
     * @param photo
     * @param request
     * @return
     */
    @RequestMapping("/updateById")
    @ResponseBody
    public boolean updateById(Scenicspot scenicspot, MultipartFile photo, HttpServletRequest request){
        if (photo != null && photo.getSize() > 0) {
            String realPath = request.getServletContext().getRealPath("/upload");
            File file = new File(realPath);
            if (!file.exists()) {
                file.mkdir();
            }
            String fileName = photo.getOriginalFilename();
            File deskFile = new File(file, fileName);
            try {
                photo.transferTo(deskFile);
                scenicspot.setSsPhotopath("/upload/"+fileName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return scenicspotService.updateScenicspotById(scenicspot);
    }
}
