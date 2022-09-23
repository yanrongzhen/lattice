package org.hiforce.lattice.test.plugin.business_b.ext;

import org.hifforce.lattice.annotation.Realization;
import org.hiforce.lattice.test.plugin.business_a.ext.BusinessAExt;

import static org.hiforce.lattice.test.plugin.business_b.BusinessB.BUSINESS_B_CODE;

/**
 * @author Rocky Yu
 * @since 2022/9/18
 */
@Realization(codes = BUSINESS_B_CODE)
public class BusinessBExt extends BusinessAExt {

    public static String RETURN_VALUE = "[Business B] ext invoked";

    @Override
    public String getSampleExtensionPoint_01(String someInput) {
        return RETURN_VALUE;
    }
}