package com.example.secondkill.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.secondkill.pojo.Goods;
import com.example.secondkill.vo.GoodsVo;
import org.apache.ibatis.annotations.Select;

import java.util.List;



/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zhoubin
 * @since 2022-06-01
 */
public interface GoodsMapper extends BaseMapper<Goods> {
    @Select("SELECT g.id, g.goods_name, g.goods_title, g.goods_stock, g.goods_price, g.goods_img, g.goods_detail, sg.secondkill_price, sg.start_date, sg.end_date, sg.stock_count FROM t_goods AS g LEFT JOIN t_secondkill_goods AS sg ON g.id = sg.goods_id")
    List<GoodsVo> findGoodsVo();
    @Select("SELECT g.id, g.goods_name, g.goods_title, g.goods_img, g.goods_detail, g.goods_price, g.goods_stock, sg.secondkill_price, sg.stock_count, sg.START_date, sg.end_date FROM t_goods g LEFT JOIN t_secondkill_goods AS sg ON g.id = sg.goods_id WHERE g.id=#{goodsId} ")
    GoodsVo findGoodsVoByGoodsId(Long goodsId);
}
