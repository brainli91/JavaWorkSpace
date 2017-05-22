package com.fdmgroup.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name = "ER_APPLICANT_PROFILE")
@NamedQueries({
    @NamedQuery(name = "applicantProfile.findByUserId", query = "SELECT ap FROM ApplicantProfile ap WHERE ap.user.id= :uId"),
    @NamedQuery(name = "applicantProfile.findByEmail", query = "SELECT ap FROM ApplicantProfile ap, User u WHERE u.email = ap.user.email and u.email= :uEmail") })
public class ApplicantProfile implements IStorable {

  @Id
  @Column(name = "applicant_id",  nullable = false)
  @SequenceGenerator(name = "er_applicant_sequence", sequenceName = "ER_APPLICANT_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "er_applicant_sequence")
  private long id;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private User user;

  @Column(name = "address",  length = 128)
  @Size(max=128)
  private String address;

  @Column(name = "primary_phone", length = 32)
  @Size(max=32)
  private String primaryPhone;

  @Column(name = "secondary_phone", length = 32)
  @Size(max=32)
  private String secondaryPhone;

  @Column(name = "interests")
  @Size(max=255)
  private String interests;

  @Column(name = "skills")
  @Size(max=255)
  private String skills;

  @OneToMany(mappedBy = "applicantProfile")
  private List<Education> education;

  @OneToMany(mappedBy = "applicantProfile")
  private List<WorkHistory> workHistory;

  @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private FileEntity resume;

  public ApplicantProfile() {
    super();
  }

  public ApplicantProfile(User user, String address, String primaryPhone, String secondaryPhone, String interests,
      String skills, List<Education> education, List<WorkHistory> workHistory) {
    super();
    this.user = user;
    this.address = address;
    this.primaryPhone = primaryPhone;
    this.secondaryPhone = secondaryPhone;
    this.interests = interests;
    this.skills = skills;
    this.education = education;
    this.workHistory = workHistory;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getPrimaryPhone() {
    return primaryPhone;
  }

  public void setPrimaryPhone(String primaryPhone) {
    this.primaryPhone = primaryPhone;
  }

  public String getSecondaryPhone() {
    return secondaryPhone;
  }

  public void setSecondaryPhone(String secondaryPhone) {
    this.secondaryPhone = secondaryPhone;
  }

  public String getInterests() {
    return interests;
  }

  public void setInterests(String interests) {
    this.interests = interests;
  }

  public String getSkills() {
    return skills;
  }

  public void setSkills(String skills) {
    this.skills = skills;
  }

  public List<Education> getEducation() {
    return education;
  }

  public void setEducation(List<Education> education) {
    this.education = education;
  }

  public List<WorkHistory> getWorkHistory() {
    return workHistory;
  }

  public void setWorkHistory(List<WorkHistory> workHistory) {
    this.workHistory = workHistory;
  }

  public FileEntity getResume() {
    return resume;
  }

  public void setResume(FileEntity resume) {
    this.resume = resume;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (int) (id ^ (id >>> 32));
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    ApplicantProfile other = (ApplicantProfile) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "ApplicantProfile [id=" + id + ", address=" + address + ", primaryPhone=" + primaryPhone
        + ", secondaryPhone=" + secondaryPhone + ", interests=" + interests + ", skills=" + skills + ", education="
        + education + ", workHistory=" + workHistory + "]";
  }

}
