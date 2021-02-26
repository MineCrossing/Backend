package xyz.minecrossing.backend.database.resources;

import xyz.minecrossing.backend.database.helpers.EntityToPreparedStatementMapper;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IBlogPostResource;
import xyz.minecrossing.coreutilities.dbmodels.BlogPost;
import xyz.minecrossing.coreutilities.dbmodels.builders.BlogPostBuilder;

import java.sql.SQLException;
import java.util.stream.Collectors;

public class BlogPostResource extends MineCrossingResource<BlogPost> implements IBlogPostResource {

	public BlogPostResource() {
	}

	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("blog_posts");
	}

	@Override
	public boolean update(BlogPost entity) {
		try {
			var columnsToUpdate = entity
					.getColumnNames()
					.stream()
					.filter(c -> !c.equals(BlogPost.BLOG_POST_ID_COL))
					.collect(Collectors.toList());

			var ps = new EntityToPreparedStatementMapper<>(
					getNamedParamStatement(
							queryBuilder()
									.update(columnsToUpdate)
									.where(BlogPost.BLOG_POST_ID_COL)
									.build()
					)
			).mapParams(entity);

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
			var ps = new EntityToPreparedStatementMapper<>(getNamedParamStatement(queryBuilder().select().where(BlogPost.BLOG_POST_ID_COL).build()))
					.mapParams(BlogPost.BLOG_POST_ID_COL, key);

			var resultSet = ps.executeQuery();

			resultSet.first();

			return new BlogPostBuilder().fromResultSet(resultSet).build();
		} catch (Exception throwables) {
			throwables.printStackTrace();
			return null;
		}
	}

	@Override
	public boolean delete(String key) {
		try {
			new EntityToPreparedStatementMapper<>(getNamedParamStatement(queryBuilder().delete().where(BlogPost.BLOG_POST_ID_COL).build()))
					.mapParams(BlogPost.BLOG_POST_ID_COL, key)
					.execute();

		} catch (SQLException throwables) {
			throwables.printStackTrace();
			return false;
		}

		return true;
	}
}
