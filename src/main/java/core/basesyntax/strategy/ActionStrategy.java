package core.basesyntax.strategy;

import core.basesyntax.service.impl.FruitTransaction;
import core.basesyntax.strategy.actions.ActionHandler;
import java.util.List;

public class ActionStrategy {
    private final List<ActionHandler> actions;

    public ActionStrategy(List<ActionHandler> actions) {
        this.actions = actions;
    }

    public ActionHandler get(FruitTransaction.Operation action) {
        return actions
                .stream()
                .filter(a -> a.isApplicable(action))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Action is not specified correctly"));
    }
}
