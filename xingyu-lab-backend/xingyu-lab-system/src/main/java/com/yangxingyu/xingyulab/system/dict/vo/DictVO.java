package com.yangxingyu.xingyulab.system.dict.vo;

import com.yangxingyu.xingyulab.system.dict.entity.SysDictData;
import lombok.Data;
import java.util.List;

@Data
public class DictVO {
    private Long id;
    private String dictName;
    private String dictType;
    private Integer status;
    private List<SysDictData> dataList;
}
