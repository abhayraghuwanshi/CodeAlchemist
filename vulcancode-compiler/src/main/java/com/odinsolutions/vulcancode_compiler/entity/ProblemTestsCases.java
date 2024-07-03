package com.odinsolutions.vulcancode_compiler.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "problems_tests")
@Data
public class ProblemTestsCases {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id")
    private int id;

    @Column(name="test_case_group_id")
    private int testCasesGroupId;

    @Column(name="test_case")
    private String testCase;

}
