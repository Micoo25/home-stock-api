package com.github.dedo_finger2.home_stock.config;

import jakarta.annotation.PostConstruct;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class DatabaseSeeder {
    private final JdbcTemplate jdbcTemplate;

    public DatabaseSeeder(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @PostConstruct
    public void seed() {
        if (this.isSeeded()) {
            return;
        }
        this.jdbcTemplate.execute("insert into inventories (id, created_at) values (1, current_timestamp);");
        this.jdbcTemplate.execute("insert into categories (id, name) values (1, 'food')");
        this.jdbcTemplate.execute("insert into categories (id, name) values (2, 'cleaning')");
        this.jdbcTemplate.execute("insert into categories (id, name) values (3, 'medicine')");
        this.jdbcTemplate.execute("insert into categories (id, name) values (4, 'electronic')");
        this.jdbcTemplate.execute("insert into categories (id, name) values (5, 'toy')");
        this.jdbcTemplate.execute("insert into categories (id, name) values (6, 'personal-hygiene')");
        this.jdbcTemplate.execute("insert into categories (id, name) values (7, 'other')");
    }

    public boolean isSeeded() {
        Integer count = this.jdbcTemplate.queryForObject("select count(*) from inventories", Integer.class);
        if (count == null) return false;
        return count > 0;
    }
}
