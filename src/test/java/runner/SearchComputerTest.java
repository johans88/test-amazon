package runner;

import com.nivelics.commons.utils.Hooks;
import org.testng.annotations.Test;
import pages.SearchComputer;

public class SearchComputerTest extends Hooks {
    ThreadLocal<SearchComputer> check = ThreadLocal.withInitial(SearchComputer::new);

    @Test
    public void testSearch() {
        check.get().Search("computadores");
    }

}
