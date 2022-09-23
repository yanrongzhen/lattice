package org.hifforce.lattice.model.config;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import org.hifforce.lattice.exception.LatticeRuntimeException;

import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/9/21
 */
public class ReadonlyBusinessConfig extends BusinessConfig {

    private static final long serialVersionUID = 248112387639393117L;

    public ReadonlyBusinessConfig(String bizCode, List<ProductConfig> products, List<PriorityConfig> priorities) {
        super(bizCode, products, priorities);
    }

    public void setBizCode(String bizCode) {
        throw new LatticeRuntimeException("LATTICE-CORE-003");
    }

    public void setInstalledProducts(List<ProductConfig> installedProducts) {
        throw new LatticeRuntimeException("LATTICE-CORE-003");
    }

    public void setPriorityConfigs(List<PriorityConfig> priorityConfigs) {
        throw new LatticeRuntimeException("LATTICE-CORE-003");
    }
}