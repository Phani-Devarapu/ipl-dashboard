package com.phanidevarapu.ipldashboard.ipldashboard.repo;

import org.springframework.data.repository.CrudRepository;

import com.phanidevarapu.ipldashboard.ipldashboard.entity.MatchOutput;

public interface MatchRepo extends CrudRepository<MatchOutput, Long> {

}
