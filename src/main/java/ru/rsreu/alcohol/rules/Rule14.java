package ru.rsreu.alcohol.rules;

import ru.rsreu.alcohol.enums.AlcoholVariable;
import ru.rsreu.alcohol.enums.values.DrinkValue;
import ru.rsreu.alcohol.enums.values.PriceValue;
import ru.rsreu.alcohol.enums.values.StrengthValue;
import ru.rsreu.alcohol.enums.values.TasteValue;
import ru.rsreu.expert.system.data.Variable;
import ru.rsreu.expert.system.rule.AbstractRule;

import java.util.List;
import java.util.Optional;

public class Rule14 extends AbstractRule {
    @Override
    public Optional<Variable> apply(List<Variable> variables) {
        super.apply(variables);
        String strength = extractValue(variables, AlcoholVariable.STRENGTH);
        String price = extractValue(variables, AlcoholVariable.PRICE);
        String taste = extractValue(variables, AlcoholVariable.TASTE);
        if (strength.equals(StrengthValue.HIGH.getName())
                && (price.equals(PriceValue.EXPENSIVE.getName()) || taste.equals(TasteValue.IMPORTANT.getName()))) {
            return Optional.of(new Variable(AlcoholVariable.DRINK.getName(), DrinkValue.COGNAC.getName()));
        }
        return Optional.empty();
    }

    @Override
    public String getOutputVariableName() {
        return AlcoholVariable.DRINK.getName();
    }

    @Override
    public List<String> getInputVariableNames() {
        return List.of(
                AlcoholVariable.STRENGTH.getName(),
                AlcoholVariable.PRICE.getName(),
                AlcoholVariable.TASTE.getName()
        );
    }
}