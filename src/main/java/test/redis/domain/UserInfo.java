package test.redis.domain;

import lombok.Data;

/**
 * @author sunlei19
 * @create 2019/1/17
 */
@Data
public class UserInfo {
    private String login;
    private String id;
    private String name;
    private String followers;
    private String following;
    private String posts;
    private String signUp;
}
