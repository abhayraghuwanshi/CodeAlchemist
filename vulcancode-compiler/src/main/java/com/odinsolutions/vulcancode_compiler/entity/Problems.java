package com.odinsolutions.vulcancode_compiler.entity;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "all_problems")
@Data
public class Problems {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="problem_id")
    private int id;

    @Column(name="problem_desc")
    private String problemDesc;

    @Column(name="test_case_group_id")
    private String testCasesGroupId;

    @Column(name="fx_name")
    private String fxnName;

}
