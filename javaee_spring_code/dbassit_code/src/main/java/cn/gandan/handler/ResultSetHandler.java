package cn.gandan.handler;

import java.sql.ResultSet;

public interface ResultSetHandler<T> {

    Object handle(ResultSet rs);
}
