package com.memoir.submit.entity.memoir;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MemoirRepository extends CrudRepository<Memoir, Long> {

    List<Memoir> findAllBy();
}
