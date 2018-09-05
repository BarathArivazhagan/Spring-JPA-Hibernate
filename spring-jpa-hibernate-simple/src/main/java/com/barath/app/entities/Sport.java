package com.barath.app.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SPORT")
public class Sport implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7451381680546768245L;

	@Id
	@Column(name="SPORT_ID")
	private long sportId;
	
	@Column(name="SPORT_NAME")
	private String sportName;

	public long getSportId() {
		return sportId;
	}

	public void setSportId(long sportId) {
		this.sportId = sportId;
	}

	public String getSportName() {
		return sportName;
	}

	public void setSportName(String sportName) {
		this.sportName = sportName;
	}

	public Sport(long sportId, String sportName) {
		super();
		this.sportId = sportId;
		this.sportName = sportName;
	}

	public Sport() {
		super();
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (sportId ^ (sportId >>> 32));
		result = prime * result + ((sportName == null) ? 0 : sportName.hashCode());
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
		Sport other = (Sport) obj;
		if (sportId != other.sportId)
			return false;
		if (sportName == null) {
			if (other.sportName != null)
				return false;
		} else if (!sportName.equals(other.sportName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Sport [sportId=" + sportId + ", sportName=" + sportName + "]";
	}
	
	
	

}
