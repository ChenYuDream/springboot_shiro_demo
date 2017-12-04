package org.jypj.dev.dao;

        import lombok.extern.slf4j.Slf4j;
        import org.junit.Test;
        import org.junit.runner.RunWith;
        import org.jypj.dev.entity.User;
        import org.springframework.boot.test.context.SpringBootTest;
        import org.springframework.test.context.junit4.SpringRunner;

        import javax.annotation.Resource;

@Slf4j
@SpringBootTest
@RunWith(SpringRunner.class)
public class UserDaoTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void findByUserName() {
        String username = "chenyu";
        User user = userMapper.findByUserName(username);
        System.out.println(user);
    }

    @Test
    public void findUserById() {
        User user = userMapper.selectById("1");
        log.info(user.toString());
    }
}