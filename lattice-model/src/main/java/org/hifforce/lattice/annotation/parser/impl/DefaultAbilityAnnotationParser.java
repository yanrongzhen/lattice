package org.hifforce.lattice.annotation.parser.impl;

import com.google.auto.service.AutoService;
import org.hifforce.lattice.annotation.Ability;
import org.hifforce.lattice.annotation.parser.AbilityAnnotationParser;

/**
 * @author Rocky Yu
 * @since 2022/9/16
 */
@AutoService(AbilityAnnotationParser.class)
public class DefaultAbilityAnnotationParser extends AbilityAnnotationParser<Ability> {
    @Override
    public String getCode(Ability annotation) {
        return annotation.code();
    }

    @Override
    public String getName(Ability annotation) {
        return annotation.name();
    }

    @Override
    public String getDesc(Ability annotation) {
        return annotation.desc();
    }

    @Override
    public String getParent(Ability annotation) {
        return annotation.parent();
    }

    @Override
    public Class<Ability> getAnnotationClass() {
        return Ability.class;
    }
}
