package com.solvd.jaxB.dao.interfaces;

import com.solvd.jaxB.models.PersonJob;

import java.util.List;

public interface IPersonJobDAO extends IAbstractDAO<PersonJob>{
    List<PersonJob> getByPersonId(int id);
    List<PersonJob> getByJobId(int id);
}
