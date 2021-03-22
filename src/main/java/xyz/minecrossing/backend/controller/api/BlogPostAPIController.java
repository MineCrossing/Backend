package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.minecrossing.backend.controller.api.requests.CreateBlogRequest;
import xyz.minecrossing.backend.controller.api.viewmodels.BlogPostPreview;
import xyz.minecrossing.backend.controller.api.viewmodels.builders.BlogPostPreviewBuilder;
import xyz.minecrossing.backend.database.MineCrossingDB;
import xyz.minecrossing.backend.database.builders.BlogPostBuilder;
import xyz.minecrossing.backend.database.models.BlogPost;
import xyz.minecrossing.backend.helpers.StringUtils;

import java.time.LocalDateTime;
import java.util.*;
import java.util.stream.Collectors;

@RestController
public class BlogPostAPIController implements BlogPostAPI {
	private final MineCrossingDB db;

	public BlogPostAPIController() {
		db = MineCrossingDB.getInstance();
	}

	private List<BlogPostPreview> toBlogPostPreview(List<BlogPost> blogPosts) {
		if (blogPosts == null)
			return new ArrayList<>();

		return blogPosts
				.stream()
				.filter(b -> !StringUtils.isNullOrEmpty(b.getContent()))
				.map(b -> new BlogPostPreviewBuilder()
						.setAuthor(b.getAuthor())
						.setDate(b.getCreatedDate())
						.setSubtitle(b.getSubtitle())
						.setTitle(b.getTitle())
						.setPreview(Arrays.stream(b.getContent().trim().split(" ")).limit(120).collect(Collectors.joining(" ")))
						.build()
				).collect(Collectors.toList());
	}

	@Override
	public ResponseEntity<List<BlogPostPreview>> getPreviewPosts() {
		var blogPosts = db.BlogPosts.getLatest(3);

		return ResponseEntity.ok(toBlogPostPreview(blogPosts));
	}

	@Override
	public ResponseEntity<List<BlogPostPreview>> getAllPreviewPosts() {
		var blogPosts = db.BlogPosts.findAll();

		return ResponseEntity.ok(toBlogPostPreview(blogPosts));
	}

	@Override
	public ResponseEntity<Boolean> createBlogPost(CreateBlogRequest body) {
		if (body == null || StringUtils.anyNullOrEmpty(body.getContent(), body.getSubtitle(), body.getTitle()))
			return ResponseEntity.badRequest().body(false);

		var user = db.Users.find(body.getUserID());

		if (user == null)
			return ResponseEntity.badRequest().body(false);

		return ResponseEntity.ok(db.BlogPosts.add(new BlogPostBuilder()
				.setBlogPostID(UUID.randomUUID().toString())
				.setAuthor(user.getUsername())
				.setCreatedDate(LocalDateTime.now().minusDays(5 + new Random().nextInt(365)))
				.setTitle(body.getTitle())
				.setSubtitle(body.getSubtitle())
				.setContent(body.getContent())
				.setUserID(user.getUserID())
				.build()
		));
	}
}