package hu.mik.prog5.z7twzr.mediapatrik.dao;

import hu.mik.prog5.z7twzr.mediapatrik.entity.Role;

import java.util.List;

public interface RoleDao {

    Role findById(Long id);

    List<Role> findByUserId(Long id);

}
