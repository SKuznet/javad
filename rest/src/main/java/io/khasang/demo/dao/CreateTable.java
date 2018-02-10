package io.khasang.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class CreateTable {
    private JdbcTemplate jdbcTemplate;

    public CreateTable() {
    }

    public CreateTable(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public String createTableStatus() {
        try {
            jdbcTemplate.execute("DROP TABLE IF EXISTS cats");
            jdbcTemplate.execute("CREATE TABLE cats \n" +
                    "(\n" +
                    "  id integer NOT NULL,\n" +
                    "  name character varying(255),\n" +
                    "  description character varying,\n" +
                    "  color_id integer,\n" +
                    "  CONSTRAINT cats_pkey PRIMARY KEY (id)\n" +
                    ")");
            return "table created";
        } catch (Exception e) {
            return "Table creation failed" + e;
        }
    }
}
