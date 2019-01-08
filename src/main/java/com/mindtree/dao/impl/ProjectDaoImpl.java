package com.mindtree.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.mindtree.dao.ProjectDao;
import com.mindtree.entity.Project;

public class ProjectDaoImpl implements ProjectDao{

	private HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	public ProjectDaoImpl() {
		super();
	}

	@Override
	public String addProject(Project project) {
		Session session=template.getSessionFactory().openSession();
		session.save(project);
		session.beginTransaction().commit();
		return "Project added successfully...";
	}

	@Override
	public String deleteProject(int projectId) {
		template.bulkUpdate("Delete Project where projectId=?", projectId);
		return "project deleted successfully...";
	}

	@Override
	public List<Project> displayAll() {
		return template.loadAll(Project.class);
	}

}
