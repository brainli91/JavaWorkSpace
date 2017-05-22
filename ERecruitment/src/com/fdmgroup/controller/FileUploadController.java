package com.fdmgroup.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import com.fdmgroup.dao.ApplicantProfileDAO;
import com.fdmgroup.dao.FileDAO;
import com.fdmgroup.model.ApplicantProfile;
import com.fdmgroup.model.FileEntity;
import com.fdmgroup.model.User;

@Controller
@SessionAttributes(names = {"user"}, types = {User.class})
public class FileUploadController {

	final String SAVE_DIRECTORY = "UploadedFiles";

	@Autowired
	private HttpServletRequest request;

	@Autowired
	@Qualifier("fileDAO")
	private FileDAO fileDao;
	
	@Autowired
	private ApplicantProfileDAO applicantProfileDAO;

	@RequestMapping(value = "/upload", method = RequestMethod.GET)
	public String displayForm(Model model) {
		// model.addAttribute("uploadForm", new UploadForm());
		return "uploadForm";
	}

	@RequestMapping(value = "/savefiles", method = RequestMethod.POST)
	public String saveFiles(UploadForm uploadForm, Model model, @ModelAttribute User user) throws IllegalStateException, IOException {
		ApplicantProfile profile = applicantProfileDAO.getProfileByUserId(user.getId());
		MultipartFile multipartFile = uploadForm.getResumeFile();

		boolean flag = false;
		List<String> fileExtensions = new ArrayList<>();
		fileExtensions.add("pdf");
		fileExtensions.add("docx");
		fileExtensions.add("doc");
		fileExtensions.add("txt");

		if (null != multipartFile) {
			for (String ext : fileExtensions) {
				if (multipartFile.getOriginalFilename().endsWith(ext)){
					flag = true;
					break;
				}
			}
			
			if (flag){
				FileEntity file = new FileEntity();
				file.setFile(multipartFile);
				file.setFilePath(SAVE_DIRECTORY + "/"
						+ multipartFile.getOriginalFilename());
				System.out.println(file.getFilePath());
				file = fileDao.create(file);
				profile.setResume(file);
				String path = request.getServletContext().getRealPath("/");
				try {
					createSaveDirectoryIfNotExists();
					File saveFile = new File(path + file.getFilePath());
					System.out.println(saveFile.getAbsolutePath());
					file.getFile().transferTo(saveFile);
				} catch (IllegalStateException | IOException e) {
					e.printStackTrace();
				}

				applicantProfileDAO.update(profile);
				model.addAttribute("file", multipartFile.getOriginalFilename());
				model.addAttribute("applicantProfile", profile);
				model.addAttribute("successMsg", "Resume successfully uploaded");
				return "profile_form";
			}
		}
		
		String errorMsg = "The only accepted files are PDF, DOC, DOCX and TXT.";
		model.addAttribute("errorMsg", errorMsg);
	    model.addAttribute("applicantProfile", profile);
		
		return "profile_form";
	}
	
	private void createSaveDirectoryIfNotExists() {
		File saveDir = new File(request.getServletContext().getRealPath("/") + SAVE_DIRECTORY);
		if(!saveDir.exists()){
			saveDir.mkdirs();
		}
	}

	@RequestMapping(value ="/" + SAVE_DIRECTORY + "/{fileName:.+}", method = RequestMethod.GET, headers="Accept=*/*")
	public void getFile(HttpServletResponse response, @PathVariable("fileName") String fileName) {
		System.out.println("getFile");
		String path = request.getServletContext().getRealPath("/");
		File file = new File(path + SAVE_DIRECTORY + "/" + fileName).getAbsoluteFile();
		

			//String mimeType = "application/octet-stream";
		
		String mimeType= URLConnection.guessContentTypeFromName(file.getName());
		if(mimeType==null){
			System.out.println("mimetype is not detectable, will take default");
			mimeType = "application/octet-stream";
		}
		
		System.out.println("mimetype : " + mimeType);
		
        response.setContentType(mimeType);
        
        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser 
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("inline; filename=\"" + file.getName() +"\""));

        
        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));
        
        response.setContentLength((int)file.length());


        //Copy bytes from source to destination(outputstream in this example), closes both streams.
        try {
        	InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
			FileCopyUtils.copy(inputStream, response.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public void setRequest(HttpServletRequest request) {
		this.request = request;
	}

	public FileDAO getFileDao() {
		return fileDao;
	}

	public void setFileDao(FileDAO fileDao) {
		this.fileDao = fileDao;
	}

	public ApplicantProfileDAO getApplicantProfileDAO() {
		return applicantProfileDAO;
	}

	public void setApplicantProfileDAO(ApplicantProfileDAO applicantProfileDAO) {
		this.applicantProfileDAO = applicantProfileDAO;
	}
}