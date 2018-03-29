package com.bizconnect.rest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bizconnect.clib.util.UploadUtil;
import com.bizconnect.model.dbentity.UserProfileImage;
import com.bizconnect.model.usermgmt.ProfileImageResponse;
import com.bizconnect.service.UserMgmtService;

@RestController
@RequestMapping("/upload")
@CrossOrigin(maxAge = 3600 )
public class UploadController {

	private static final Logger logger = LoggerFactory.getLogger(UserMgmtController.class);
	
	@Autowired
	UserMgmtService userMgmtService;
	
	@RequestMapping(method = RequestMethod.POST, value="/uploadImage")
    @ResponseBody
    public ProfileImageResponse profileImageUploader(@RequestParam("userName") String userName,@RequestParam("file") MultipartFile uploader) throws Exception {
    		System.out.println("@@#@#@Coming...profileImageUploader");
    		ProfileImageResponse response = new ProfileImageResponse();
    		String uploadedDir = uploadFile(uploader,UploadUtil.getUserProfileImageUploadDIR());
    		UserProfileImage userProfile = new UserProfileImage();
    		userProfile.setProfileImageUrl(UploadUtil.USER_PROFILE_IMAGES_WEB_ROOT+"/"+uploadedDir);
    		userProfile.setUserName(userName);
    		userMgmtService.saveProfileImage(userProfile);
    		response.setProfileIamgeId(String.valueOf(userProfile.getId()));
      		return response;    		
    }	 

 private String uploadFile( MultipartFile uploader, String uploadDIR) throws Exception{
   		System.out.println("@@#@#@Coming...uploadFile.."+uploadDIR);
		
		String fileName = uploader.getOriginalFilename();
		String todayDir="";

		UploadUtil cd = new UploadUtil();
		todayDir = cd.createDirectory(uploadDIR);
		InputStream inputStream = uploader.getInputStream();	    		
		 
		File file = new File(uploadDIR+"/"+todayDir+"/"+fileName);
		OutputStream outputStream = null;
		
		try{

			// write the inputStream to a FileOutputStream
			outputStream = new FileOutputStream(file);

			int read = 0;
			byte[] bytes = new byte[1024];

			while ((read = inputStream.read(bytes)) != -1) {
				outputStream.write(bytes, 0, read);
			}

			System.out.println("Done! file uploaded to.."+file.getAbsolutePath());

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			if (outputStream != null) {
				try {
					// outputStream.flush();
					outputStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}

			}
		}
			 File file2 = new File(file.getAbsolutePath());
			 if(file2.exists()){
				 file2.setExecutable(true,false);
				 file2.setReadable(true,false);
				 file2.setWritable(true,false);
				 System.out.println("File world permission done..for "+file.getAbsolutePath());
			 }
	    

		return todayDir+"/"+fileName;
 }

 
}
