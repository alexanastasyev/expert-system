package ru.rsreu.alcohol.rules;

import ru.rsreu.alcohol.enums.AlcoholVariable;
import ru.rsreu.alcohol.enums.values.PriceValue;
import ru.rsreu.expert.system.data.Variable;
import ru.rsreu.expert.system.rule.AbstractRule;

import java.util.List;
import java.util.Optional;

public class Rule8 extends AbstractRule {
    @Override
    public Optional<Variable> apply(List<Variable> variables) {
        super.apply(variables);
        int money = Integer.parseInt(extractValue(variables, AlcoholVariable.MONEY));
        int people = Integer.parseInt(extractValue(variables, AlcoholVariable.PEOPLE));
        if (money > 5000 && people > 5) {
            return Optional.of(new Variable(AlcoholVariable.PRICE.getName(), PriceValue.MEDIUM.getName()));
        }
        return Optional.empty();
    }

    @Override
    public String getOutputVariableName() {
        return AlcoholVariable.PRICE.getName();
    }

    @Override
    public List<String> getInputVariableNames() {
        return List.of(
                AlcoholVariable.MONEY.getName(),
                AlcoholVariable.PEOPLE.getName()
        );
    }
}
