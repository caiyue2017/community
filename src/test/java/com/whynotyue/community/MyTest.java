package com.whynotyue.community;

import com.whynotyue.community.dao.AlphaDao;
import com.whynotyue.community.dao.CommentMapper;
import com.whynotyue.community.entity.Comment;
import com.whynotyue.community.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
public class MyTest {

    @Autowired
    private CommentMapper commentMapper;

    @Test
    public void testInsert() {
        Comment comment;
        // user_id, entity_type, entity_id, target_id, content, status, create_time
        for (int i = 0; i < 6000; i++) {
            comment = new Comment();
            comment.setUserId(155);
            comment.setEntityType(1);
            comment.setEntityId(277);
            comment.setTargetId(0);
            comment.setContent("测试插入：" + i);
            comment.setStatus(0);
            comment.setCreateTime(new Date());
            commentMapper.insertComment(comment);
        }
    }
}
