package domain;

import java.util.List;
import java.util.Set;

public interface TvCreditsInterface {

    // getters for Productions
    Production getProduction(int productionId);
    List<Production> getAllProductions();
    List<Production> getValidatedProductions();
    List<Production> getUnValidatedProductions();
    List<Production> getProductionsFromCreditName(int creditNameId);

    // save & update production (for producers)
    boolean saveProduction(Production prod);
    boolean updateProduction(int productionID, Production replaceProduction);

    // validate productions & credits(for admin)
    void validateProduction(Production prod);
    void invalidateProduction(Production prod);
    void validateCredit(Credit credit);
    void invalidateCredit(Credit credit);
    void deleteProduction(Production production);

    // Credits
    void addCreditToProduction(Credit credit);
    void deleteCredit(Credit credit);
    List<Credit> getUnValidatedCredits(int productionsId);

    // CreditName
    Set<CreditName> getAllCreditNames();
    void addCreditName(CreditName creditName);

    // Methods for Replacing Enums
    List<String> getCreditTypes();
    List<String> getProductionTypes();
    List<String> getLanguages();
    List<String> getGenres();
}
