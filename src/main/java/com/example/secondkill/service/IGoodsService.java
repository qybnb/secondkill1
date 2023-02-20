package com.example.secondkill.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.secondkill.pojo.Goods;
import com.example.secondkill.vo.GoodsVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author zhoubin
 * @since 2022-06-01
 */
public interface IGoodsService extends IService<Goods> {

    List<GoodsVo> findGoodsVo();

    GoodsVo findGoodsVoByGoodsId(Long goodsId);

}
