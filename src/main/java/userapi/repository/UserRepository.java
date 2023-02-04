package userapi.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Service;
import userapi.model.User;

@Service
public interface UserRepository extends MongoRepository<User, String> {
    @Query("{userName: '?0'}")
    User findUserByUserName(String userName);

    void deleteUserByUserName(String userName);
}
