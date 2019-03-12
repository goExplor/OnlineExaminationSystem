package com.onlineexam.controller;

import java.io.File;
import java.lang.reflect.Field;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.onlineexam.pojo.JudgementQuestion;

import jxl.Sheet;
import jxl.Workbook;
@Controller
public class UploadController {
	
//	@Autowired
//	UploadService service;
	
	
//	@RequestMapping("/upLoadFile")
    public String upload(@RequestParam(value = "file", required = false) MultipartFile file, ModelMap model, HttpServletRequest request) throws Exception {
        //设置相对路径
        String realPath = request.getSession().getServletContext().getRealPath("/testcase");
        //获取文件的格式
        String extention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        //对格式进行筛选
        if(extention.equalsIgnoreCase("xls") || extention.equalsIgnoreCase("xlsx") || extention.equalsIgnoreCase("txt") || extention.equalsIgnoreCase("csv")) {
        	//在路径下创建文件夹    
        	File f = new File(realPath);
            String fileName = file.getOriginalFilename();
            String uploadPath = realPath + File.separator + fileName;
            if(!f.exists()) {
                f.mkdir();
            }
            //文件的传输
            file.transferTo(new File(uploadPath));
           
            
            
            Workbook book = Workbook.getWorkbook(new File(uploadPath));
			// 获得执行权限设置工作表对象
			Sheet[] sheets = book.getSheets();
			Sheet sheet = null;
			for (Sheet s : sheets) {
				if ("xuanzeti".equals(s.getName())) {
					sheet = s;
				}
			}
			// 获取sheet的所有行数
			int rows = sheet.getRows();
			
			for (int r = 2; r < rows; r++) {
//				LinkedHashMap<UpLoadQuestionEnum, String> linkedHashMap = new LinkedHashMap<UpLoadQuestionEnum, String>();
				Class sceClass = JudgementQuestion.class;
				Field[] fields = sceClass.getDeclaredFields();
				String[] sssss = new String[fields.length];
				//获取Excel中的序号
	             String order = sheet.getCell(0, r).getContents();
	             //防止表格中存在空格导致报错
	             if (order==null||order.equals("")) {
	            	 break;
	             }
				// 取出第一行数据的所有数据
				for(int i = 0; i < sssss.length; i++ ){
					System.out.println(sssss[i]);
					sssss[i] = sheet.getCell(i+1, r).getContents();
					System.out.println(sssss[i]);
//					linkedHashMap.put(UpLoadQuestionEnum.values()[i],sssss[i]);
				}
//				dataForUpLoadQuestionFromExcel.add(linkedHashMap);
			}
            request.setAttribute("info","文件上传成功!");
        } else {
            request.setAttribute("info","文件类型不正确，请上传格式为xls,xlsx,txt,csv文件!");
        }
        return "page/file/fileInteraction";
    }
    @RequestMapping("")
	public String login1(){
		return "1";
	}
    @RequestMapping("/upup")
    @ResponseBody
    public String upload1(@RequestParam(value = "file", required = false)MultipartFile data, ModelMap model, HttpServletRequest request) {
    	//设置相对路径
        String realPath = request.getSession().getServletContext().getRealPath("/testcase");
//        //获取文件的格式
        String extention = data.getOriginalFilename().substring(data.getOriginalFilename().lastIndexOf(".")+1);
//        if(extention.equalsIgnoreCase("jsp") || extention.equalsIgnoreCase("txt") || extention.equalsIgnoreCase("csv")){
//        	//在路径下创建文件夹    
//        	File f = new File(realPath);
//            String fileName = file.getOriginalFilename();
//            String uploadPath = realPath + File.separator + fileName;
//            if(!f.exists()) {
//                f.mkdir();
//            }
//            System.out.println("nihao");
//        }
    	return "m";
    }
 }
