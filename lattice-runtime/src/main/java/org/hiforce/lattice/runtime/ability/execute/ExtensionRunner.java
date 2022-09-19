package org.hiforce.lattice.runtime.ability.execute;


import lombok.Getter;
import lombok.Setter;
import org.hifforce.lattice.model.ability.IBusinessExt;
import org.hifforce.lattice.model.business.IBizObject;
import org.hifforce.lattice.model.template.ITemplate;
import org.hiforce.lattice.runtime.ability.ExtensionCallback;

import javax.annotation.Nonnull;
import java.util.List;

/**
 * @author Rocky Yu
 * @since 2022/9/18
 */
public abstract class ExtensionRunner<T, R> {

    @Getter
    @Setter
    private ITemplate template;

    @Getter
    @Setter
    private String extensionCode;

    @Getter
    @Setter
    private T model;

    @Getter
    @Setter
    private int priority = 0;


    public ExtensionRunner(ITemplate template, String extensionCode, T model) {
        this.model = model;

        this.template = template;
        this.extensionCode = extensionCode;
    }

    /**
     * @param
     * @return
     */
    public abstract R runFirstMatched(Object abilityInstance, IBizObject bizInstance,
                                      ExtensionCallback<IBusinessExt, R> callback,
                                      RunnerExecuteResult executeResult);

    @Nonnull
    public abstract List<R> runAllMatched(Object abilityInstance, IBizObject bizInstance,
                                          ExtensionCallback<IBusinessExt, R> callback, RunnerExecuteResult executeResult);

    public abstract ExtensionRunnerType getType();

    public static class RunnerExecuteResult {

        @Getter
        @Setter
        private boolean execute;

        @Getter
        @Setter
        private ExtensionRunnerType runnerType;

    }

    @SuppressWarnings("all")
    public static final class CollectionRunnerExecuteResult extends RunnerExecuteResult {
        private List results;

        public final List getResults() {
            return results;
        }

        public final void setResults(List results) {
            this.results = results;
        }
    }
}