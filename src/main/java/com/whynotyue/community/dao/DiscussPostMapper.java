package com.whynotyue.community.dao;

import com.whynotyue.community.entity.DiscussPost;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface DiscussPostMapper {

    // “首页讨论贴”和“我的帖子”共同该方法，对应的 sql 是动态的：
    // 当 userId 为 0 时，不拼入 sql 中，查询的是“首页讨论贴”；否则拼入，查询“我的帖子”。
    // offset、limit：用于分页，offset：每页起始行行号，limit：每页最多显示多少数据。
    List<DiscussPost> selectDiscussPosts(int userId, int offset, int limit);

    // 查询帖子总数，用于后续计算分页数（总贴数/每页数），对应的 sql 也是动态的；
    // 当 userId 为 0 时，不拼入 sql 中，查询首页总贴数；否则拼入，查询用户帖子总数。
    // @Param()：给参数取别名，
    // 如果方法只有一个参数，且对应 sql 是动态的，后续参数要在 <if> 内使用，就必须加别名；
    int selectDiscussPostRows(@Param("userId") int userId);

    int insertDiscussPost(DiscussPost discussPost);

    DiscussPost selectDiscussPostById(int id);

    int updateCommentCount(int id,int commentCount);
}
