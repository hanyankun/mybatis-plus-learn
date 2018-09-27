package com.mybatis.plus.mybatisplususe.model;

import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * VIEW
 * </p>
 *
 * @author admin
 * @since 2018-09-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class V1 implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String name;


}
