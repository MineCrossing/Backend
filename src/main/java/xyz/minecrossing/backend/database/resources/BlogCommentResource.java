package xyz.minecrossing.backend.database.resources;


import xyz.minecrossing.backend.database.helpers.EntityToPreparedStatementMapper;
import xyz.minecrossing.backend.database.helpers.QueryBuilder;
import xyz.minecrossing.backend.database.interfaces.IBlogCommentResource;
import xyz.minecrossing.coreutilities.dbmodels.BlogComment;
import xyz.minecrossing.coreutilities.dbmodels.builders.BlogCommentBuilder;

import java.sql.SQLException;
import java.util.stream.Collectors;

public class BlogCommentResource extends MineCrossingResource<BlogComment> implements IBlogCommentResource {

	public BlogCommentResource() {
	}

	protected QueryBuilder queryBuilder() {
		return new QueryBuilder("blog_comments");
	}

	@Override
	public boolean update(BlogComment entity) {
		try {
			var columnsToUpdate = entity
					.getColumnNames()
					.stream()
					.filter(c -> !c.equals(BlogComment.BLOG_COMMENT_ID_COL))
					.collect(Collectors.toList());

			var ps = new EntityToPreparedStatementMapper<>(
					getNamedParamStatement(
							queryBuilder()
									.update(columnsToUpdate)
									.where(BlogComment.BLOG_COMMENT_ID_COL)
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
	public BlogComment find(String key) {
		try {
			var ps = new EntityToPreparedStatementMapper<>(getNamedParamStatement(queryBuilder().select().where(BlogComment.BLOG_COMMENT_ID_COL).build()))
					.mapParams(BlogComment.BLOG_COMMENT_ID_COL, key);

			var resultSet = ps.executeQuery();

			resultSet.first();

			return new BlogCommentBuilder().fromResultSet(resultSet).build();
		} catch (Exception throwables) {
			throwables.printStackTrace();
			return null;
		}
	}
}
