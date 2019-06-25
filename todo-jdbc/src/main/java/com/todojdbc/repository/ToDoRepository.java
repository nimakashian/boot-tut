package com.todojdbc.repository;


import com.todojdbc.domain.ToDo;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.annotation.ManagedBean;
import java.sql.ResultSet;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class ToDoRepository implements CommonRepository<ToDo> {

    private static final String SQL_INSERT = "insert into todo (id, description, created, modified, completed) values (:id,:description,:created,:modified,:completed)";
    private static final String SQL_QUERY_FIND_ALL = "select id, description, created, modified, completed from todo";
    private static final String SQL_QUERY_FIND_BY_ID = SQL_QUERY_FIND_ALL + " where id = :id";
    private static final String SQL_UPDATE = "update todo set description = :description, modified = :modified, completed = :completed where id = :id";
    private static final String SQL_DELETE = "delete from todo where id = :id";

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public ToDoRepository(NamedParameterJdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }

    private RowMapper<ToDo> toDoRowMapper=(ResultSet rs, int roNum) ->{
        ToDo toDo=new ToDo();
        toDo.setId(rs.getString("id"));
        toDo.setDescription(rs.getString("description"));
        toDo.setModified(rs.getTimestamp("modified").toLocalDateTime());
        toDo.setCreated(rs.getTimestamp("created").toLocalDateTime());
        toDo.setCompleted(rs.getBoolean("completed"));
        return toDo;
    };

    @Override
    public ToDo save(ToDo domain) {
        return null;
    }

    @Override
    public Iterable<ToDo> save(Collection<ToDo> domains) {
        return null;
    }

    @Override
    public void delete(ToDo domain) {

    }

    @Override
    public ToDo findById(String id) {
        return null;
    }

    @Override
    public Iterable<ToDo> findAll() {
        return null;
    }
}
