package io.khasang.demo.service.impl;

import io.khasang.demo.dao.CreateTable;
import io.khasang.demo.service.TableCreationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("tableCreationService")
public class TableCreationServiceImpl implements TableCreationService {
    @Autowired
    private CreateTable createTable;

    @Override
    public String getStatus() {
        return createTable.createTableStatus();
    }
}
