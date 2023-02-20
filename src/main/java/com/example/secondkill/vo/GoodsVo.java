package com.example.secondkill.vo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.example.secondkill.pojo.Goods;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsVo extends Goods {
    private BigDecimal secondkillPrice;
    private Integer stockCount;
    private Date startDate;
    private Date endDate;
}
