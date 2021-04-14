package xyz.minecrossing.backend.database.resources;

import org.junit.jupiter.api.*;
import xyz.minecrossing.backend.database.builders.BlogPostBuilder;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BlogPostResourceTests {
	private BlogPostResource blogPosts;
	private final int TEST_USER_ID = 666888999;
	private final String TEST_BLOG_POST_ID = "09f8bfec-8b2a-a47f-2cd4-61d2b52a8fe7";

	@BeforeEach
	void setup() {
		blogPosts = new BlogPostResource();
	}

	@Test
	@Order(1)
	void create() {
		boolean result = blogPosts.add(new BlogPostBuilder()
				.setBlogPostID(TEST_BLOG_POST_ID)
				.setUserID(TEST_USER_ID)
				.setTitle("A Random Blogpost")
				.setSubtitle("Sub-title")
				.setAuthor("Matthew Dodds")
				.setContent("Why tip someone for a job I'm capable of doing myself? I can deliver food. I can drive a taxi. I can, and do, cut my own hair. I did however, tip my urologist, because I am unable to pulverize my own kidney stones.")
				.setCreatedDate(LocalDateTime.now())
				.build());

		assertTrue(result);
	}

	@Test
	@Order(2)
	void find() {
		var blogPost = blogPosts.find(TEST_BLOG_POST_ID);
		assertNotNull(blogPost);
	}

	@Test
	@Order(3)
	void update() {
		var updatedSubtitleValue = "Dwight K Ipsum";
		var blogPost = blogPosts.find(TEST_BLOG_POST_ID);

		blogPost.setSubtitle(updatedSubtitleValue);
		blogPosts.update(blogPost);

		blogPost = blogPosts.find(TEST_BLOG_POST_ID);
		assertEquals(updatedSubtitleValue, blogPost.getSubtitle());
	}

	@Test
	@Order(4)
	void delete() {
		var blogPost = blogPosts.find(TEST_BLOG_POST_ID);
		var result = blogPosts.delete(blogPost);
		assertTrue(result);
	}

	@Test
	@Order(5)
	void getLatest_ReturnsExpectedQuantity() {
		var posts = blogPosts.getLatest(3);
		var expectedCount = 3;

		assertEquals(expectedCount, posts.size());
	}
}
