package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IBlogCommentResource;
import xyz.minecrossing.coreutilities.dbmodels.BlogComment;
import xyz.minecrossing.coreutilities.dbmodels.builders.BlogCommentBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class BlogCommentResource extends MineCrossingResource implements IBlogCommentResource {

	public BlogCommentResource() {
	}

	private QueryBuilder queryBuilder() {
		return new QueryBuilder("blog_comments");
	}

	@Override
	public boolean add(BlogComment entity) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(queryBuilder().insert(entity.getColumnNames()).build());
			ps.setString(1, entity.getBlogCommentID().toString());
			ps.setString(2, entity.getBlogPostID().toString());
			ps.setString(3, entity.getUserID().toString());
			ps.setString(4, entity.getMessage());
			ps.setTimestamp(5, java.sql.Timestamp.valueOf(entity.getCreatedDate()));

			ps.execute();
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean update(BlogComment entity) {
		try {
			var columnsToUpdate = entity
					.getColumnNames()
					.stream()
					.filter(c -> !c.equals(BlogComment.BLOG_COMMENT_ID_COL))
					.collect(Collectors.toList());

			PreparedStatement ps = getConnection().prepareStatement(queryBuilder().update(columnsToUpdate).build());
			ps.setString(1, entity.getBlogPostID().toString());
			ps.setString(2, entity.getUserID().toString());
			ps.setString(3, entity.getMessage());
			ps.setTimestamp(4, java.sql.Timestamp.valueOf(entity.getCreatedDate()));

			ps.execute();
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public BlogComment find(String key) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(queryBuilder().select(new BlogComment().getColumnNames()).where(BlogComment.BLOG_COMMENT_ID_COL).build());
			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();
			rs.first();

			return new BlogCommentBuilder().fromResultSet(rs).build();
		} catch (Exception throwables) {
			throwables.printStackTrace();
			return null;
		}
	}
}
