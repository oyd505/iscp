package com.island.iscp.swagger.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(description = "用户查询请求数据")
public class User {

	@ApiModelProperty(value = "用户ID", example = "123")
	private Long id;
	@ApiModelProperty(value = "用户名称", example = "张三")
	private String name;
	@ApiModelProperty(value = "用户年龄", example = "18")
	private Integer age;

}
