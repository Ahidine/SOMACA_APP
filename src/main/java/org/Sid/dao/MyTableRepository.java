package org.Sid.dao;


import org.Sid.entities.MyTable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
public interface MyTableRepository extends JpaRepository<MyTable,Long>{
	public Page<MyTable> findAll(Pageable pageable);
	public Page<MyTable> findByDesignationContains(String mc,Pageable pageable);  

}
