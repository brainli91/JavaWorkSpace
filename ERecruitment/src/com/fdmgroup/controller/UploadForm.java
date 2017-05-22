package com.fdmgroup.controller;
import org.springframework.web.multipart.MultipartFile;

public class UploadForm {
    	 
        public UploadForm() {
			super();
		}

		private MultipartFile resumeFile;

		public MultipartFile getResumeFile() {
			return resumeFile;
		}

		public void setResumeFile(MultipartFile resumeFile) {
			this.resumeFile = resumeFile;
		}

    }