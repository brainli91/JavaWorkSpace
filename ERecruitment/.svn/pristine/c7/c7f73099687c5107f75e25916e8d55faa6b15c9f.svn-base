package com.fdmgroup.model;

import java.sql.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "ER_EDUCATION")
public class Education implements IStorable {

  @Id
  @Column(name = "education_id")
  @SequenceGenerator(name = "er_education_sequence", sequenceName = "ER_EDUCATION_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "er_education_sequence")
  private long id;

  @Column(name = "institution")
  private String institution;

  @Column(name = "start_date")
  private Date startDate;

  @Column(name = "end_date")
  private Date endDate;

  @Column(name = "degree")
  private String degree;

  @Column(name = "program")
  private String program;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private ApplicantProfile applicantProfile;

  public Education() {
    super();
  }

  public Education(String institution, Date startDate, Date endDate, String degree, String program,
      ApplicantProfile applicantProfile) {
    super();
    this.institution = institution;
    this.startDate = startDate;
    this.endDate = endDate;
    this.degree = degree;
    this.program = program;
    this.applicantProfile = applicantProfile;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getInstitution() {
    return institution;
  }

  public void setInstitution(String institution) {
    this.institution = institution;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getEndDate() {
    return endDate;
  }

  public void setEndDate(Date endDate) {
    this.endDate = endDate;
  }

  public String getDegree() {
    return degree;
  }

  public void setDegree(String degree) {
    this.degree = degree;
  }

  public String getProgram() {
    return program;
  }

  public void setProgram(String program) {
    this.program = program;
  }

  public ApplicantProfile getApplicantProfile() {
    return applicantProfile;
  }

  public void setApplicantProfile(ApplicantProfile applicantProfile) {
    this.applicantProfile = applicantProfile;
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
    Education other = (Education) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Education [id=" + id + ", institution=" + institution + ", startDate=" + startDate + ", endDate=" + endDate
        + ", degree=" + degree + ", program=" + program + "]";
  }

}
