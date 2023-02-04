package userapi.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document("users")
@Getter
@Setter
@ToString
@EqualsAndHashCode
@AllArgsConstructor
public class User {
    @Id
    private String userId;

    @Indexed(unique = true)
    private String userName;

    @Indexed(unique = true)
    private String email;

    @Indexed(unique = true)
    private String userToken;

    private String displayName;
    private String avatar;
    private String createdAt;
    private boolean gender;
    private List<String> savedRestaurants;
    private List<String> reviews;
    private List<String> collections;
    private List<String> following;
    private List<String> followers;

    public User() {};

    public User(String userId, String userName, String email, String createdAt, String userToken) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
        this.userToken = userToken;
    }

    public User(String userName, String displayName, String email, String avatar, String createdAt, boolean gender,
                List<String> savedRestaurants, List<String> reviews, List<String> collections, List<String> following,
                List<String> followers) {
        this.userName = userName;
        this.email = email;
        this.displayName = displayName;
        this.avatar = avatar;
        this.createdAt = createdAt;
        this.gender = gender;
        this.savedRestaurants = savedRestaurants;
        this.reviews = reviews;
        this.collections = collections;
        this.following = following;
        this.followers = followers;
    }
}
