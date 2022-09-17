package org.hiforce.lattice.test.ability.ext;

import org.hifforce.lattice.model.ability.BusinessExt;

/**
 * @author Rocky Yu
 * @since 2022/9/16
 */
public class BlankSampleBusinessExt extends BusinessExt
        implements SampleBusinessExt {

    @Override
    public String getSampleExtensionPoint_01(String someInput) {
        return "Hello Sample Ext 01";
    }
}
