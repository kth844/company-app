package dev.tranhuu.models;

import java.time.LocalDate;

public class Task {
	
	private int id;
	private String title;
	private String description;
	private Status status;
	private Employee assignedEmployee;
	private Employee createdBy;
	private LocalDate assignDate;
	private LocalDate dueDate;
	
	public class Builder{
		private String title;
		
		private int id = -1;
		private String description = "";
		private Status status = Status.NEW;
		private Employee assignedEmployee = null;
		private Employee createdBy = null;
		private LocalDate assignDate = LocalDate.now();
		private LocalDate dueDate = LocalDate.now().plusWeeks(1);
		
		public Builder(String title) {
			this.title = title;
		}
		
		public Builder id(int id) {
			this.id = id;
			return this;
		}
		
		public Builder description(String description) {
			this.description = description;
			return this;
		}
		
		public Builder status(Status status) {
			this.status = status;
			return this;
		}
		
		public Builder assignEmployee(Employee assignedEmployee) {
			this.assignedEmployee = assignedEmployee;
			return this;
		}
		
		public Builder createdBy(Employee createdBy) {
			this.createdBy = createdBy;
			return this;
		}
		
		public Builder assignDate(LocalDate assignDate) {
			this.assignDate = assignDate;
			return this;
		}
		
		public Builder dueDate(LocalDate dueDate) {
			this.dueDate = dueDate;
			return this;
		}
		
		public Task build() {
			return new Task(this);
		}
	}
	
	public Task() {
		super();
	}
	
	public Task(Builder builder) {
		this.id = builder.id;
		this.title = builder.title;
		this.description = builder.description;
		this.assignedEmployee = builder.assignedEmployee;
		this.createdBy = builder.createdBy;
		this.assignDate = builder.assignDate;
		this.dueDate = builder.dueDate;
		this.status = builder.status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Employee getAssignedEmployee() {
		return assignedEmployee;
	}

	public void setAssignedEmployee(Employee assignedEmployee) {
		this.assignedEmployee = assignedEmployee;
	}

	public Employee getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Employee createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getAssignDate() {
		return assignDate;
	}

	public void setAssignDate(LocalDate assignDate) {
		this.assignDate = assignDate;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((assignDate == null) ? 0 : assignDate.hashCode());
		result = prime * result + ((assignedEmployee == null) ? 0 : assignedEmployee.hashCode());
		result = prime * result + ((createdBy == null) ? 0 : createdBy.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((dueDate == null) ? 0 : dueDate.hashCode());
		result = prime * result + id;
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Task other = (Task) obj;
		if (assignDate == null) {
			if (other.assignDate != null)
				return false;
		} else if (!assignDate.equals(other.assignDate))
			return false;
		if (assignedEmployee == null) {
			if (other.assignedEmployee != null)
				return false;
		} else if (!assignedEmployee.equals(other.assignedEmployee))
			return false;
		if (createdBy == null) {
			if (other.createdBy != null)
				return false;
		} else if (!createdBy.equals(other.createdBy))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (dueDate == null) {
			if (other.dueDate != null)
				return false;
		} else if (!dueDate.equals(other.dueDate))
			return false;
		if (id != other.id)
			return false;
		if (status != other.status)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", title=" + title + ", description=" + description + ", status=" + status
				+ ", assignedEmployee=" + assignedEmployee + ", createdBy=" + createdBy + ", assignDate=" + assignDate
				+ ", dueDate=" + dueDate + "]";
	}

}