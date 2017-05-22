package com.fdmgroup.model;

import java.sql.Date;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "ER_JOBS")
@NamedQueries({ @NamedQuery(name = "job.findAll", query = "SELECT j FROM Job j"),
    @NamedQuery(name = "job.findCurrentJobs", query = "SELECT j from Job j where j.deadlineDate > CURRENT_DATE "),
    @NamedQuery(name = "job.findJobsPostedByUser", query = "SELECT j FROM Job j WHERE j.jobPoster.email LIKE :email"),
    @NamedQuery(name = "job.findByPoster", query = "select j from Job j where j.jobPoster.id = :posterId") })
public class Job implements IStorable {

  @Id
  @Column(name = "job_id")
  @SequenceGenerator(name = "er_job_sequence", sequenceName = "ER_JOB_SEQ", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "er_job_sequence")
  private long id;

  @Column(name = "title")
  // @NotEmpty(message ="Job Title is required for Job Posting")
  // @Size(min = 2, max = 30, message = "\"${validatedValue}\" is too short for Job
  // Title")
  private String title;

  // @NotEmpty(message ="Job Description should NOT be blank")
  // @Size(max=255, message = "The length of message should be under 255 characters")
  @Column(name = "description")
  private String description;

  // @NotEmpty(message ="Starting Date is Required")
  @Column(name = "start_date")
  private Date startDate;

  @Column(name = "deadline_date")
  private Date deadlineDate;

  @Column(name = "keywords")
  private String keywords;

  @NotNull
  @Column(name = "num_of_positions")
  private int numOfPositions;

  @Enumerated(EnumType.STRING)
  private JobStatus status;

  @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private User jobPoster;

  @OneToMany(mappedBy = "job")
  private Set<JobApplication> jobApplications; // Should be implemented as a sorted set
                                               // (eg. TreeSet)

  public Job() {
    this(null, null, null, null, null, 0, null);
  }

  public Job(String title, String description, Date startDate, Date deadlineDate, String keywords, int numOfPositions,
      User jobPoster) {
    super();
    this.title = title;
    this.description = description;
    this.startDate = startDate;
    this.deadlineDate = deadlineDate;
    this.keywords = keywords;
    this.numOfPositions = numOfPositions;
    this.jobPoster = jobPoster;
    this.jobApplications = new TreeSet<>();
    this.status = JobStatus.ACTIVE;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
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

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Date getDeadlineDate() {
    return deadlineDate;
  }

  public void setDeadlineDate(Date deadlineDate) {
    this.deadlineDate = deadlineDate;
  }

  public String getKeywords() {
    return keywords;
  }

  public void setKeywords(String keywords) {
    this.keywords = keywords;
  }

  public int getNumOfPositions() {
    return numOfPositions;
  }

  public void setNumOfPositions(int numOfPositions) {
    this.numOfPositions = numOfPositions;
  }

  public User getJobPoster() {
    return jobPoster;
  }

  public void setJobPoster(User jobPoster) {
    this.jobPoster = jobPoster;
  }

  public Set<JobApplication> getJobApplications() {
    return jobApplications;
  }

  public void setJobApplications(Set<JobApplication> jobApplications) {
    this.jobApplications = jobApplications;
  }

  public JobStatus getStatus() {
    return status;
  }

  public void setStatus(JobStatus status) {
    this.status = status;
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
    Job other = (Job) obj;
    if (id != other.id)
      return false;
    return true;
  }

  @Override
  public String toString() {
    return "Job [id=" + id + ", title=" + title + ", description=" + description + ", startDate=" + startDate
        + ", deadlineDate=" + deadlineDate + ", keywords=" + keywords + ", numOfPositions=" + numOfPositions
        + ", jobPoster=" + jobPoster + ", status=" + status + "]";
  }

  public static Comparator<Job> sortByID = new Comparator<Job>() {
    @Override
    public int compare(Job j1, Job j2) {
      return Long.compare(j1.getId(), j2.getId());
    }
  };

}
