package xyz.minecrossing.backend.database.resources;

import org.junit.jupiter.api.*;
import xyz.minecrossing.backend.database.builders.BlogCommentDTOBuilder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BlogCommentResourceTests {
	private BlogCommentResource blogComments;
	private final int TEST_USER_ID = 666888999;
	private final String TEST_BLOG_POST_ID = "09f8bfec-8b2a-a47f-2cd4-61d2b52a8fe7";
	private final String TEST_BLOG_COMMENT_ID = "8bf8bfec-8b2a-a47f-2cd4-6bb2b52a88ea";

	@BeforeEach
	void setup() {
		blogComments = new BlogCommentResource();
	}

	@Test
	@Order(1)
	void create() {
		boolean result = blogComments.add(new BlogCommentDTOBuilder()
				.setBlogCommentID(TEST_BLOG_COMMENT_ID)
				.setBlogPostID(TEST_BLOG_POST_ID)
				.setUserID(TEST_USER_ID)
				.setMessage("Dolphins get a lot of good publicity for the drowning swimmers they push back to shore, but what you don't hear about is the many people they push farther out to sea.")
				.setCreatedDate(LocalDateTime.now())
				.build()
		);

		assertTrue(result);
	}

	@Test
	@Order(2)
	void find() {
		var blogComment = blogComments.find(TEST_BLOG_COMMENT_ID);
		assertNotNull(blogComment);
	}

	@Test
	@Order(3)
	void update() {
		var updatedMessageValue = "Dolphins aren't smart. They just like pushing things";
		var blogComment = blogComments.find(TEST_BLOG_COMMENT_ID);

		blogComment.setMessage(updatedMessageValue);
		blogComments.update(blogComment);

		blogComment = blogComments.find(TEST_BLOG_COMMENT_ID);
		assertEquals(updatedMessageValue, blogComment.getMessage());
	}

	@Test
	@Order(4)
	void delete() {
		var blogPost = blogComments.find(TEST_BLOG_COMMENT_ID);
		var result = blogComments.delete(blogPost);
		assertTrue(result);
	}
}
