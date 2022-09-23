package org.hifforce.lattice.model.config;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.omg.CORBA.PRIVATE_MEMBER;

import java.io.Serializable;

/**
 * @author Rocky Yu
 * @since 2022/9/21
 */
@Builder
public class ProductConfig implements Serializable {

    private static final long serialVersionUID = -8571944467506060106L;

    @Getter
    @Setter
    private String code;
}