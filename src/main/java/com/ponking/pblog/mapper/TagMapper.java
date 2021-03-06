package com.ponking.pblog.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ponking.pblog.model.vo.TagContentPage;
import com.ponking.pblog.model.entity.Tag;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ponking.pblog.model.vo.TagTableCardVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * 标签表 Mapper 接口
 * </p>
 *
 * @author peng
 * @since 2020-03-14
 */
public interface TagMapper extends BaseMapper<Tag> {
    /**
     * 博客右侧栏标签
     * @return
     */
    List<TagTableCardVo> selectTagColumnInfo();


    /**
     * 博客
     * @param page
     * @param queryWrapper
     * @return
     */
    Page<TagContentPage> selectTagInfoPage(IPage<TagContentPage> page, @Param(Constants.WRAPPER) Wrapper<TagContentPage> queryWrapper);
}
