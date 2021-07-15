package com.springmvcproject.dao;

import java.util.List;

import com.springmvcproject.model.NewModel;

public interface INewDAO extends GenericDAO<NewModel> {
	List<NewModel> findAll();
}
