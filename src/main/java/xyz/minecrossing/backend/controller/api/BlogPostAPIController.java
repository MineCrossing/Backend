package xyz.minecrossing.backend.controller.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.minecrossing.backend.controller.api.requests.CreateBlogRequest;
import xyz.minecrossing.backend.controller.api.viewmodels.BlogPostPreview;
import xyz.minecrossing.backend.controller.api.viewmodels.builders.BlogPostPreviewBuilder;
import xyz.minecrossing.backend.database.MineCrossingDB;
import xyz.minecrossing.backend.database.builders.BlogPostBuilder;
import xyz.minecrossing.backend.helpers.StringUtils;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@RestController
public class BlogPostAPIController implements BlogPostAPI {
	private MineCrossingDB db;

	public BlogPostAPIController() {
		db = MineCrossingDB.getInstance();
	}

	@Override
	public ResponseEntity<List<BlogPostPreview>> getPreviewPosts() {
		return ResponseEntity.ok(List.of(
				new BlogPostPreviewBuilder()
					.setTitle("Wow Something great just happened!")
					.setSubtitle("No one thought this thing could ever happen, yet here it is")
					.setAuthor("Matthew Dodds")
					.setDate(LocalDateTime.of(2021,3,1,9,30, 0))
					.setPreview("As a volunteer Sheriff's Deputy, I've been doing surveillance for years. One time I suspected " +
							"an ex-girlfriend of mine was cheating on me, so I tailed her for six nights straight. Turns out..." +
							"She was... With a couple of guys, actually... So... Mystery solved." +
							" Through concentration, I can raise and lower my cholesterol at will. I train my major blood vessels to retract into my body on command")
					.build(),
				new BlogPostPreviewBuilder()
					.setTitle("The Store Is Now Live And Operational")
					.setSubtitle("Jump right in and purchase power-ups, cosmetics, ranks and more!")
					.setAuthor("Jamie Cee")
					.setDate(LocalDateTime.of(2021,2,5,13,30, 0))
					.setPreview("After months of development we are proud to announce the MineCrossing store is now available to all registered users. As you all know, " +
							"the release of many long awaited items has been delayed until the store launch, to give all users an easy and equal way of accessing the new content")
					.build(),
				new BlogPostPreviewBuilder()
					.setTitle("Life On A Beet Farm")
					.setSubtitle("Babies are one of my many areas of expertise. Growing up I performed my own circumcision")
					.setAuthor("D Schrute")
					.setDate(LocalDateTime.of(2021,1,25,9,00, 0))
					.setPreview("Why tip someone for a job I'm capable of doing myself? I can deliver food. I can drive a taxi. I can, and do, cut my own hair. I did however, tip my urologist, because I am unable to pulverize my own kidney stones." +
							" I am fast. To give you a reference point, I am somewhere between a snake and a mongoose... And a panther")
					.build()

		));
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
				.setCreatedDate(LocalDateTime.now())
				.setTitle(body.getTitle())
				.setSubtitle(body.getSubtitle())
				.setContent(body.getContent())
				.setUserID(user.getUserID())
				.build()
		));
	}
}