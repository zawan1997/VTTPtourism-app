package com.nawaz.server.models;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

public class CommentMapper implements RowMapper<Comment> {

	@Override
	public Comment mapRow(ResultSet rs, int rowNum) throws SQLException {
		Comment comment = new Comment();
		comment.setId(rs.getInt("id"));
		comment.setUserId(rs.getInt("user_id"));
		comment.setLocationUuid(rs.getString("location_uuid"));
		comment.setText(rs.getString("text"));

		return comment;
	}

}
