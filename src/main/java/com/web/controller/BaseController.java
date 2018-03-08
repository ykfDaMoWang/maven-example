package com.web.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

public class BaseController {

	//将数据刷新写回web端  
	protected void flushResponse(HttpServletResponse response, String responseContent){
		 PrintWriter writer = null;  
		 try {  
	            response.setCharacterEncoding("utf-8");  
	            // 针对ajax中页面编码为GBK的情况，一定要加上以下两句  
	            response.setHeader("Cache-Control", "no-cache");  
	            response.setContentType("text/html;charset=UTF-8");  
	            writer = response.getWriter();  
	            if (responseContent==null || "".equals(responseContent) || "null".equals(responseContent)) {  
	                writer.write("");  
	            } else {  
	                writer.write(responseContent);  
	            }  
	        } catch (IOException e) {  
	            throw new RuntimeException(e);  
	        } finally {  
	            if (writer != null) {  
	                writer.flush();  
	                writer.close();  
	            }  
	        }  
	}
	
}
