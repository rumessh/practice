package groovy.net.droidit

import spock.lang.Specification
import java.util.Arrays;
import net.droidit.DutchFlagProblem;

public class DutchFlagProblemSpec extends Specification
{
    def "Testing Dutch Flag problem" () {
        given:
            int[] array = {1, 22, 3, 4, 12, 4};
            DutchFlagProblem dutchFlagProblem = new DutchFlagProblem(array, 3);
        when:
            dutchFlagProblem.dutchFlagPartition();
        then:
            expect Arrays.asList(array), contains(Arrays.asList(1, 3, 4, 4, 12, 22))
    }
}