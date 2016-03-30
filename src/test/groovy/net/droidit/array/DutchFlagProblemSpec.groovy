package net.droidit.array

import spock.lang.Specification
import java.util.Arrays
import net.droidit.array.DutchFlagProblem
import java.util.Random;

public class DutchFlagProblemSpec extends Specification
{
    def "Testing Dutch Flag problem with pivot" () {
        given:
			int limit = new Random().nextInt(12) + 1;
            int[] array = ArrayUtils.generateRandomArray(limit)
            def dutchFlagProblem = new DutchFlagProblem(array, 3)
        when:
            dutchFlagProblem.dutchFlagPartition();
        then:
			dutchFlagProblem.validatePartition() == true
    }
	
	def "Testing Dutch Flag problem with keys" () {
		given:
			int limit = new Random().nextInt(12) + 1;
			int start = new Random().nextInt();
			
			int[] array = ArrayUtils.generateRandomShuffledArray(limit, start, start+3)
			def dutchFlagProblem = new DutchFlagProblem(array, start, start+1, start+2)
		when:
			dutchFlagProblem.dutchPartitionBasedKeys();
		then:
			dutchFlagProblem.validateThreeKeyPartition() == true
	}
}