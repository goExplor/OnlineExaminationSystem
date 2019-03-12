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
        //�������·��
        String realPath = request.getSession().getServletContext().getRealPath("/testcase");
        //��ȡ�ļ��ĸ�ʽ
        String extention = file.getOriginalFilename().substring(file.getOriginalFilename().lastIndexOf(".")+1);
        //�Ը�ʽ����ɸѡ
        if(extention.equalsIgnoreCase("xls") || extention.equalsIgnoreCase("xlsx") || extention.equalsIgnoreCase("txt") || extention.equalsIgnoreCase("csv")) {
        	//��·���´����ļ���    
        	File f = new File(realPath);
            String fileName = file.getOriginalFilename();
            String uploadPath = realPath + File.separator + fileName;
            if(!f.exists()) {
                f.mkdir();
            }
            //�ļ��Ĵ���
            file.transferTo(new File(uploadPath));
           
            
            
            Workbook book = Workbook.getWorkbook(new File(uploadPath));
			// ���ִ��Ȩ�����ù��������
			Sheet[] sheets = book.getSheets();
			Sheet sheet = null;
			for (Sheet s : sheets) {
				if ("xuanzeti".equals(s.getName())) {
					sheet = s;
				}
			}
			// ��ȡsheet����������
			int rows = sheet.getRows();
			
			for (int r = 2; r < rows; r++) {
//				LinkedHashMap<UpLoadQuestionEnum, String> linkedHashMap = new LinkedHashMap<UpLoadQuestionEnum, String>();
				Class sceClass = JudgementQuestion.class;
				Field[] fields = sceClass.getDeclaredFields();
				String[] sssss = new String[fields.length];
				//��ȡExcel�е����
	             String order = sheet.getCell(0, r).getContents();
	             //��ֹ����д��ڿո��±���
	             if (order==null||order.equals("")) {
	            	 break;
	             }
				// ȡ����һ�����ݵ���������
				for(int i = 0; i < sssss.length; i++ ){
					System.out.println(sssss[i]);
					sssss[i] = sheet.getCell(i+1, r).getContents();
					System.out.println(sssss[i]);
//					linkedHashMap.put(UpLoadQuestionEnum.values()[i],sssss[i]);
				}
//				dataForUpLoadQuestionFromExcel.add(linkedHashMap);
			}
            request.setAttribute("info","�ļ��ϴ��ɹ�!");
        } else {
            request.setAttribute("info","�ļ����Ͳ���ȷ�����ϴ���ʽΪxls,xlsx,txt,csv�ļ�!");
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
    	//�������·��
        String realPath = request.getSession().getServletContext().getRealPath("/testcase");
//        //��ȡ�ļ��ĸ�ʽ
        String extention = data.getOriginalFilename().substring(data.getOriginalFilename().lastIndexOf(".")+1);
//        if(extention.equalsIgnoreCase("jsp") || extention.equalsIgnoreCase("txt") || extention.equalsIgnoreCase("csv")){
//        	//��·���´����ļ���    
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
