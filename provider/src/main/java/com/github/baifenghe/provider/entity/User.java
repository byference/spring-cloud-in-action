package com.github.baifenghe.provider.entity;


import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author bfh
 * @since 1.0.0
 */
@Data
public class User {

    private int size;

    @NotBlank(message = "用户名不能为空")
    private String userName;


}
