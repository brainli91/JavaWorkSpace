package dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User_Role")
public class UserRoleDTO implements IStorable{
	
	@Id
	@Column(name="UR_PERSON_ID")
	int user_id;
	
	@Column(name="UR_ROLE_ID")
	int role_id;
	
	

}
