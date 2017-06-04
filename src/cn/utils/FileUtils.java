package cn.utils;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * @copyright ：神农大学生软件创新中心 版权所有 (c) 2016
 * @author Mr.Zhang
 * @version 1.0
 * @date 2016年4月27日 下午12:10:30
 * @Description TODO
 *  文件操作类
 */
public class FileUtils {


	
	/**
	 * 将文本内容保存到doc目录下
	 * @param content
	 * @param filename
	 */
	public static void writeToLocalFile(String content,String filename){
		FileWriter fw =null;
		try {
			fw = new FileWriter(new File("doc/"+filename));
			fw.write(content);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null) {
					fw.close();
					fw = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	/**
	 * 从doc目录下读取文本内容
	 * @param filename
	 * @return
	 */
	public static String readFromLocalFile(String filename){
		StringBuilder sb = new StringBuilder("");
		BufferedReader br = null;
		try {
			FileReader fr = new FileReader(new File("doc/"+filename));
			br = new BufferedReader(fr);
			String line = null;
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null) {
					br.close();
					br = null;
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();
	}
	
	/**
	 * 将图片保存到doc目录下
	 * @param bi
	 */
	public static void savePicture(BufferedImage bi){
        try { 
            ImageIO.write(bi, "png", new File("doc/p1.png")); 
        } catch (IOException e) { 
            e.printStackTrace(); 
        }  
	}
}

