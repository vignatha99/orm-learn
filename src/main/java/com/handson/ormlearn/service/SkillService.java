package com.handson.ormlearn.service;

import com.handson.ormlearn.model.Skill;

public interface SkillService {

	Skill findSkill(int id);

	void saveSkill(Skill skill);
}

