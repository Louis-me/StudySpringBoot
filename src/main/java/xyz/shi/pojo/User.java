package xyz.shi.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@TableName("users")
@Data
public class User {

    private Integer id;
    private String name;
    private String password;
}