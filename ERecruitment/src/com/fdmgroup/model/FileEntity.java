package com.fdmgroup.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name = "ER_FILES")
@NamedQueries({ @NamedQuery(name = "fileEntity.count", query = "SELECT COUNT(f.filePath) FROM FileEntity f "),
    // @NamedQuery(name = "fileEntity.findAllByUser", query = "SELECT f FROM FileEntity f WHERE f.user = :user")
})
public class FileEntity implements IStorable {

  @Id
  @Column(name = "file_id")
  private long id;

  @OneToOne(mappedBy = "resume")
  private ApplicantProfile applicantProfile;

  @Column(name = "file_path")
  private String filePath;

  @Transient
  private MultipartFile file;

  public FileEntity() {
	super();
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public ApplicantProfile getApplicantProfile() {
    return applicantProfile;
  }

  public void setApplicantProfile(ApplicantProfile applicantProfile) {
    this.applicantProfile = applicantProfile;
  }

  public String getFilePath() {
    return filePath;
  }

  public void setFilePath(String filePath) {
    this.filePath = filePath;
  }

  public MultipartFile getFile() {
    return file;
  }

  public void setFile(MultipartFile file) {
    this.file = file;
    setFilePath(file.getOriginalFilename());
  }

  @Override
  public String toString() {
    return "FileEntity [id=" + id + ", filePath=" + filePath + "]";
  }
   

}
