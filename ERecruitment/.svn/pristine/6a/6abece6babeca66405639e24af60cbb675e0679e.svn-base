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
@Table(name = "ER_WORK_HISTORY")
public class WorkHistory implements IStorable {

  @Id
  @Column(name = "work_history_id")
  @SequenceGenerator(name = "er_work_history_sequence", sequenceName = "ER_WORK_HISTORY_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "er_work_history_sequence")
  private long id;

  @Column(name = "employer")
  private String employer;

  @Column(name = "start_date")
  private Date startDate;

  @Column(name = "end_date")
  private Date endDate;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private ApplicantProfile applicantProfile;

  public WorkHistory() {
    super();
  }

  public WorkHistory(String employer, Date startDate, Date endDate, String title, String description,
      ApplicantProfile applicantProfile) {
    super();
    this.employer = employer;
    this.startDate = startDate;
    this.endDate = endDate;
    this.title = title;
    this.description = description;
    this.applicantProfile = applicantProfile;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getEmployer() {
    return employer;
  }

  public void setEmployer(String employer) {
    this.employer = employer;
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

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
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
    WorkHistory other = (WorkHistory) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "WorkHistory [id=" + id + ", employer=" + employer + ", startDate=" + startDate + ", endDate=" + endDate
        + ", title=" + title + ", description=" + description + "]";
  }

}
