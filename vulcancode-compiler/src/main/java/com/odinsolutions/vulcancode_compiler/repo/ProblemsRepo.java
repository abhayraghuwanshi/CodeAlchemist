package com.odinsolutions.vulcancode_compiler.repo;

import com.odinsolutions.vulcancode_compiler.entity.Problems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemsRepo extends JpaRepository<Problems, Long> {

}
