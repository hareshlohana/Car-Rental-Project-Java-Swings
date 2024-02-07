package org.car_rantel.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface Imapper<T> {

    List<T> resultSetToList(ResultSet rs) throws SQLException;

    T resultSetToObject(ResultSet rs) throws SQLException;
}
