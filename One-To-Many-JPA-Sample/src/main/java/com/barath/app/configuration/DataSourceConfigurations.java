package com.barath.app.configuration;

import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;


@Configuration
@ConfigurationProperties(prefix="datasource")
public class DataSourceConfigurations {
	
	
	private Map<String,DataSource> dataSources;

	public Map<String, DataSource> getDataSources() {
		return dataSources;
	}

	public void setDataSources(Map<String, DataSource> dataSources) {
		this.dataSources = dataSources;
	}

	public DataSourceConfigurations(Map<String, DataSource> dataSources) {
		super();
		this.dataSources = dataSources;
	}

	public DataSourceConfigurations() {
		super();
		
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataSources == null) ? 0 : dataSources.hashCode());
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
		DataSourceConfigurations other = (DataSourceConfigurations) obj;
		if (dataSources == null) {
			if (other.dataSources != null)
				return false;
		} else if (!dataSources.equals(other.dataSources))
			return false;
		return true;
	}
	
	
	
	@Component
	protected static class DataSource {
		
		private String driverClassName;
		
		private String url;
		
		private String username;
		
		private String password;

		public String getDriverClassName() {
			return driverClassName;
		}

		public void setDriverClassName(String driverClassName) {
			this.driverClassName = driverClassName;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public String toString() {
			return "DataSource [driverClassName=" + driverClassName + ", url=" + url + ", username=" + username
					+ ", password=" + password + "]";
		}

		public DataSource(String driverClassName, String url, String username, String password) {
			super();
			this.driverClassName = driverClassName;
			this.url = url;
			this.username = username;
			this.password = password;
		}

		public DataSource() {
			super();
		
		}
		
		
	}
	

}
