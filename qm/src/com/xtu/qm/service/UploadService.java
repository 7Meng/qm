package com.xtu.qm.service;

import javax.servlet.ServletContext;

import org.apache.commons.fileupload.FileItem;

import com.xtu.qm.pojo.UserInfo;

public interface UploadService {
	final String LIFE_PHOTO_RELATIVE_PATH = "customer-images/life-photo";
	final String LOGO_IMAGE_RELATIVE_PATH = "customer-images/logo-image";
	/**
	 * ÉÏ´«Í¼Æ¬
	 * @param item
	 * @param user
	 * @param savedPath
	 * @return
	 * @throws Exception 
	 */
	boolean uploadImage(ServletContext context, FileItem item, 
			UserInfo user, String savedPath) throws Exception;
}
