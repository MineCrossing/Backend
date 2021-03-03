package xyz.minecrossing.backend.database;


import xyz.minecrossing.backend.database.builders.BlogCommentDTOBuilder;
import xyz.minecrossing.backend.database.builders.BlogPostDTOBuilder;
import xyz.minecrossing.backend.database.builders.UserDTOBuilder;
import xyz.minecrossing.backend.database.models.UserDTO;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.UUID;

public class DBTest {
	static final Integer TEST_USER_ID = 666888999;
	static final String TEST_BLOGPOST_ID = "09f8bfec-8b2a-a47f-2cd4-61d2b52a8fe7";
	static final String TEST_BLOGCOMMENT_ID = "8bf8bfec-8b2a-a47f-2cd4-6bb2b52a88ea";
	static MineCrossingDB db = MineCrossingDB.getInstance();

	public static void runTests() {
		System.out.println("****************** USER TESTS ******************");
		addUser();
		findUser();
		updateUser();
		deleteUser();
		System.out.println();
		System.out.println("****************** BLOG POST TESTS ******************");
		addBlogPost();
		updateBlogPost();
		findBlogPost();
		deleteBlogPost();
		System.out.println();
		System.out.println("****************** BLOG COMMENT TESTS ******************");
		addBlogComment();
		updateBlogComment();
		findBlogComment();
		deleteBlogComment();
	}

	public static void addUser() {
		UUID id = UUID.randomUUID();
		String somewhatUniqueUsername = id.toString().substring(0, new Random().nextInt(5) + (new Random().nextInt(5)));
		System.out.println("Adding user: " + somewhatUniqueUsername);

		boolean result = db.Users.add(new UserDTOBuilder()
				.setUserID(666888999)
				.setRoleID(1)
				.setUsername(somewhatUniqueUsername)
				.setEmail(somewhatUniqueUsername + "@fake.com")
				.setPassword("pass")
				.setAvatarPath("users/default.png")
				.setCreatedDate(LocalDateTime.now())
				.setUpdatedDate(LocalDateTime.now())
				.setEmailVerifiedAt(LocalDateTime.now())
				.build());

		System.out.println(result ? "Successfully added user" : "Failed to add user");
		System.out.println();
	}

	public static void findUser() {
		System.out.println("Finding user with ID: " + TEST_USER_ID);

		UserDTO user = db.Users.find(TEST_USER_ID);

		System.out.println(user == null ? "Failed to find user" : "Found user: " + user.getUsername());
		System.out.println();
	}

	public static void updateUser() {
		var user = db.Users.find(TEST_USER_ID);
		user.setEmail("U" + user.getEmail());
		user.setUsername(user.getUsername() + 1);


		var result = db.Users.update(user);

		System.out.println(result ? "Successfully updated user" : "Failed to update user");
		System.out.println();
	}

	public static void deleteUser() {
		System.out.println(db.Users.delete(db.Users.find(TEST_USER_ID)) ? "Successfully deleted user" : "Failed to delete user");
	}

	public static void addBlogPost() {
		boolean result = db.BlogPosts.add(new BlogPostDTOBuilder()
				.setBlogPostID(TEST_BLOGPOST_ID)
				.setUserID(TEST_USER_ID)
				.setTitle("A Random Blogpost")
				.setSubtitle("Sub-title")
				.setAuthor("Matthew Dodds")
				.setContent("Why tip someone for a job I'm capable of doing myself? I can deliver food. I can drive a taxi. I can, and do, cut my own hair. I did however, tip my urologist, because I am unable to pulverize my own kidney stones.")
				.setCreatedDate(LocalDateTime.now())
				.build());

		System.out.println(result ? "Successfully added Blog Post" : "Failed to add Blog Post");
		System.out.println();
	}

	public static void updateBlogPost() {
		var blogPost = db.BlogPosts.find(TEST_BLOGPOST_ID);
		blogPost.setTitle(blogPost.getTitle() + 1);
		blogPost.setSubtitle(blogPost.getSubtitle() + 1);


		var result = db.BlogPosts.update(blogPost);

		System.out.println(result ? "Successfully updated Blog Post" : "Failed to update Blog Post");
		System.out.println();
	}


	public static void findBlogPost() {
		System.out.println("Finding Blog Post with ID: " + TEST_BLOGPOST_ID);

		var bp = db.BlogPosts.find(TEST_BLOGPOST_ID);

		System.out.println(bp == null ? "Failed to find Blog Post" : "Found Blog Post by: " + bp.getAuthor());
		System.out.println();
	}

	public static void deleteBlogPost() {
		System.out.println(db.BlogPosts.delete(db.BlogPosts.find(TEST_BLOGPOST_ID)) ? "Successfully deleted Blog Post" : "Failed to delete Blog Post");
	}

	public static void addBlogComment() {
		boolean result = db.BlogComments.add(new BlogCommentDTOBuilder()
				.setBlogCommentID(TEST_BLOGCOMMENT_ID)
				.setBlogPostID(TEST_BLOGPOST_ID)
				.setUserID(TEST_USER_ID)
				.setMessage("Dolphins get a lot of good publicity for the drowning swimmers they push back to shore, but what you don't hear about is the many people they push farther out to sea. Dolphins aren't smart. They just like pushing things")
				.setCreatedDate(LocalDateTime.now())
				.build()
		);

		System.out.println(result ? "Successfully added Blog Post Comment" : "Failed to add Blog Post Comment");
		System.out.println();
	}

	public static void updateBlogComment() {
		var blogComment = db.BlogComments.find(TEST_BLOGCOMMENT_ID);
		blogComment.setMessage(blogComment.getMessage() + 1);


		var result = db.BlogComments.update(blogComment);

		System.out.println(result ? "Successfully updated Blog Comment" : "Failed to update Blog Comment");
		System.out.println();
	}

	public static void findBlogComment() {
		System.out.println("Finding Blog Post Comment with ID: " + TEST_BLOGCOMMENT_ID);

		var bp = db.BlogComments.find(TEST_BLOGCOMMENT_ID);

		System.out.println(bp == null ? "Failed to find Blog Post Comment" : "Found Blog Post Comment: " + bp.getKey());
		System.out.println();
	}

	public static void deleteBlogComment() {
		System.out.println(db.BlogComments.delete(db.BlogComments.find(TEST_BLOGCOMMENT_ID)) ? "Successfully deleted Blog Comment" : "Failed to delete Blog Comment");
	}

}