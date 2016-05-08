package net.droidit.array

import spock.lang.Specification;

class Array2DSpiralRouteSpec extends Specification {
	
	def "Testing array spiral route finder"() {
		given:
			List<List<Integer>> squareMatrix = Arrays.asList(Arrays.asList(0, 1, 2, 3), Arrays.asList(4, 5, 6, 7), Arrays.asList(8, 9, 10, 11), Arrays.asList(12, 13, 14, 15))
			List<Integer> expectedPath = Arrays.asList(0, 1, 2, 3, 7, 11, 15, 14, 13, 12, 8, 4, 5, 6, 10, 9)
			List<Integer> result = null
		when:
			result = Array2DSpiralRoute.findSpiralRoute(squareMatrix)
		then:
			result == expectedPath
	}
}
