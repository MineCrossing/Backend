package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IBlogPostResource;
import xyz.minecrossing.coreutilities.dbmodels.BlogPost;
import xyz.minecrossing.coreutilities.dbmodels.builders.BlogPostBuilder;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.stream.Collectors;

public class BlogPostResource extends MineCrossingResource implements IBlogPostResource {

	public BlogPostResource() {
	}

	private QueryBuilder queryBuilder() {
		return new QueryBuilder("blog_posts");
	}

	@Override
	public boolean add(BlogPost entity) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(queryBuilder().insert(entity.getColumnNames()).build());
			ps.setString(1, entity.getBlogPostID().toString());
			ps.setString(2, entity.getUserID().toString());
			ps.setString(3, entity.getTitle());
			ps.setString(4, entity.getSubtitle());
			ps.setString(5, entity.getAuthor());
			ps.setString(6, entity.getContent());
			ps.setTimestamp(7, java.sql.Timestamp.valueOf(entity.getCreatedDate()));

			ps.execute();
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public boolean update(BlogPost entity) {
		try {
			var columnsToUpdate = entity
					.getColumnNames()
					.stream()
					.filter(c -> !c.equals(BlogPost.BLOG_POST_ID_COL))
					.collect(Collectors.toList());

			PreparedStatement ps = getConnection().prepareStatement(queryBuilder().update(columnsToUpdate).build());
			ps.setString(1, entity.getUserID().toString());
			ps.setString(2, entity.getTitle());
			ps.setString(3, entity.getSubtitle());
			ps.setString(4, entity.getAuthor());
			ps.setString(5, entity.getContent());
			ps.setTimestamp(6, java.sql.Timestamp.valueOf(entity.getCreatedDate()));

			ps.execute();
			ps.close();
		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}

	@Override
	public BlogPost find(String key) {
		try {
			PreparedStatement ps = getConnection().prepareStatement(queryBuilder().select(new BlogPost().getColumnNames()).where(BlogPost.BLOG_POST_ID_COL).build());
			ps.setString(1, key);
			ResultSet rs = ps.executeQuery();
			rs.first();

			return new BlogPostBuilder().fromResultSet(rs).build();
		} catch (Exception throwables) {
			throwables.printStackTrace();
			return null;
		}
	}
}
