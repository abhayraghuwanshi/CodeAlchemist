package com.odinsolutions.vulcancode_compiler.repo;

import com.odinsolutions.vulcancode_compiler.entity.ProblemTestsCases;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProblemTestsCasesRepo extends JpaRepository<ProblemTestsCases, Long> {

}
