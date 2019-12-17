package com.huatech.mall.param.log;

import com.huatech.mall.common.base.BaseParam;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * 系统日志请求类
 *
 * @author like
 * @date 2019-12-17 7:49 下午
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class LogParam extends BaseParam {

    /**
     * 操作用户
     */
    private String userName;
    /**
     * 访问地址
     */
    private String uri;
    /**
     * 开始时间
     */
    private Date startTime;
    /**
     * 结束时间
     */
    private String endTime;
    /**
     * 成功状态
     */
    private Integer status;

}