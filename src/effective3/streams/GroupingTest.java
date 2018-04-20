package effective3.streams;

import java.util.*;
import java.util.stream.StreamSupport;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.*;

public class GroupingTest {

    static class BlogPost {

        String title;
        String author;
        BlogPostType type;
        int likes;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public BlogPostType getType() {
            return type;
        }

        public void setType(BlogPostType type) {
            this.type = type;
        }

        public int getLikes() {
            return likes;
        }

        public void setLikes(int likes) {
            this.likes = likes;
        }
    }

    enum BlogPostType {
        NEWS,
        REVIEW,
        GUIDE
    }

    static class Tuple {
        BlogPostType type;
        String author;

        public Tuple(BlogPostType type, String author) {
            this.type = type;
            this.author = author;
        }
    }

    public static void main(String[] args) {


        List<BlogPost> posts = Arrays.asList(new BlogPost());

        Map<BlogPostType, List<BlogPost>> postsPerType = posts.stream().collect(groupingBy(BlogPost::getType));
        Map<Tuple, List<BlogPost>> postsPerTypeAndAuthor = posts.stream().collect(groupingBy(post -> new Tuple(post.getType(),post.getAuthor())));
        Map<BlogPostType, Set<BlogPost>> postsPerType1 = posts.stream().collect(groupingBy(BlogPost::getType,toSet()));
        Map<String, Map<BlogPostType, List<BlogPost>>> map = posts.stream().collect(groupingBy(BlogPost::getAuthor,groupingBy(BlogPost::getType)));
        Map<BlogPostType, Optional<BlogPost>> maxLikesPerPostType = posts.stream().collect(groupingBy(BlogPost::getType, maxBy(comparingInt(BlogPost::getLikes))));
        Map<BlogPostType, String> postsPerType2 = posts.stream().collect(groupingBy(BlogPost::getType, mapping(BlogPost::getTitle, joining(", ", "Post titles: [", "]"))));


    }
}
