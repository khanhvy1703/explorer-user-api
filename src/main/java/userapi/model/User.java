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
    @NonNull
    @Indexed(unique = true)
    String userId;

    @NonNull
    @Indexed(unique = true)
    String userName;

    @NonNull
    @Indexed(unique = true)
    String email;

    String displayName;
    String avatar;
    String createdAt;
    boolean gender;
    List<String> savedRestaurants;
    List<String> reviews;
    List<String> collections;
    List<String> following;
    List<String> followers;

    public User() {};

    public User(String userId, String userName, String email, String createdAt) {
        this.userId = userId;
        this.userName = userName;
        this.email = email;
        this.createdAt = createdAt;
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
